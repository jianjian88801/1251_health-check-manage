package com.health.check.admin.vo;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 健康体检列表VO
 *
 * @author xiao.xl 2022/6/18 9:43
 */
@Data
public class HealthCheckPageVO {
	
	/**
	 * 编号
	 */
	private Long id;
	
	/**
	 * 患者名称
	 */
	private String hzmc;

	/**
	 * 患者身份证
	 */
	private String hzsfz;
	
	/**
	 * 患者性别
	 */
	private String hzxb;
	
	/**
	 * 体检日期
	 */
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private Date tjrq;
	
	/**
	 * 检查项目
	 */
	private String jcxm;
	
	/**
	 * 录入医生
	 */
	private String lrys;
	
	/**
	 * 录入单位
	 */
	private String lrdw;
	
	/**
	 * 自定义体检编号
	 */
	private String zdytjbh;
	
	/**
	 * 备注
	 */
	private String bz;
}
