package com.health.check.framework.config;

import com.zaxxer.hikari.HikariConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 数据库配置消息
 *
 * @author xiao.xl 2022/3/9 11:57
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Component
@ConfigurationProperties(prefix = HikariProperties.DATA_SOURCE_PREFIX)
public class HikariProperties extends HikariConfig {
	
	protected final static String DATA_SOURCE_PREFIX = "spring.datasource";
	
}
