package com.health.check.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.health.check.admin.entity.HealthFzjcInfo;
import com.health.check.admin.mapper.HealthFzjcInfoMapper;
import com.health.check.admin.service.HealthFzjcInfoService;
import com.health.check.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 辅助检查信息 服务实现类
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
@Service
public class HealthFzjcInfoServiceImpl extends BaseServiceImpl<HealthFzjcInfoMapper, HealthFzjcInfo> implements HealthFzjcInfoService {
	
	@Override
	public HealthFzjcInfo getByHealthInfoId(Long healthInfoId) {
		LambdaQueryWrapper<HealthFzjcInfo> queryWrapper = new LambdaQueryWrapper<HealthFzjcInfo>()
						.eq(HealthFzjcInfo::getHealthInfoId, healthInfoId);
		return getMapper().selectOne(queryWrapper);
	}
	
}
