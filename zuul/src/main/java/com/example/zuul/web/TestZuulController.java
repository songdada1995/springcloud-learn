package com.example.zuul.web;

import com.example.zuul.service.ITestZuulService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestZuulController {

    @Resource
    private ITestZuulService testZuulService;

    @RequestMapping(value = "/zuul", method = RequestMethod.POST)
    public String testZuul(@RequestParam String name){
        return null;
    }
}
