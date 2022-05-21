package ru.sbt.fileuploadservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.sbt.fileuploadservice.service.UploadService;

import java.io.IOException;

@RestController
@RequestMapping("api/fileservice")
public class UploadController {
    private final UploadService service;

    public UploadController(UploadService service) {
        this.service = service;
    }

    //@PostMapping(value = "/saveFile", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }) // doesnt work for http requests, sorry
    @RequestMapping(value = "/saveFile", method = { RequestMethod.GET, RequestMethod.POST }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> postFile(@RequestParam("filename") String filename, @RequestPart("content") MultipartFile content) {
        try {
            service.postFile(filename, content);
        } catch (IOException e) {
            System.out.println("An IO Error ocurred during post");
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getFile", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public byte[] getFile(@RequestParam("filename") String fileName) {
        try {
            return service.getFile(fileName);
        } catch (IOException e) {
            System.out.println("An IO Error ocurred during get");
            return new byte[0];
        }
    }
}
