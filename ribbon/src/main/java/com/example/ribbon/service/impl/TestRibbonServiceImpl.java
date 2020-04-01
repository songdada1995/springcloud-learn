package com.example.ribbon.service.impl;

import com.example.ribbon.constants.ServerConstants;
import com.example.ribbon.service.ITestRibbonService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class TestRibbonServiceImpl implements ITestRibbonService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public String testRibbon(String name) {
        return restTemplate.getForObject("http://"  + ServerConstants.SERVICE_PROVIDER +"/provider/hello?name="+name, String.class);
    }
}
