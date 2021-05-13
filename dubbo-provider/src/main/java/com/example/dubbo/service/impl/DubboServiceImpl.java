package com.example.dubbo.service.impl;

import com.example.dubbo.service.DubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Service(version = "${service.version}", interfaceClass = DubboService.class)
public class DubboServiceImpl implements DubboService {

    @Override
    public String testDubboMsg1(String name) {
        log.info(">>>>>> dubbo-provider调用 <<<<<<");
        return name + "调用了provider";
    }

}
