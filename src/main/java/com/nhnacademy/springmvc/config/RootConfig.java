package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.Base;
import com.nhnacademy.springmvc.repository.UserRepository;
import com.nhnacademy.springmvc.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Base.class)
public class RootConfig {
    @Bean
    public UserRepository userRepository() {
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.register("customer1", "1234", "박고객", "park@customer.com", false);
        userRepository.register("customer2", "1234", "김고객", "kim@customer.com", false);
        userRepository.register("admin", "1234", "한담당", "han@customer.com", true);

        return userRepository;
    }
}
