package com.health.check.framework.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis-plus配置
 *
 * @author xiao.xl 2022/3/9 13:54
 */
@Configuration
public class MybatisConfiguration {
	
	/**
	 * 主键生成
	 *
	 * @author xiao.xl 2022/3/11 13:53
	 */
	@Bean
	public IdentifierGenerator idGenerator() {
		return new CustomIdGenerator();
	}
	
	/**
	 * Mybatis分页插件
	 *
	 * @author xiao.xl 2022/3/11 13:53
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
		return interceptor;
	}
	
}
