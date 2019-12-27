package com.wang.common.jwtUtils;

import com.wang.common.constant.JwtConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

/**
 * json web token工具类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2019/12/27 16:32
 * @since JDK 1.8
 */
public class JwtUtils {
    Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    /**
     * 生成jwt工具类
     *
     * @param jwtId
     * @param receiver
     * @param custom
     * @param subjet
     * @return java.lang.String
     * @date 2019/12/27 17:39
     * @author wangjunhao
     **/
    public static String createJwt(String jwtId, String receiver, Map<String, Object> custom, String subjet) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generateKey();
        long now = System.currentTimeMillis();
        Date date = new Date(now + JwtConstant.expireTime);
        JwtBuilder builder = Jwts
                .builder()
                .setId(jwtId)
                .setSubject(subjet)
                .setAudience(receiver)
                .setIssuer(JwtConstant.issuser)
                .setClaims(custom)
                .setExpiration(date)
                .setIssuedAt(new Date(now))
                .signWith(signatureAlgorithm, secretKey);
        return builder.compact();
    }

    /**
     * 生成秘钥
     *
     * @param
     * @return javax.crypto.SecretKey
     * @date 2019/12/27 17:45
     * @author wangjunhao
     **/
    private static SecretKey generateKey() {
        byte[] encodedKey = Base64.decodeBase64(JwtConstant.password);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    public static Claims parseJwt(String jwt) {
        SecretKey key = generateKey();
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt)
                .getBody();
    }


}
