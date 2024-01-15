package com.health.check.framework.exception;

import cn.hutool.core.io.IoUtil;
import com.health.check.framework.base.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.cache.CacheException;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/**
 * 全局异常处理
 *
 * @author xiao.xl 2022/3/9 14:34
 */
@Slf4j
@Primary
@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(RuntimeException.class)
	public RestResponse<String> runTimeError(HttpServletRequest req, RuntimeException e) {
		log.error(e.getMessage(), e);
		return RestResponse.fail(HttpStatus.BAD_REQUEST.value(), getRealMessage(e), req.getRequestURI().toString());
	}
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public RestResponse<String> serverError(HttpServletRequest req, Exception e) {
		String url = req.getRequestURL().toString();
		log.error(e.getMessage(), e);
		if (e instanceof HttpRequestMethodNotSupportedException) {
			HttpRequestMethodNotSupportedException exception = (HttpRequestMethodNotSupportedException) e;
			return RestResponse.fail(HttpStatus.METHOD_NOT_ALLOWED.value(), exception.getMessage(), url);
		}
		if (e instanceof NoHandlerFoundException) {
			NoHandlerFoundException exception = (NoHandlerFoundException) e;
			return RestResponse.fail(HttpStatus.METHOD_NOT_ALLOWED.value(), exception.getMessage(), url);
		}
		if (e instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
			BindingResult bindingResult = exception.getBindingResult();
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			return RestResponse.fail(HttpStatus.BAD_REQUEST.value(), ValidException.getMessage(allErrors), url);
		}
		return RestResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统繁忙！", url);
	}
	
	@ResponseBody
	@ExceptionHandler(value = {
			BusinessException.class,
			AuthException.class,
			ValidException.class,
			CacheException.class
	})
	public RestResponse<String> businessError(HttpServletRequest req, BusinessException e) {
		log.error(e.getMessage(), e);
		return RestResponse.fail(e.getCode(), e.getMessage(), req.getRequestURL().toString());
	}
	
	/**
	 * 异常嵌套取真实信息
	 *
	 * @param e 异常对象
	 * @return 错误信息
	 * @author xiao.xl 2022/3/9 15:24
	 */
	private String getRealMessage(Throwable e) {
		// 如果e不为空，则去掉外层的异常包装
		while (e != null) {
			Throwable cause = e.getCause();
			if (cause == null) {
				return e.getMessage();
			}
			e = cause;
		}
		return StringUtils.EMPTY;
	}
	
	public static String getExceptionMsg(Throwable e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return sw.toString();
		} finally {
			IoUtil.close(pw);
			IoUtil.close(sw);
		}
	}
	
}
