package com.health.check.framework.base;

import cn.hutool.db.sql.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 排序对象
 *
 * @author xiao.xl 2022/3/9 14:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	/**
	 * 查询属性
	 */
	private String property;
	
	/**
	 * 正序或倒序
	 */
	private Direction direction;
	
	public static Order orderBy(String property, Direction direction) {
		return new Order(property, direction);
	}
	
}
