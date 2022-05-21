package ru.sbt.fileuploadservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.sbt.fileuploadservice.repository.FileRepository;

import java.io.IOException;

@Service
public class UploadService {
    private final FileRepository repository;

    public UploadService(FileRepository repository) {
        this.repository = repository;
    }

    public byte[] getFile(String fileName) throws IOException {
        return repository.getFile(fileName);
    }

    public void postFile(String fileName, MultipartFile file) throws IOException {
        repository.postFile(fileName, file);
    }
}
