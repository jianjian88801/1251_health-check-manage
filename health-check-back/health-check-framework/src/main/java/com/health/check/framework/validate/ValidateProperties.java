package com.health.check.framework.validate;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;

/**
 * 提示消息配置
 *
 * @author xiao.xl 2022/3/12 14:52
 */
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = ValidateProperties.PREFIX, ignoreInvalidFields = true)
public class ValidateProperties {

    final static String PREFIX = "hibernate.validate";

    private Map<Locale, Map<String, String>> message = Maps.newConcurrentMap();

    /**
     * 获取配置
     *
     * @author xiao.xl 2022/3/12 14:49
     */
    public String getConfig(Locale locale, String code) {
        log.info("参数locale：{}, code：{}", locale, code);
        Map<String, String> localeMap = getMessage().get(locale);
        if (CollectionUtil.isEmpty(localeMap)) {
            localeMap = getMessage().get(Locale.SIMPLIFIED_CHINESE);
        }
        if (localeMap != null){
            String config = localeMap.get(code);
            if (config == null) {
                log.warn("通过locale：{}, code：{}，找不到自定义校验提示", locale, code);
            }
            return config;
        }
        return null;
    }

    /**
     * 刷新配置
     *
     * @author xiao.xl 2022/3/12 14:49
     */
    public void refreshConfig(Locale locale, String code, String value) {
        if (getMessage().get(locale) == null) {
            log.error("国际化语言{},不存在", locale);
        }
        if (getMessage().get(locale).containsKey(code)) {
            getMessage().get(locale).replace(code, value);
        } else {
            getMessage().get(locale).put(code, value);
        }
    }
}
