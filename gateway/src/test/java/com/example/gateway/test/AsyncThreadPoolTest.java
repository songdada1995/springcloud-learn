package com.example.gateway.test;

import com.example.gateway.GatewayApplication;
import com.example.gateway.task.TestAsyncThreadPoolTask;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GatewayApplication.class)
@WebAppConfiguration
public class AsyncThreadPoolTest {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Ignore
    @Test
    public void testPool(){
        try {
            for (int i = 1; i <= 100; i ++){
                TestAsyncThreadPoolTask testAsyncThread = new TestAsyncThreadPoolTask(i);
                threadPoolTaskExecutor.execute(testAsyncThread);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
