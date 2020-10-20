package ru.sbt.spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;

public class SerializationExample {

    public static void main(String[] args) throws JsonProcessingException {
        Person ivan = new Person("Ivan", 24, 190);
        Person sergey = new Person("Sergey", 33, 183);

        printPerson(ivan);
        printPerson(sergey);

        String ivanFile = "ivan.serial";
        writeToFile(ivanFile, ivan);
        String sergeyFile = "sergey.serial";
        writeToFile(sergeyFile, sergey);

        Person newIvan = readFromFile(ivanFile);
        Person newSergey = readFromFile(sergeyFile);

        printPerson(newIvan);
        printPerson(newSergey);
    }

    private static PrintStream printPerson(Person p) {
        return System.out.printf("Person ref: %s \tName: %s \t Age: %d %n", p, p.getName(), p.getAge());
    }

    private static Person readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Person) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private static void writeToFile(String filename, Person p) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(p);
            System.out.println("File has been written");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Person implements Serializable {
    private transient String name;
    private int age;
    private double height;

    Person(String n, int a, double h) {
        name = n;
        age = a;
        height = h;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    double getHeight() {
        return height;
    }
}