package com.health.check.framework.config;

import cn.hutool.core.collection.CollUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 网关配置
 *
 * @author Hoda 2022/6/17 23:38
 */
@Data
@Component
@ConfigurationProperties(prefix = "health-check.gateway")
public class GatewayConfig {

    private List<String> annoPattern;

    private List<String> serverAnnoPattern;


    public synchronized List<String> getAnnoPattern(String serverPrefix) {
        if (serverAnnoPattern == null && CollUtil.isNotEmpty(annoPattern)) {
            serverAnnoPattern = Collections.unmodifiableList(annoPattern.stream().map(v -> serverPrefix + v)
                    .collect(Collectors.toList()));
        }
        return serverAnnoPattern;
    }

}
