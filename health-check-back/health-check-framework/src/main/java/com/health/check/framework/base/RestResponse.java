package com.health.check.framework.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * 统一结果集封装
 *
 * @author xiao.xl 2022/3/9 14:35
 */
@Getter
@Setter
@ToString
public class RestResponse<T> {

	/**
	 * 状态码(业务定义)
	 */
	private Integer code = HttpStatus.OK.value();

	/**
	 * 状态码描述(业务定义)
	 */
	private String message = HttpStatus.OK.getReasonPhrase();

	/**
	 * 结果对象(泛型)
	 */
	private T result;

	/**
	 * 时间截
	 */
	private Date timestamp = new Date();

	public RestResponse() {
	}

	public RestResponse(T result) {
		this.result = result;
	}

	private RestResponse(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public RestResponse(Integer code, String message, T result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public static <T> RestResponse<T> result(T result) {
		return new RestResponse<T>(result);
	}

	public static <T> RestResponse<T> success() {
		return new RestResponse<>();
	}

	public static <T> RestResponse<T> fail(Integer code, String message) {
		return new RestResponse<>(code, message);
	}

	public static <T> RestResponse<T> fail(Integer code, String message,T result) {
		return new RestResponse<>(code, message,result);
	}
}
