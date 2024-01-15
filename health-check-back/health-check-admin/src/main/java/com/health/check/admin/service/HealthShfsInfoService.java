package com.health.check.admin.service;

import com.health.check.admin.entity.HealthShfsInfo;
import com.health.check.framework.base.BaseService;

/**
 * <p>
 * 生活方式信息 服务类
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
public interface HealthShfsInfoService extends BaseService<HealthShfsInfo> {
	
	/**
	 * 通过体检id获取生活方式信息
	 *
	 * @param healthInfoId 体检id
	 * @return 生活方式信息
	 * @author xiao.xl 2022/6/19 0:13
	 */
	HealthShfsInfo getByHealthInfoId(Long healthInfoId);
}
