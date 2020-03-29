package com.example.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient("PROVIDER")//远程服务的name
public interface IService {
    @RequestMapping("/provider/hello")//远程服务的接口地址
    String getProvider();    //远程服务的方法（跟远程服务的方法要相同）
}
