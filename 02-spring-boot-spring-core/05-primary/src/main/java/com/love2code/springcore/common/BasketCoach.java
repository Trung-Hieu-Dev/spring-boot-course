package com.love2code.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Basket Coach";
    }
}
