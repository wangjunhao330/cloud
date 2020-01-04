package com.wang.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;

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
    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    /**
     * 将对象转换为json字符串
     * 会忽略对象中为null的字段
     *
     * @param object
     * @return java.lang.String
     * @throws
     * @Date 2020/1/4 21:46
     * @Author wangjunhao
     **/
    public static String objectToJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        StringWriter sw = new StringWriter();
        try {
            mapper.writeValue(sw,object);
        } catch (IOException e) {
            logger.error("装换为json失败:{}",e.getMessage());
        }
        return sw.toString();
    }

    /**
     * 对象转换为json字符串
     * 不会忽略对象中为null的字段,例如name字段为null,转换为{"name":null}
     *
     * @param object
     * @return java.lang.String
     * @throws
     * @Date 2020/1/4 22:12
     * @Author wangjunhao
     **/
    public static String objectToJsonWithNull(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        StringWriter stringWriter = new StringWriter();
        try {
            mapper.writeValue(stringWriter, object);
        } catch (IOException e) {
            logger.error("对象装换json错误:{}",e.getMessage());
        }
        return stringWriter.toString();
    }

    /**
     * json转换为对象
     *
     * @param json 要转换的json字符串
     * @param type 对象的类型
     * @param fullMap 如果为false,将忽略为空值属性
     * @return T
     * @throws
     * @Date 2020/1/4 22:33
     * @Author wangjunhao
     **/
    public static <T> T jsonToObject(String json,Class<T> type,boolean fullMap) {
        ObjectMapper mapper = new ObjectMapper();
        if (!fullMap) {
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }
        try {
            return mapper.readValue(json,type);
        } catch (IOException e) {
            logger.error("json装换对象错误:{}",e.getMessage());
        }
        return null;
    }

    /**
     * json转化为对象
     * 默认忽略空值属性
     *
     * @param json
     * @param type
     * @return T
     * @throws
     * @Date 2020/1/4 22:47
     * @Author wangjunhao
     **/
    public static <T> T jsonToObject(String json, Class<T> type) {
        return jsonToObject(json, type, false);
    }

}
