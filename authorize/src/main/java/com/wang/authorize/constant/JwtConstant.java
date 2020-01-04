package com.wang.authorize.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * jwt常量类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2019/12/27 16:38
 * @since JDK 1.8
 */
@Component
public class JwtConstant {
    /**
     * 秘钥
     */
    @Value("${jwt.password}")
    public String SECRET;
    /**
     * 过期时间
     */
    @Value("${jwt.expire}")
    public long EXPIRETIME;
    /**
     * 签发者
     */
    @Value("${jwt.issuer}")
    public String ISSUSER;
}
