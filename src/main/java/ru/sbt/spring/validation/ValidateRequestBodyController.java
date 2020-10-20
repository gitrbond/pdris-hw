package ru.sbt.spring.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
class ValidateRequestBodyController {
    @PostMapping("/validateBody")
    ResponseEntity<String> validateBody(@Valid @RequestBody Input input) {
        return ResponseEntity.ok("valid");
    }
}