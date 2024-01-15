package com.health.check.framework.validate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

/**
 * 校验提示信息读取器
 *
 * @author xiao.xl 2022/3/12 14:46
 */
public class ResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {

    private ValidateProperties validateProperties;

    public ResourceBundleMessageSource(ValidateProperties validateProperties) {
        this.validateProperties = validateProperties;
    }

    @Override
    protected String resolveCodeWithoutArguments(String code, Locale locale) {
        String config = validateProperties.getConfig(locale, code);
        // 自定义提示不存在，加载Hibernate-validate默认配置
        if (StringUtils.isBlank(config)) {
            config = super.resolveCodeWithoutArguments(code, locale);
        }
        return config;
    }

}
