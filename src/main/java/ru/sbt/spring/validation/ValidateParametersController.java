package ru.sbt.spring.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("validate")
@Validated
class ValidateParametersController {
  @GetMapping("/pathVariable/{id}")
  ResponseEntity<String> validatePathVariable(@PathVariable("id") @Min(5) int id) {
    return ResponseEntity.ok("valid");
  }

  @GetMapping("/requestParameter")
  ResponseEntity<String> validateRequestParameter(@RequestParam("param") @Min(5) int param) {
    return ResponseEntity.ok("valid");
  }
}

