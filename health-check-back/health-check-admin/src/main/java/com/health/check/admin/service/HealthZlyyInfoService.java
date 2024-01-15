package com.health.check.admin.service;

import com.health.check.admin.entity.HealthZlyyInfo;
import com.health.check.framework.base.BaseService;

/**
 * <p>
 * 治疗用药接种信息 服务类
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
public interface HealthZlyyInfoService extends BaseService<HealthZlyyInfo> {
	
	/**
	 * 通过体检id获取治疗用药接种信息
	 *
	 * @param healthInfoId 体检id
	 * @return 治疗用药接种信息
	 * @author xiao.xl 2022/6/19 0:14
	 */
	HealthZlyyInfo getByHealthInfoId(Long healthInfoId);
}
