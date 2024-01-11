package com.love2code.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component // create Bean and tell Spring this is a dependency.
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In the instructor: " + getClass().getSimpleName());
    }

    // define custom Bean init
    @PostConstruct
    public void customBeanInit() {
        System.out.println("Custom Bean Init: " + getClass().getSimpleName());
    }

    // define custom Bean destroy
    @PreDestroy
    public void customBeanDestroy() {
        System.out.println("Custom Bean destroy: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!!";
    }
}
