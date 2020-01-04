package com.wang.authorize.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * HTTP请求认证实体类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/1/4 18:34
 * @since JDK 1.8
 */
@Data
public class LoginRequest {
    /**
     * 姓名
     */
    @NotBlank(message = "用户名不能为空")
    @Length(max = 32,message = "用户名超出最大限制")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 6,max = 32,message = "密码长度不符合规范")
    private String password;

}
