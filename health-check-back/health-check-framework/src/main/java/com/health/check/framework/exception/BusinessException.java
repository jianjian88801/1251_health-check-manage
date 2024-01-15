package com.health.check.framework.exception;

import org.springframework.http.HttpStatus;

/**
 * 业务异常
 *
 * @author xiao.xl 2022/3/9 14:30
 */
public class BusinessException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
    
    public BusinessException(String message) {
        super(message);
        this.code = HttpStatus.BAD_REQUEST.value();
    }
    
    /**
     * 参数异常
     *
     * @param message 错误信息
     * @return 业务异常
     * @author xiao.xl 2022/3/9 17:37
     */
    public static BusinessException paramError(String message) {
        return new BusinessException(HttpStatus.BAD_REQUEST.value(), message);
    }

    /**
     * 参数异常
     *
     * @param message 错误信息
     * @param cause   错误堆栈
     * @return 业务异常
     * @author xiao.xl 2022/3/9 17:37
     */
    public static BusinessException paramError(String message, Throwable cause) {
        return new BusinessException(HttpStatus.BAD_REQUEST.value(), message, cause);
    }
    
    /**
     * 查询不存在
     *
     * @param message 错误信息
     * @return 业务异常
     * @author xiao.xl 2022/3/9 17:37
     */
    public static BusinessException notFound(String message) {
        return new BusinessException(HttpStatus.NOT_FOUND.value(), message);
    }
    
}
