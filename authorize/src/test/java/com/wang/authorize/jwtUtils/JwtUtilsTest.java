package com.wang.authorize.jwtUtils;

import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt测试类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/1/2 12:13
 * @since JDK 1.8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtUtilsTest {
    @Autowired
    private JwtUtils jwtUtils;
    @Test
    public void createJwt() {
        Map<String, Object> map = new HashMap<>(8);
        map.put("username", "haha");
        map.put("rule", "admin");
        map.put("passwd", "123456");
        map.put("tel", 123);
        String str = jwtUtils.createJwt("admin", "test", map, "jwttest");
        System.out.println(str);
    }

    @Test
    public void parseJwt() {
        Claims claims = jwtUtils.parseJwt("eyJhbGciOiJIUzI1NiJ9.eyJydWxlIjoiYWRtaW4iLCJ0ZWwiOjEyMywiZXhwIjoxNTc4MDczOTU2LCJwYXNzd2QiOiIxMjM0NTYiLCJpYXQiOjE1NzgwNjY3NTYsInVzZXJuYW1lIjoiaGFoYSJ9.NMAFmPgcyWiaJIJMFaJaX6AjbJ7lVmF-stnrZu03grU");
        System.out.println(claims.get("passwd"));
        System.out.println(claims.getExpiration());
        System.out.println(claims.get("username"));
    }
}