package com.example.hystrix.web;

import com.example.hystrix.service.ITestHystrixService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestHystrixController {

    @Resource
    private ITestHystrixService testHystrixService;

    @RequestMapping("/test/hystrix")
    public String testHystrix(@RequestParam String name){
        return testHystrixService.testHystrix(name);
    }

}
