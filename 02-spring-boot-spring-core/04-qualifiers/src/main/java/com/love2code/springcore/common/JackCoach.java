package com.love2code.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class JackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Track Coach";
    }
}
