package com.example.dubbo.web;

import com.example.dubbo.service.DubboConsumerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/dubbo/consumer")
@RestController
public class DubboConsumerController {

    @Resource
    private DubboConsumerService dubboConsumerService;

    @RequestMapping(value = "/testDubbo/{username}", method = RequestMethod.GET)
    public String testDubbo(@PathVariable String username) {
        return dubboConsumerService.consumerDubboMsg1(username);
    }


}
