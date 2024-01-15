package com.health.check.framework.config;

import cn.hutool.crypto.SecureUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 数据源配置
 *
 * @author xiao.xl 2022/3/9 11:57
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class DataSourceConfig {

    protected static final String DES_KEY = "SCS_SQL_DES_KEY";
    protected static final String DATA_SOURCE = "dataSource";

    private HikariProperties hikariProperties;

    @Autowired
    public DataSourceConfig(HikariProperties hikariProperties) {
        this.hikariProperties = hikariProperties;
    }

    @Primary
    @Bean(DATA_SOURCE)
    public DataSource dataSource() {
        hikariProperties.setUsername(decryptStr(hikariProperties.getUsername()));
        hikariProperties.setPassword(decryptStr(hikariProperties.getPassword()));
        return new HikariDataSource(hikariProperties);
    }

    @Bean("sqlTransactionManager")
    public PlatformTransactionManager sqlTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    public static String decryptStr(String str) {
        return SecureUtil.des(DES_KEY.getBytes()).decryptStr(str);
    }

    public static void main(String[] args) {
        System.out.println(SecureUtil.des(DES_KEY.getBytes()).encryptBase64("root"));
        System.out.println(SecureUtil.des(DES_KEY.getBytes()).encryptBase64("12345678"));
        System.out.println(SecureUtil.des(DES_KEY.getBytes()).encryptBase64("GYTOLTXMWVKQ"));
    }

}
