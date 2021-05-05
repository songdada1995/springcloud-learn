package com.example.zuul;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ZuulApplication.class})
public class ZuulApplicationTests {

    @Test
    public void test1() {
        System.out.println("eeeeeeeee");
    }

}
