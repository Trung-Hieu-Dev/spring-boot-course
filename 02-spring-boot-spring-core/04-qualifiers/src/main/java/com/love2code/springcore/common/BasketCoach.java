package com.love2code.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BasketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Basket Coach";
    }
}
