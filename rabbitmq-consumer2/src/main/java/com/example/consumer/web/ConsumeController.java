package com.example.consumer.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api_2")
@RestController
public class ConsumeController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "token") String token,
                        @RequestParam(value = "var1", required = false) String var1) {
        System.out.println("参数token：" + token);
        System.out.println("参数var1：" + var1);
        return "consumer2接收到路由消息:" + token + "；" + var1;
    }

}
