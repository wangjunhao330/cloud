package com.wang.producer.service.impl;

import com.wang.producer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 测试service实现类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/4/27 15:16
 * @since JDK 1.8
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;
    @Override
    public Object testPool() {
        Future<Integer> future1 = threadPoolExecutor.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getThreadGroup());
            return 100*100;
        });
        Future<Integer> future2 = threadPoolExecutor.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getThreadGroup());
            return 10+10;
        });
        int num1 = 0;
        int num2 = 0;
        try {
            num1 = future1.get(10, TimeUnit.SECONDS);
            num2 = future2.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        return num1+num2;
    }

    private class CustumeRunable implements Runnable {

        @Override
        public void run() {
            System.out.println("hello");
        }
    }

}
