package com.health.check.admin.mapper;

import com.health.check.admin.dto.HealthCheckPageDTO;
import com.health.check.admin.entity.HealthInfo;
import com.health.check.admin.vo.HealthCheckExcelVO;
import com.health.check.framework.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 体检信息 Mapper 接口
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
public interface HealthInfoMapper extends BaseMapper<HealthInfo> {
	
	/**
	 * 查询Excel导出数据(限制50000条)
	 *
	 * @param query 请求参数
	 * @return 导出数据集合
	 * @author xiao.xl 2022/6/18 21:31
	 */
	List<HealthCheckExcelVO> listExcelInfo(@Param("req") HealthCheckPageDTO query);
	
}
