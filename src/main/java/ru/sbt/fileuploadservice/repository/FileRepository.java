package ru.sbt.fileuploadservice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;

@Repository
public class FileRepository {
    public void postFile(String fileName, MultipartFile file) {
        try {
          Files.write(Path.of(fileName), file.getBytes());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] getFile(String fileName) {
        try {
            return Files.readAllBytes(Path.of(fileName));
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(Path.of(fileName).toAbsolutePath());
        }
        return new byte[0];
    }
}
