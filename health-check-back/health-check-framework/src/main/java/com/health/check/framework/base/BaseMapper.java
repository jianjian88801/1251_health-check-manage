package com.health.check.framework.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 基础Mapper
 *
 * @author xiao.xl 2022/3/9 21:26
 */
@Mapper
public interface BaseMapper<T extends BaseEntity<T>> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {
	
	/**
	 * 分页查询
	 *
	 * @param page 分页条件
	 * @param wrapper 查询条件
	 * @return  分页查询结果
	 * @author xiao.xl 2022/3/9 23:07
	 */
	IPage<T> selectPage(Page<T> page, @Param("ew") Wrapper<T> wrapper);
	
}
