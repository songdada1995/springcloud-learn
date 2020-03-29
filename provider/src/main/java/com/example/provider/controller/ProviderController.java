package com.example.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @RequestMapping("/provider/hello")
    public String getProvider() {
        return "Feign调用成功";
    }
}
