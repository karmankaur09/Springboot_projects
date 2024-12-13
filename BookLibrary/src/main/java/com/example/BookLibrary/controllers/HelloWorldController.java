package com.example.BookLibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @GetMapping("/Hello")
    @ResponseBody
    public String printHelloWorld(){
        return "Hello World from Controller";
    }
}
