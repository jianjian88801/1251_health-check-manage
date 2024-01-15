package com.health.check.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录DTO
 *
 * @author xiao.xl 2022/4/23 18:19
 */
@Data
public class UserLoginDTO {
	
	/**
	 * 账号
	 */
	@NotBlank(message = "账号不能为空")
	private String userName;
	
	/**
	 * 密码
	 */
	@NotBlank(message = "密码不能为空")
	private String password;
	
}
