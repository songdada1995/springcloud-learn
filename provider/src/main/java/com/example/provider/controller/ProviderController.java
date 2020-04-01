package com.example.provider.controller;

import com.example.provider.service.IProviderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Resource
    private IProviderService providerService;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return providerService.hello(name);
    }
}
