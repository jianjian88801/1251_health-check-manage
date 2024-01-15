package com.health.check.admin.service;

import com.health.check.admin.dto.HealthCheckPageDTO;
import com.health.check.admin.entity.HealthInfo;
import com.health.check.admin.vo.HealthCheckExcelVO;
import com.health.check.framework.base.BaseService;

import java.util.List;

/**
 * <p>
 * 体检信息 服务类
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
public interface HealthInfoService extends BaseService<HealthInfo> {
	
	/**
	 * 查询Excel导出数据(限制50000条)
	 *
	 * @param query 请求参数
	 * @return 导出数据集合
	 * @author xiao.xl 2022/6/18 21:28
	 */
	List<HealthCheckExcelVO> listExcelInfo(HealthCheckPageDTO query);
}
