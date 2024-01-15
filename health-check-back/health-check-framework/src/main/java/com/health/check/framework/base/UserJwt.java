package com.health.check.framework.base;

import cn.hutool.core.date.DatePattern;
import cn.hutool.system.UserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户token模型
 *
 * @author xiao.xl 2022/4/23 14:05
 */
@Data
@NoArgsConstructor
public class UserJwt {

    /**
     * 手机
     */
    private String phone;

    /**
     * 用户
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 过期时间
     */
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private Date expiration;
    
    public UserJwt(String phone,String name, String email, Long userId, Date expiration) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.userId = userId;
        this.expiration = expiration;
    }
    
}
