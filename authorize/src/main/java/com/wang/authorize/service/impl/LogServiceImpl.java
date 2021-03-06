package com.wang.authorize.service.impl;

import com.wang.authorize.entity.User;
import com.wang.authorize.jwtUtils.JwtUtils;
import com.wang.authorize.service.LogService;
import io.jsonwebtoken.Claims;
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
        map.put("username", user.getUsernmae());
        map.put("roleId", user.getRoleId());
        return jwtUtils.createJwt(user.getUserId() + "", user.getUsernmae(), map, "login");
    }

    @Override
    public User parseToken(String token) {
        if (null == token) {
            return null;
        }
        Claims claims = jwtUtils.parseJwt(token);

        return claimsToUser(claims);
    }

    /**
     * 将claims内容装换为user实体类
     *
     * @param claims
     * @return com.wang.authorize.entity.User
     * @throws
     * @Date 2020/1/5 14:47
     * @Author wangjunhao
     **/
    private User claimsToUser(Claims claims) {
        User user = new User();
        user.setUsernmae(claims.get("usernmae", String.class));
        return user;
    }
}
