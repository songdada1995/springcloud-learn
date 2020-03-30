package com.example.hystrix;

import com.example.hystrix.service.ITestHystrixService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HystrixApplicationTests {

    @Resource
    private ITestHystrixService iTestHystrixService;

    @Test
    public void contextLoads() {
        System.out.println("test");
        try {
            System.out.println(iTestHystrixService.testHystrix("宋大大"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
