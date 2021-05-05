package com.example.feign.web;

import com.example.feign.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Resource
    private IService iService;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return iService.hello(name);
    }
}
