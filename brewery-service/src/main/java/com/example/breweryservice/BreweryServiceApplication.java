package com.example.breweryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BreweryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BreweryServiceApplication.class, args);
    }

}
