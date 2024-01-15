package com.health.check.framework.base;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 分页响应实体
 *
 * @author xiao.xl 2022/3/9 14:40
 */
@Getter
@Setter
@ToString
public class PagerRes<T> {
	
	/**
	 * 分页记录集合
	 */
	private List<T> records;
	
	/**
	 * 总页数
	 */
	private Integer totalPage;
	
	/**
	 * 总记录数
	 */
	private Long total;
	
	/**
	 * 当前页数
	 */
	private Integer pageNo;
	
	/**
	 * 每页数
	 */
	private Integer limit;
	
	
	public PagerRes<T> build(PagerRes old){
		this.total =old.getTotal();
		this.totalPage=old.getTotalPage();
		this.pageNo =old.getPageNo();
		this.limit =old.getLimit();
		this.records= Lists.newArrayList();
		return this;
	}
	
}
