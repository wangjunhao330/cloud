package com.wang.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Json工具类
 * 提供json和对象之间的装换方法
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/1/4 19:20
 * @since JDK 1.8
 */
public class JsonUtils {
    /**
     * 将对象转换为json字符串
     * 会忽略为null的字段
     *
     * @param object
     * @return java.lang.String
     * @throws
     * @Date 2020/1/4 21:46
     * @Author wangjunhao
     **/
    public static String ObjectToJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
}
