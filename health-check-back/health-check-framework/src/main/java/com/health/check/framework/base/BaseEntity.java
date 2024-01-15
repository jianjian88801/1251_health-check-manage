package com.health.check.framework.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 基础实体
 *
 * @author xiao.xl 2022/3/9 14:44
 */
@Getter
@Setter
@ToString
public class BaseEntity<T extends BaseEntity<T>> implements Serializable {
	
	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
	
	public Boolean isNewRecord() {
		return getId() == null;
	}
	
}
