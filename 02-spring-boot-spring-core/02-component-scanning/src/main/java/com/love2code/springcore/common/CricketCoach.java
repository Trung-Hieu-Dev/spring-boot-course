package com.love2code.springcore.common;

import org.springframework.stereotype.Component;

@Component // create Bean and tell Spring this is a dependency.
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!!";
    }
}
