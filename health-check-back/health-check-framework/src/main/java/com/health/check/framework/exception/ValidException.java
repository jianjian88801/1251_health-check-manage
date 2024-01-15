package com.health.check.framework.exception;

import com.health.check.framework.util.StringPools;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * 校验异常
 *
 * @author xiao.xl 2022/3/9 15:27
 */
public class ValidException extends BusinessException {
	
	private ValidException(Integer code , String message) {
		super(code,message);
	}
	
	private ValidException(Integer code , String message, Throwable cause) {
		super(code,message,cause);
	}
	
	@Override
	public Integer getCode() {
		return super.getCode();
	}
	
	public static ValidException paramError(List<ObjectError> errors, Throwable cause) {
		return new ValidException(HttpStatus.BAD_REQUEST.value(), getMessage(errors), cause);
	}
	
	public static ValidException paramError(List<ObjectError> errors) {
		return new ValidException(HttpStatus.BAD_REQUEST.value(), getMessage(errors));
	}
	
	public static ValidException paramError(String message) {
		return new ValidException(HttpStatus.BAD_REQUEST.value(), message);
	}
	
	public static ValidException paramError(String message, Throwable cause) {
		return new ValidException(HttpStatus.BAD_REQUEST.value(), message, cause);
	}
	
	public static String getMessage(List<ObjectError> errors) {
		StringBuilder sb = new StringBuilder();
		errors.forEach(o -> sb.append(o.getDefaultMessage()).append(StringPools.SEMICOLON));
		// 去掉最后一个分号
		return sb.substring(0, sb.length() - 1);
	}
	
}
