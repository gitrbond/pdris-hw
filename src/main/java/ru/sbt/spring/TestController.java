package ru.sbt.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class TestController {
    public static final String URL = "URL Format : [scheme]://[Domain][Port]/hello/24?param=5";

    @GetMapping("hello")
    public String getHello() {
        return "Hello, world";
    }
}
