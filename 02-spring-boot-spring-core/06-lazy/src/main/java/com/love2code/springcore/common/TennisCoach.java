package com.love2code.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("In the instructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Tennis Coach";
    }
}
