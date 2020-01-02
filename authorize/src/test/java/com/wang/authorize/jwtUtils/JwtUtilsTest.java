package com.wang.authorize.jwtUtils;

import org.junit.Test;

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
class JwtUtilsTest {

    @Test
    void createJwt() {
        Map<String, Object> map = new HashMap<>(8);
        map.put("username", "haha");
        map.put("rule", "admin");
        map.put("passwd", "123456");
        map.put("tel", 123);
        String str = JwtUtils.createJwt("admin", "test", map, "jwttest");
        System.out.println(str);
    }

    @Test
    void parseJwt() {
    }
}