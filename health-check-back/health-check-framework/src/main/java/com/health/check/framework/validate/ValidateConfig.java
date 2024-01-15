package com.health.check.framework.validate;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MessageSourceResourceBundleLocator;

/**
 * 参数校验器配置
 *
 * @author xiao.xl 2022/3/12 14:42
 */
@Configuration
public class ValidateConfig {
	
	@Bean(name = "validator")
	public Validator validator(@Autowired ValidateProperties validateProperties) {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setProviderClass(HibernateValidator.class);
		MessageSourceResourceBundleLocator messageSourceResourceBundleLocator = new MessageSourceResourceBundleLocator(bundleMessageSource(validateProperties));
		ResourceBundleMessageInterpolator messageInterpolator = new ResourceBundleMessageInterpolator(messageSourceResourceBundleLocator, false);
		validator.setMessageInterpolator(messageInterpolator);
		return validator;
	}
	
	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasenames("classpath:org/hibernate/validator/ValidationMessages");
		bundleMessageSource.setDefaultEncoding("UTF-8");
		bundleMessageSource.setCacheSeconds(10);
		return bundleMessageSource;
	}
	
	private ResourceBundleMessageSource bundleMessageSource(ValidateProperties validateProperties) {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource(validateProperties);
		resourceBundleMessageSource.setDefaultEncoding("UTF-8");
		resourceBundleMessageSource.setCacheSeconds(10);
		// 加载Hibernate-validate默认配置作为父配置资源，处理通用校验
		resourceBundleMessageSource.setParentMessageSource(messageSource());
		return resourceBundleMessageSource;
	}
	
}
