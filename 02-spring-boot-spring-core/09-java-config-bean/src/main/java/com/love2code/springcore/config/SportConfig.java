package com.love2code.springcore.config;

import com.love2code.springcore.common.Coach;
import com.love2code.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// define Bean for SwimCoach class that does not declare @Component
@Configuration // define Bean
public class SportConfig {
    @Bean("swimCoach") // define Bean Id
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
