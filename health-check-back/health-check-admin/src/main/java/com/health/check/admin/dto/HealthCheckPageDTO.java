package com.health.check.admin.dto;

import lombok.Data;

import java.util.Date;

/**
 * 健康体检列表DTO
 *
 * @author xiao.xl 2022/6/18 9:43
 */
@Data
public class HealthCheckPageDTO {
	
	/**
	 * 患者名称
	 */
	private String hzmc;

	/**
	 * 患者身份证
	 */
	private String hzsfz;
	
	/**
	 * 录入医生
	 */
	private String lrys;
	
	/**
	 * 录入单位
	 */
	private String lrdw;
	
	/**
	 * 开始时间
	 */
	private Date startDate;
	
	/**
	 * 结束时间
	 */
	private Date endDate;
	
}
