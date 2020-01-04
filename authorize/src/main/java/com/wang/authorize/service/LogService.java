package com.wang.authorize.service;

import com.wang.authorize.entity.User;

/**
 * 登录相关service类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/1/4 18:56
 * @since JDK 1.8
 */
public interface LogService {
    /**
     * 根据传入的用户名密码,生成token
     *
     * @param user
     * @return java.lang.String
     * @throws
     * @Date 2020/1/4 18:59
     * @Author wangjunhao
     **/
    public String getToken(User user);

}
