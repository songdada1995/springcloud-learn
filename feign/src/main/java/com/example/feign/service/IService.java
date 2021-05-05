package com.example.feign.service;

import com.example.feign.service.impl.ServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "PROVIDER", fallback = ServiceImpl.class)//远程服务的实例名
public interface IService {

    @RequestMapping("/provider/hello")
    String hello(@RequestParam String name);
}
