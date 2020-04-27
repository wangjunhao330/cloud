package com.wang.producer.service.impl;

import com.wang.producer.component.ThreadPool;
import com.wang.producer.service.TestService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadPoolExecutor;

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
    @Override
    public Object testPool() {
        System.out.println("进入方法");
        ThreadPoolExecutor pool = ThreadPool.getThreadPoolExecutor();
//        Future<Integer> future1 = ThreadPool.getThreadPoolExecutor().submit(() -> {
//            return 100*100;
//        });
//        Future<Integer> future2 = ThreadPool.getThreadPoolExecutor().submit(() -> 200);
//        int num1 = 0;
//        int num2 = 0;
//        try {
//            num1 = future1.get(20, TimeUnit.SECONDS);
//            num2 = future2.get(20, TimeUnit.SECONDS);
//        } catch (InterruptedException | ExecutionException | TimeoutException e) {
//            e.printStackTrace();
//        }
//        return num1+num2;
        System.out.println("--------------");
        System.out.println(pool.getActiveCount());
        System.out.println(pool.getCompletedTaskCount());
        pool.execute(new CustumeRunable());
        pool.execute(new CustumeRunable());
        return 100;
    }

    private class CustumeRunable implements Runnable {

        @Override
        public void run() {
            System.out.println("hello");
        }
    }

}
