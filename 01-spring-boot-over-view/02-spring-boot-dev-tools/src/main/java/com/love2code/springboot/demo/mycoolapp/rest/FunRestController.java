package com.love2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    // expose a new endpoint
    @GetMapping("/workout")
    public String getDailyWorkOut() {
        return "Run hard 500k !";
    }

    // expose a new endpoint
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day !";
    }
}
