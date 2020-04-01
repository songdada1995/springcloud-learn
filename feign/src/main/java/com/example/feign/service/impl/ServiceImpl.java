package com.example.feign.service.impl;

import com.example.feign.service.IService;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements IService {

    @Override
    public String hello(String name) {
        return "sorry，" + name + "，the server has done.";
    }
}
