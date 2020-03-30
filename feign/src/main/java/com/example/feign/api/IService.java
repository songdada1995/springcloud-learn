package com.example.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("PROVIDER")//远程服务的实例名
public interface IService {

    @RequestMapping("/provider/hello")
    String hello();
}
