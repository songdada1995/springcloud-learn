package com.example.hystrix.service.impl;

import com.example.hystrix.service.ITestHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestHystrixServiceImpl implements ITestHystrixService {

    @Value("${server.port}")
    private String port;

    @Override
    @HystrixCommand(fallbackMethod = "exceptionProcess")
    public String testHystrix(String key) throws Exception {
        if("宋大大".equals(key)){
            return "the " + key + " from port:" + port;
        } else {
            throw new RuntimeException("夭寿啦，异常");
        }
    }

    public String exceptionProcess(String key){
        return  "Sorry, 2333 " + key + ", TestHystrixService 出现异常, 被hystrix断路器熔断";
    }

}
