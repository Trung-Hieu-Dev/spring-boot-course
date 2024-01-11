package com.love2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // inject properties for: coach.name, coach.team
    @Value("${coach.name}")
    private String coachName;

    @Value("${coach.team}")
    private String teamName;


    // expose endpoints
    @GetMapping("/teaminfo")
    public String teamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWorkOut() {
        return "Run hard 500k !";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day !";
    }
}
