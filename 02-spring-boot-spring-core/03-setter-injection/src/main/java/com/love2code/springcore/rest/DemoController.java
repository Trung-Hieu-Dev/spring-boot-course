package com.love2code.springcore.rest;

import com.love2code.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define private field for the dependency
    private Coach myCoach;

//    @Autowired // tell Spring to inject the dependency. If you have only one constructor, this is optional.
//    public DemoController(Coach myCoach) {
//        this.myCoach = myCoach;
//    }

    @Autowired
    public void doSomeStuff(Coach theCoach) { // setter injection
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }
}
