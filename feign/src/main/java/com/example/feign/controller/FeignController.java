package com.example.feign.controller;

import com.example.feign.api.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private IService iService;

    @RequestMapping("/index")
    public String index() {
        return iService.hello();
    }
}
