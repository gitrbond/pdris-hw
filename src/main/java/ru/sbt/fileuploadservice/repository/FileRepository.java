package ru.sbt.fileuploadservice.repository;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Repository
public class FileRepository {
    public void postFile(String fileName, byte[] fileBytes) throws IOException {
        try {
            File file = new File(fileName);
            FileOutputStream fileWriter = new FileOutputStream(file);
            int bytesRed = 0;
            fileWriter.write(fileBytes, 0, bytesRed);
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

    public byte[] getFile(String fileName) throws IOException {
        try {
            File file = new File(fileName);
            int fileSize = (int)file.length();
            byte[] fileBytes = new byte[fileSize];
            FileInputStream fileReader = new FileInputStream(file);
            fileReader.read(fileBytes);
            return fileBytes;
        }
        catch (Exception e){
            e.printStackTrace();
            throw new IOException();
        }
    }
}
