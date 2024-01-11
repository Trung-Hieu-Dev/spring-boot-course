package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    // get users and roles from DB
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");

        // define query to retrieve the authorities / roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");

        return jdbcUserDetailsManager;

        /*
         * user: john, pass: fun123 , EMPLOYEE
         * user: mary, pass: fun123, MANAGER
         * susan: susan, pass: fun123, ADMIN
        * */
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                                           configurer
                                                   .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                                                   .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                                                   .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                                                   .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                                                   .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

        http.httpBasic(Customizer.withDefaults()); // define using basic authentication

        http.csrf(csrf -> csrf.disable()); // disable csrf

        return http.build();
    }

    /* hard code to create users

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                               .username("john")
                               .password("{noop}test123")
                               .roles("EMPLOYEE")
                               .build();

        UserDetails marry = User.builder()
                                .username("mary")
                                .password("{noop}test123")
                                .roles("EMPLOYEE", "MANAGER")
                                .build();

        UserDetails susan = User.builder()
                                .username("susan")
                                .password("{noop}test123")
                                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                                .build();

        return new InMemoryUserDetailsManager(john, marry, susan);
    }
*/
}
