package com.example.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RabbitMqProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProviderApplication.class, args);
    }

}
