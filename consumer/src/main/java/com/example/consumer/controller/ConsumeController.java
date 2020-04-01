package com.example.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RequestMapping("/consumer")
@RestController
public class ConsumeController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String get(@RequestParam String name) {
        return restTemplate.getForEntity("http://PROVIDER/provider/hello?name="+ name,String.class).getBody();
    }
}
