package com.health.check.framework.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * base service
 *
 * @author xiao.xl 2022/3/9 21:28
 */
public interface BaseService<T> extends IService<T> {
	
	/**
	 * 是否存在对象
	 *
	 * @param entity 实体对象
	 * @return true: 存在
	 * @author xiao.xl 2022/3/10 23:37
	 */
	boolean exist(T entity);
	
	/**
	 * 分页查询
	 *
	 * @param pagerReq 分页查询条件
	 * @return 分页查询结果
	 * @author xiao.xl 2022/3/9 21:32
	 */
	PagerRes<T> selectPage(PagerReq<T> pagerReq);
	
	/**
	 * 分页查询
	 *
	 * @param pagerReq 分页查询参数
	 * @param wrapper 分页条件
	 * @return 分页结果
	 * @author xiao.xl 2022/3/9 23:20
	 */
	PagerRes<T> selectPage(PagerReq<T> pagerReq, Wrapper<T> wrapper);
	
	/**
	 * 查询集合
	 *
	 * @param wrapper 条件构造器
	 * @return 数据集合
	 * @author xiao.xl 2022/3/11 23:44
	 */
	List<T> selectList(Wrapper<T> wrapper);
	
	/**
	 * 查询集合
	 *
	 * @param entity 实体对象
	 * @return 数据集合
	 * @author xiao.xl 2022/3/11 23:46
	 */
	List<T> selectList(T entity);
	
}
