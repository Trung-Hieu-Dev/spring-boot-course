package com.love2code.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("In the instructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Tennis Coach";
    }
}
