package com.example.hystrix.service.impl;

import com.example.hystrix.service.ITestHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class TestHystrixServiceImpl implements ITestHystrixService {

    @Override
    @HystrixCommand(fallbackMethod = "processError")
    public String testHystrix(String name) {
        if(!"宋大大".equals(name)){
            throw new IllegalArgumentException("非法参数");
        }
        return name + ", 你可真帅！";
    }

    private String processError(String name){
        return "Sorry, " + name + ", this server has done.";
    }
}
