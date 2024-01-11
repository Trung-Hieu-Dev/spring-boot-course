package com.love2code.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class JackCoach implements Coach{
    public JackCoach() {
        System.out.println("In the instructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Track Coach";
    }
}
