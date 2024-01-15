package com.health.check.framework.filter;

import com.health.check.framework.base.UserJwt;
import com.health.check.framework.config.GatewayConfig;
import com.health.check.framework.config.UserContextHolder;
import com.health.check.framework.constant.CommonConstant;
import com.health.check.framework.exception.AuthException;
import com.health.check.framework.exception.BusinessException;
import com.health.check.framework.util.JwtUtils;
import com.health.check.framework.util.PathMatcherUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Token认证
 *
 * @author xiao.xl 2022/3/9 14:11
 */
@Slf4j
@Component
public class TokenAuthFilter extends OncePerRequestFilter {

    @Value("${health-check.auth.tokenExpirationTime:1440}")
    private Integer tokenExpirationTime;

    @Value("${server.servlet.context-path:''}")
    private String serverPrefix;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Autowired
    private GatewayConfig gatewayConfig;

    private RedisTemplate<String, String> redisTemplate;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException, BusinessException {
        // 判断是否白名单
        String requestURI = request.getRequestURI();
        if (StringUtils.isNotBlank(requestURI) && this.isWhiteList(requestURI)) {
            chain.doFilter(request, response);
            return;
        }
        final String authHeader = request.getHeader(CommonConstant.HEADER_AUTH);
        if (StringUtils.isNotBlank(authHeader)
                && !StringUtils.equals(authHeader, "undefined")
                && !StringUtils.equals(authHeader, "null")) {
            UserJwt userJwt = null;
            try {
                userJwt = JwtUtils.getUserInfoToToken(authHeader);
            } catch (Exception ex) {
                log.warn("getUserInfoToToken 错误：", ex);
                throwError(request, response, "token无效，请重新登录");
            }
            if (userJwt != null && redisTemplate.hasKey(CommonConstant.AUTHORIZATION_TOKEN_PREFIX + userJwt.getPhone())) {
                UserContextHolder.setUser(userJwt);
                // 刷新token
                redisTemplate.opsForValue().set(CommonConstant.AUTHORIZATION_TOKEN_PREFIX + userJwt.getPhone(), authHeader, tokenExpirationTime, TimeUnit.MINUTES);
                chain.doFilter(request, response);
                return;
            } else {
                throwError(request, response, "用户登录状态已过期");
            }
        }
        // 判断是否白名单
        throwError(request, response, "请先登录登录用户");
    }

    private synchronized boolean isWhiteList(String requestURI) {
        return PathMatcherUtils.matchAny(requestURI, gatewayConfig.getAnnoPattern(serverPrefix));
    }

    @Override
    public void destroy() {
        UserContextHolder.shutdown();
        log.info("source application shutdown, remove user context.");
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * Filter 需要特殊处理
     * https://baijiahao.baidu.com/s?id=1714560294854516843&wfr=spider&for=pc
     */
    private void throwError(HttpServletRequest request, HttpServletResponse response, String msg) {
        resolver.resolveException(request, response, null, AuthException.authTokenError(msg));
        throw AuthException.authTokenError(msg);
    }
    
}
