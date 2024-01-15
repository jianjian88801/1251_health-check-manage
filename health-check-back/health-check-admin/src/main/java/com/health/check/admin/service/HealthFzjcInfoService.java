package com.health.check.admin.service;

import com.health.check.admin.entity.HealthFzjcInfo;
import com.health.check.framework.base.BaseService;

/**
 * <p>
 * 辅助检查信息 服务类
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
public interface HealthFzjcInfoService extends BaseService<HealthFzjcInfo> {
	
	/**
	 * 通过体检id获取辅助检查信息
	 *
	 * @param healthInfoId 体检id
	 * @return 辅助检查信息
	 * @author xiao.xl 2022/6/19 0:13
	 */
	HealthFzjcInfo getByHealthInfoId(Long healthInfoId);
	
}
