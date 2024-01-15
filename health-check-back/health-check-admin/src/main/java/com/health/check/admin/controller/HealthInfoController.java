package com.health.check.admin.controller;

import com.health.check.admin.dto.HealthCheckPageDTO;
import com.health.check.admin.dto.HealthCheckSaveDTO;
import com.health.check.admin.facade.HealthInfoFacade;
import com.health.check.admin.vo.CheckAbnormalVO;
import com.health.check.admin.vo.HealthCheckDetailVO;
import com.health.check.admin.vo.HealthCheckPageVO;
import com.health.check.framework.base.PagerReq;
import com.health.check.framework.base.PagerRes;
import com.health.check.framework.base.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 体检信息 前端控制器
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
@RestController
@RequestMapping("/health")
public class HealthInfoController {

	private HealthInfoFacade healthInfoFacade;
	
	/**
	 * 分页查询
	 *
	 * @param pagerReq 体检信息分页查询参数
	 * @return 分页查询响应结果
	 * @author xiao.xl 2022/6/18 10:04
	 */
	@PostMapping("/page/check")
	public RestResponse<PagerRes<HealthCheckPageVO>> pageCheckInfo(@RequestBody PagerReq<HealthCheckPageDTO> pagerReq) {
		PagerRes<HealthCheckPageVO> pagerRes = healthInfoFacade.pageCheckInfo(pagerReq);
		return RestResponse.result(pagerRes);
	}
	
	/**
	 * 删除体检
	 *
	 * @param id 体检编号
	 * @return true: 删除成功
	 * @author xiao.xl 2022/6/18 10:23
	 */
	@DeleteMapping("/delete/{id}")
	public RestResponse<Boolean> deleteById(@PathVariable("id") Long id) {
		healthInfoFacade.deleteById(id);
		return RestResponse.result(Boolean.TRUE);
	}
	
	/**
	 * 获取体检明细
	 *
	 * @param id 体检编号
	 * @return 体检信息明细
	 * @author xiao.xl 2022/6/18 10:37
	 */
	@GetMapping("/detail/{id}")
	public RestResponse<HealthCheckDetailVO> getCheckDetail(@PathVariable("id") Long id) {
		HealthCheckDetailVO healthCheckDetail = healthInfoFacade.getCheckDetail(id);
		return RestResponse.result(healthCheckDetail);
	}
	
	/**
	 * 新增/编辑体检信息
	 *
	 * @param healthCheckSave 体检信息请求参数
	 * @return 体检编号
	 * @author xiao.xl 2022/6/18 10:40
	 */
	@PostMapping("/save/info")
	public RestResponse<Long> saveCheckInfo(@RequestBody HealthCheckSaveDTO healthCheckSave) {
		Long id = healthInfoFacade.saveCheckInfo(healthCheckSave);
		return RestResponse.result(id);
	}
	
	/**
	 * Excel导出体检信息
	 *
	 * @param healthCheckPageDTO 请求参数
	 * @param response 响应对象
	 * @author xiao.xl 2022/6/18 12:38
	 */
	@PostMapping(value = "/excel/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public void exportCheckExcel(@RequestBody HealthCheckPageDTO healthCheckPageDTO, HttpServletResponse response) {
		healthInfoFacade.exportCheckExcel(healthCheckPageDTO, response);
	}
	
	/**
	 * 获取体检异常消息
	 *
	 * @param healthCheckSaveDTO 体检报告信息
	 * @return 体检异常对象
	 * @author xiao.xl 2022/6/20 21:33
	 */
	@PostMapping("/getAbnormalInfo")
	public RestResponse<CheckAbnormalVO> getAbnormalInfo(@RequestBody HealthCheckSaveDTO healthCheckSaveDTO) {
		CheckAbnormalVO checkAbnormal = healthInfoFacade.getAbnormalInfo(healthCheckSaveDTO);
		return RestResponse.result(checkAbnormal);
	}
	
	@Autowired
	public void setHealthInfoFacade(HealthInfoFacade healthInfoFacade) {
		this.healthInfoFacade = healthInfoFacade;
	}
}
