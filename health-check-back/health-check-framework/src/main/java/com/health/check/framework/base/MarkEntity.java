package com.health.check.framework.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 缺省字段实体
 *
 * @author xiao.xl 2022/3/10 9:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MarkEntity<T extends MarkEntity<T>> extends BaseEntity<T> {
	
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private Date createTime;
	
	/**
	 * 创建人
	 */
	@TableField(fill = FieldFill.INSERT)
	private String creater;
	
	/**
	 * 更新时间
	 */
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;
	
	/**
	 * 更新人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updater;
	
}
