package com.example.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumeController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("consumer/hello")
    public String get() {
        return restTemplate.getForEntity("http://PROVIDER/provider/hello",String.class).getBody();
    }
}
