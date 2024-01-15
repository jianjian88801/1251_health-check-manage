package com.health.check.admin.service.impl;

import com.health.check.admin.dto.HealthCheckPageDTO;
import com.health.check.admin.entity.HealthInfo;
import com.health.check.admin.mapper.HealthInfoMapper;
import com.health.check.admin.service.HealthInfoService;
import com.health.check.admin.vo.HealthCheckExcelVO;
import com.health.check.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 体检信息 服务实现类
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
@Service
public class HealthInfoServiceImpl extends BaseServiceImpl<HealthInfoMapper, HealthInfo> implements HealthInfoService {
	
	@Override
	public List<HealthCheckExcelVO> listExcelInfo(HealthCheckPageDTO query) {
		return getMapper().listExcelInfo(query);
	}
	
}
