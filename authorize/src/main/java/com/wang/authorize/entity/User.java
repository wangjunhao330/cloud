package com.wang.authorize.entity;

import lombok.Data;

/**
 * 用户实体类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/1/4 19:04
 * @since JDK 1.8
 */
@Data
public class User {
    /**
     * 用户名
     */
    private String usernmae;
    /**
     * 用户ID
     */
    private long userId;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色
     */
    private String roleName;
    /**
     * 角色Id
     */
    private int roleId;
    /**
     * 电话
     */
    private String telNum;


}
