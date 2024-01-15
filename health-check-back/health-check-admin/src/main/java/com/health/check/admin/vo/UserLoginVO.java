package com.health.check.admin.vo;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户登录VO
 *
 * @author xiao.xl 2022/4/23 22:43
 */
@Data
public class UserLoginVO {
	
	/**
	 * 用户信息
	 */
	private UserVO UserInfo;
	
	/**
	 * token
	 */
	private String token;
	/**
	 * 过期时间
	 */
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private Date expiration;
	
}
