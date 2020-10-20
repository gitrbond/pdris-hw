package ru.sbt.spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionHandlerController {
    @GetMapping("/error")
    public String getHello() {
        throw new IllegalArgumentException();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleException(IllegalArgumentException e) {
        return new ResponseEntity<>("expected exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
