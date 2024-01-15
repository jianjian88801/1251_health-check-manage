package com.health.check.framework.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.health.check.framework.util.PagerResUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * base service impl
 *
 * @author xiao.xl 2022/3/9 21:28
 */
public abstract class BaseServiceImpl< M extends BaseMapper<T>, T extends BaseEntity<T>> extends ServiceImpl<M, T> implements BaseService<T> {

	private M mapper;

	@Override
	public boolean exist(T entity) {
		return getMapper().exists(new QueryWrapper<>(entity));
	}

	@Override
	public PagerRes<T> selectPage(PagerReq<T> pagerReq) {
		Page<T> page = PagerResUtil.pagerRes2Page(pagerReq);
		QueryWrapper<T> query = Wrappers.query(pagerReq.getEntity());
		IPage<T> result = mapper.selectPage(page, query);
		return PagerResUtil.page2PagerRes(result);
	}

	@Override
	public PagerRes<T> selectPage(PagerReq<T> pagerReq, Wrapper<T> wrapper) {
		Page<T> page = PagerResUtil.pagerRes2Page(pagerReq);
		IPage<T> result = mapper.selectPage(page, wrapper);
		return PagerResUtil.page2PagerRes(result);
	}

	@Override
	public List<T> selectList(Wrapper<T> wrapper) {
		return getMapper().selectList(wrapper);
	}

	@Override
	public List<T> selectList(T entity) {
		return getMapper().selectList(new QueryWrapper<>(entity));
	}

	@Override
	public boolean saveOrUpdate(T entity) {
		if (entity.getId() != null) {
		 	return updateById(entity);
		}
		return save(entity);
	}

	@Autowired
	@SuppressWarnings("ALL")
	public void setMapper(M mapper) {
		this.mapper = mapper;
	}

	public M getMapper() {
		return mapper;
	}
}
