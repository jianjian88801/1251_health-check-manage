package com.health.check.framework.config;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.health.check.framework.util.MD5Utils;
import com.health.check.framework.util.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Map;

/**
 * Redis缓存key自定义生成策略
 *
 * @author xiao.xl 2021/10/19 14:06
 */
@Slf4j
public class RedisCacheKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object targetClass, Method method, Object... params) {
        // 这里可用HashMap
        Map<String, Object> container = Maps.newLinkedHashMap();
        Class<?> targetClassClass = targetClass.getClass();
        // 包名称
        container.put("package", targetClassClass.getPackage().getName());
        // 类地址
        container.put("class", targetClassClass.getSimpleName());
        // 方法名称
        container.put("methodName", method.getName());
        // 参数列表
        for (int i = 0; i < params.length; i++) {
            // 修复对LambdaQuery类无法序列化的Bug
            if (params[i].getClass().getName().equals("org.beetl.sql.core.query.LambdaQuery")) {
                String getSql = ReflectionUtils.invoke(params[i], "getSql").toString();
                String getParams = ReflectionUtils.invoke(params[i], "getParams").toString();
                container.put(MessageFormat.format("args[{0}]", i), getSql + ">" + getParams);
            } else if (params[i] instanceof Class) {
                container.put(MessageFormat.format("args[{0}]", i), params[i].toString());
            } else {
                container.put(MessageFormat.format("args[{0}]", i), params[i]);
            }
        }
        // 转为JSON字符串
        String json = JSONObject.toJSONString(container);
        byte[] hash = null;
        try {
            hash = MessageDigest.getInstance("MD5").digest(json.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            log.error(MessageFormat.format("Redis Key序列化异常：{0} {1}", container.toString(), e));
        }
        //使用MD5生成位移key
        String key = "";
        if (hash != null) {
            key = MD5Utils.encode(hash);
        }
        String className;
        if (targetClassClass.getInterfaces() != null && targetClassClass.getInterfaces().length == 1) {
            className = targetClassClass.getInterfaces()[0].getSimpleName();
        } else {
            className = targetClassClass.getSimpleName();
        }
        return MessageFormat.format("{0}:{1}:{2}", className, method.getName(), key);
    }
}
