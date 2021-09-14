package com.srysoft.springboot.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.System.currentTimeMillis;

@RestController
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/")
    public String helloWorld() {

        Long currentTime = System.currentTimeMillis();

        LOGGER.info("current time in millisecond : " + currentTime);




        return "Welcome to Spring Boot tutorial !!";
    }

}
