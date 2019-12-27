package com.wang.common;

import com.wang.common.jwtUtils.JwtUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2019/12/27 18:14
 * @since JDK 1.8
 */
public class Test {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("username", "abc");
        map.put("passwd", "123");
        map.put("role", "admin");
        String str = JwtUtils.createJwt("admin", "abc", map, "jwt");
        System.out.println(str);
    }

}
