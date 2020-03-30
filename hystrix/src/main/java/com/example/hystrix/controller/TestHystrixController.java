package com.example.hystrix.controller;

import com.example.hystrix.service.ITestHystrixService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestHystrixController {

    @Resource
    private ITestHystrixService iTestHystrixService;

    @RequestMapping("/hystrix")
    public String testHystrix(@RequestParam String key){
        try {
            return iTestHystrixService.testHystrix(key);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}
