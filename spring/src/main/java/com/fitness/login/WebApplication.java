package com.fitness.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
 
@ComponentScan
@EnableAutoConfiguration
public class WebApplication {
 
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebApplication.class);
        application.run(args);
    }
}
