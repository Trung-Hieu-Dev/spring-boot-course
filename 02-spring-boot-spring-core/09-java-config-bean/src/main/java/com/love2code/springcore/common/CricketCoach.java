package com.love2code.springcore.common;

import org.springframework.stereotype.Component;

@Component // create Bean and tell Spring this is a dependency.
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In the instructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!!";
    }
}
