package com.example.zuul.controller;

import com.example.zuul.service.ITestZuulService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestZuulController {

    @Resource
    private ITestZuulService testZuulService;

    @RequestMapping("/zuul")
    public String testZuul(@RequestParam String name){
        return null;
    }
}
