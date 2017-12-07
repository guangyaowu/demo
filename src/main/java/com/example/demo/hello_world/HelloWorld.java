package com.example.demo.hello_world;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorld {


    @RequestMapping("/hello-world-json")
    String home() {
        System.out.println("hello world !");
        return "Hello World!";
    }


}
