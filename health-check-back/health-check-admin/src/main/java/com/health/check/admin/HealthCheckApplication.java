package com.health.check.admin;

import com.health.check.framework.config.HikariProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * 健康体检启动类
 *
 * @author xiao.xl 2022/6/14 23:36
 */
@ComponentScan("com.health.check")
@EnableConfigurationProperties(HikariProperties.class)
@SpringBootApplication(scanBasePackages = {"com.health.check","com.health.check.framework.exception"}, exclude = {DataSourceAutoConfiguration.class})
@MapperScan({"com.health.check.admin.mapper"})
public class HealthCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCheckApplication.class, args);
	}

}
