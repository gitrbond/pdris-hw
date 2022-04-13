package ru.sbt.fileuploadservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.sbt.fileuploadservice.service.UploadService;

import java.io.IOException;

@RestController
@RequestMapping("api/fileservice")
public class UploadController {
    private final UploadService service;

    public UploadController(UploadService service) {
        this.service = service;
    }

    @PostMapping(value = "/file", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public void postFile(@RequestParam String filename, @RequestPart(name = "file") byte[] content) {
        try {
            service.postFile(filename, content);
        } catch (IOException e) {
            System.out.println("An IO Error ocurred");
        }
    }

    @GetMapping("/getFile")
    public byte[] getFile(@RequestParam String filename) {
        try {
            return service.getFile(filename);
        } catch (IOException e) {
            System.out.println("An IO Error ocurred");
        }
        return new byte[0];
    }
}
