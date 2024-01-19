package com.java.utilities.demo.configuration;

import com.java.utilities.demo.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public User user(){
        User user = new User();
        user.setUsername("Test User");
        user.setPassword("dn4evdsat@");
        return user;
    }
}
