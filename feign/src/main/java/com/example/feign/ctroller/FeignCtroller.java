package com.example.feign.ctroller;

import com.example.feign.api.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignCtroller {

    @Autowired
    private IService iService;

    @RequestMapping("provider/hello")
    public String getProvider() {
        return iService.getProvider();
    }
}
