package com.luv2code.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {
        // simulate delay
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        // return fortune
        return "Expect heavy traffic this morning";
    }
    
    @Override
    public String getFortune(boolean stripWire) {
        if (stripWire) {
            throw new RuntimeException("Major accident, high way is closed!");
        }
        
        return getFortune();
    }
}
