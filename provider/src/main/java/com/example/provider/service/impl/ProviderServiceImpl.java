package com.example.provider.service.impl;

import com.example.provider.service.IProviderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProviderServiceImpl implements IProviderService {

    private static AtomicInteger count = new AtomicInteger(0);

    @Value("${server.port}")
    private String port;

    @Override
    public String hello(String name) {
        int countPlus = count.incrementAndGet();
        return "Hi，" + name + "这是第" + countPlus + "次调用接口，端口：" + port;
    }

}
