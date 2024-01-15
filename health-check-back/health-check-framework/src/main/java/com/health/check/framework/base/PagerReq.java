package com.health.check.framework.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 分页请求实体
 *
 * @author xiao.xl 2022/3/9 14:39
 */
@Getter
@Setter
@ToString
public class PagerReq<T> {
	
	/**
	 * 当前页码
	 */
	@Min(value = 1, message = "页码最小值为1")
	@NotNull(message = "当前页面不能为空")
	private Integer pageNo = 1;
	
	/**
	 * 分页尺寸
	 */
	@Min(value = 0, message = "分页尺寸最小值为1")
	@NotNull(message = "每页数不能为空")
	private Integer limit = 10;
	
	/**
	 * 排序
	 */
	private List<Order> orders;
	
	/**
	 * 查询条件对象
	 */
	private T entity;
	
}
