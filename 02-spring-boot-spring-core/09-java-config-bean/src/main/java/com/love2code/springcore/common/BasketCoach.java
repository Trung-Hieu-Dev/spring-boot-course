package com.love2code.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BasketCoach implements Coach{
    public BasketCoach() {
        System.out.println("In the instructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Basket Coach";
    }
}
