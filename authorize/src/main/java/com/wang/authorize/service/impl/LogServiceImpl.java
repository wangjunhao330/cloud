package com.wang.authorize.service.impl;

import com.wang.authorize.entity.LoginRequest;
import com.wang.authorize.service.LogService;
import org.springframework.stereotype.Service;

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
    @Override
    public String getToken(LoginRequest loginRequest) {
        return null;
    }
}
