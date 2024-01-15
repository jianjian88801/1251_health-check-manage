package com.health.check.framework.exception;

import cn.hutool.core.util.StrUtil;
import org.springframework.http.HttpStatus;

/**
 * 用户授权异常
 *
 * @author xiao.xl 2022/5/29 13:34
 */
public class AuthException extends BusinessException {
	
	public AuthException(Integer code, String message) {
		super(code, message);
	}
	
	/**
	 * 用户信息不存在
	 *
	 * @author xiao.xl 2022/5/29 13:37
	 */
	public static AuthException notFound(String message) {
		return new AuthException(HttpStatus.NOT_FOUND.value(), message);
	}
	
	/**
	 * 修改密码异常
	 *
	 * @author xiao.xl 2022/5/29 13:46
	 */
	public static AuthException changePasswordError(String message) {
		return new AuthException(HttpStatus.BAD_REQUEST.value(), message);
	}
	
	/**
	 * 用户认证失败
	 *
	 * @author xiao.xl 2022/3/9 15:13
	 */
	public static AuthException authTokenError(String message) {
		return new AuthException(HttpStatus.UNAUTHORIZED.value(), message);
	}
	
	/**
	 * 参数异常
	 *
	 * @author xiao.xl 2022/5/29 13:55
	 */
	public static AuthException paramError(String message, String... ags) {
		String format = StrUtil.format(message, ags);
		return new AuthException(HttpStatus.BAD_REQUEST.value(), format);
	}
	
}
