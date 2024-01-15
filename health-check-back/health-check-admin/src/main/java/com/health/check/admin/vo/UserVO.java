package com.health.check.admin.vo;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户信息{@link com.health.check.admin.entity.UserInfo}
 *
 * @author xiao.xl 2022/4/23 22:46
 */
@Data
public class UserVO {
	private Long id;
	private String name;
	private String chain;
	private String photo;
	private String sex;
	private String phone;
	private String email;
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private Date birthDate;
}