package com.example.dubbo.service.impl;

import com.example.dubbo.service.DubboConsumerService;
import com.example.dubbo.service.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class DubboConsumerServiceImpl implements DubboConsumerService {

    @Reference(check = false, version = "${service.version}", interfaceClass = DubboService.class)
    DubboService dubboService;

    @Override
    public String consumerDubboMsg1(String username) {
        return dubboService.testDubboMsg1(username);
    }
}
