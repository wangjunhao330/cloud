package com.wang.authorize.service.impl;

import com.wang.authorize.entity.User;
import com.wang.authorize.jwtUtils.JwtUtils;
import com.wang.authorize.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录相关service实现类
 * 用于获取token、
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/1/4 19:01
 * @since JDK 1.8
 */
@Service(value = "logService")
public class LogServiceImpl implements LogService {
    private Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public String getToken(User user) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("user", user);
        return jwtUtils.createJwt(user.getUserId() + "", user.getUsernmae(), map, "login");
    }
}
