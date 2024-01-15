package com.health.check.framework.exception;

import org.springframework.http.HttpStatus;

/**
 * Redis 缓存异常
 *
 * @author xiao.xl 2022/4/26 21:57
 */
public class CacheException extends BusinessException {
	
	public CacheException(Integer code, String message) {
		super(code, message);
	}
	
	public CacheException(Integer code, String message, Throwable cause) {
		super(code, message, cause);
	}
	
	/**
	 * 缓存类型错误异常
	 *
	 * @author xiao.xl 2022/4/26 22:02
	 */
	public static CacheException cacheTypeError() {
		return new CacheException(HttpStatus.BAD_REQUEST.value(), "缓存类型错误");
	}
	
	public static CacheException cacheUnable() {
		return new CacheException(HttpStatus.NOT_ACCEPTABLE.value(), "缓存配置未启用");
	}
	
}
