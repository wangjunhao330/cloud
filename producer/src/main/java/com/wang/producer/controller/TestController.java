package com.wang.producer.controller;

import com.wang.producer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/4/27 15:14
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/pool")
    public Object poolTest() {
        return testService.testPool();
    }
}
