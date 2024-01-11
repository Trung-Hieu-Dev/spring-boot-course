package com.luv2code.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                               .username("john")
                               .password("{noop}test123")
                               .roles("EMPLOYEE")
                               .build();
        
        UserDetails mary = User.builder()
                               .username("mary")
                               .password("{noop}test123")
                               .roles("EMPLOYEE", "MANAGER")
                               .build();
        
        UserDetails susan = User.builder()
                                .username("susan")
                                .password("{noop}test123")
                                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                                .build();
        
        return new InMemoryUserDetailsManager(john, mary, susan);
    }
    
    
    // customize spring security
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                                           configurer
                                                   .requestMatchers("/").hasRole("EMPLOYEE") // access to all pages with role EMPLOYEE
                                                   .requestMatchers("/leaders/**").hasRole("MANAGER") // access to all pages start with /leaders/** by role MANAGER only
                                                   .requestMatchers("/systems/**").hasRole("ADMIN") // access to all pages start with /systems/** by role ADMIN only
                                                   .anyRequest().authenticated()) // if logged in -> access to all pages, else access redirect to login form
            .formLogin(form -> form
                    .loginPage("/showMyLoginPage") // url for showing login form (LoginController)
                    .loginProcessingUrl( //  POST request to authenticate: /authenticateTheUser (default by Spring Boot Security)
                            "/authenticateTheUser") //  <form th:action="@{/authenticateTheUser}" method="post" class="form-horizontal">
                    .permitAll())
            .logout(LogoutConfigurer::permitAll)
            .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));
        
        return http.build();
    }
}

