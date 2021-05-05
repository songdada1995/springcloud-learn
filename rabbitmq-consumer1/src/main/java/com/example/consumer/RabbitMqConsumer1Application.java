package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RabbitMqConsumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqConsumer1Application.class, args);
    }

}
