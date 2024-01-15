package com.health.check.admin.service;

import com.health.check.admin.entity.HealthXtInfo;
import com.health.check.framework.base.BaseService;

/**
 * <p>
 * 宣体信息 服务类
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
public interface HealthXtInfoService extends BaseService<HealthXtInfo> {
	
	/**
	 * 通过体检id获取宣体信息
	 *
	 * @param healthInfoId 体检id
	 * @return 宣体信息
	 * @author xiao.xl 2022/6/19 0:11
	 */
	HealthXtInfo getByHealthInfoId(Long healthInfoId);
}
