package com.example.ribbon.web;

import com.example.ribbon.service.ITestRibbonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestRibbonController {

    @Resource
    private ITestRibbonService testRibbonService;

    @RequestMapping("/ribbon")
    public String testRibbon(@RequestParam String name){
        return testRibbonService.testRibbon(name);
    }

}
