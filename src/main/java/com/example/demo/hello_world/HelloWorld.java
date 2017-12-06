package com.example.demo.hello_world;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@Controller
@EnableAutoConfiguration
public class HelloWorld {


    @RequestMapping("/hello-world-json")
    @ResponseBody
    String home() {
        System.out.println("hello world !");
        return "Hello World!";
    }
    @RequestMapping("/hello-world-page")
    String page() {
        return "demo/hello_world/hello_world";
    }

}
