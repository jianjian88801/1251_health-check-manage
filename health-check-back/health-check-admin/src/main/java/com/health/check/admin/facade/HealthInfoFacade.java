package com.health.check.admin.facade;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.health.check.admin.dto.HealthCheckPageDTO;
import com.health.check.admin.dto.HealthCheckSaveDTO;
import com.health.check.admin.entity.*;
import com.health.check.admin.service.*;
import com.health.check.admin.vo.CheckAbnormalVO;
import com.health.check.admin.vo.HealthCheckDetailVO;
import com.health.check.admin.vo.HealthCheckExcelVO;
import com.health.check.admin.vo.HealthCheckPageVO;
import com.health.check.framework.base.PagerReq;
import com.health.check.framework.base.PagerRes;
import com.health.check.framework.exception.BusinessException;
import com.health.check.framework.serializer.fastjson.JSONBuilder;
import com.health.check.framework.util.Assert;
import com.health.check.framework.util.StringPools;
import com.health.check.framework.util.StringUtils;
import com.health.check.framework.util.TransformUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 健康体检信息聚合
 *
 * @author xiao.xl 2022/6/18 0:51
 */
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HealthInfoFacade {

	private final HealthInfoService healthInfoService;
	private final HealthFzjcInfoService healthFzjcInfoService;
	private final HealthShfsInfoService healthShfsInfoService;
	private final HealthXtInfoService healthXtInfoService;
	private final HealthZlyyInfoService healthZlyyInfoService;
	
	/**
	 * 分页查询
	 *
	 * @param pagerReq 体检信息分页查询参数
	 * @return 分页查询响应结果
	 * @author xiao.xl 2022/6/18 10:44
	 */
	public PagerRes<HealthCheckPageVO> pageCheckInfo(PagerReq<HealthCheckPageDTO> pagerReq) {
		PagerReq<HealthInfo> page = JSONBuilder.parseObject(JSONObject.toJSONString(pagerReq), new TypeReference<PagerReq<HealthInfo>>(){});
		HealthCheckPageDTO entity = pagerReq.getEntity();
		LambdaQueryWrapper<HealthInfo> query = new LambdaQueryWrapper<HealthInfo>()
			    .eq(StringUtils.isNotBlank(entity.getHzsfz()), HealthInfo::getHzsfz, entity.getHzsfz())
				.like(StringUtils.isNotBlank(entity.getLrys()), HealthInfo::getLrys, entity.getLrys())
				.like(StringUtils.isNotBlank(entity.getHzmc()), HealthInfo::getHzmc, entity.getHzmc());
		// 时间过滤
		if (Objects.nonNull(entity.getStartDate())) {
			query.ge(HealthInfo::getTjrq, DateUtil.beginOfDay(entity.getStartDate()));
		}
		if (Objects.nonNull(entity.getEndDate())) {
			query.le(HealthInfo::getTjrq, DateUtil.endOfDay(entity.getEndDate()));
		}
		// 设置排序
		query.orderByDesc(HealthInfo::getCreateTime);
		PagerRes<HealthInfo> pagerRes = healthInfoService.selectPage(page, query);
		return JSONBuilder.parseObject(JSONObject.toJSONString(pagerRes), new TypeReference<PagerRes<HealthCheckPageVO>>(){});
	}
	
	/**
	 * 删除体检信息
	 *
	 * @param id 体检编号
	 * @author xiao.xl 2022/6/18 10:29
	 */
	@Transactional(transactionManager = "sqlTransactionManager", rollbackFor = RuntimeException.class)
	public void deleteById(Long id) {
		Assert.notNull(id, "删除体检编号不能为空");
		healthInfoService.removeById(id);
	}
	
	/**
	 * 获取体检明细
	 *
	 * @param id 体检编号
	 * @return 体检信息明细
	 * @author xiao.xl 2022/6/18 10:38
	 */
	public HealthCheckDetailVO getCheckDetail(Long id) {
		HealthInfo healthInfo = healthInfoService.getById(id);
		if (Objects.isNull(healthInfo)) {
			throw BusinessException.notFound(String.format("体检编号信息不存在，体检编号:<%s>", id));
		}
		HealthCheckDetailVO checkDetail = new HealthCheckDetailVO();
		// 数据获取
		HealthFzjcInfo healthFzjcInfo = healthFzjcInfoService.getByHealthInfoId(id);
		HealthShfsInfo healthShfsInfo = healthShfsInfoService.getByHealthInfoId(id);
		HealthZlyyInfo healthZlyyInfo = healthZlyyInfoService.getByHealthInfoId(id);
		HealthXtInfo healthXtInfo = healthXtInfoService.getByHealthInfoId(id);
		// 结果响应
		TransformUtils.transform(healthFzjcInfo, checkDetail);
		TransformUtils.transform(healthShfsInfo, checkDetail);
		TransformUtils.transform(healthXtInfo, checkDetail);
		TransformUtils.transform(healthZlyyInfo, checkDetail);
		TransformUtils.transform(healthInfo, checkDetail);
		return checkDetail;
	}
	
	/**
	 * 体检信息保存
	 *
	 * @param healthCheckSave 体检信息保存对象
	 * @return 体检编号
	 * @author xiao.xl 2022/6/18 10:42
	 */
	@Transactional(transactionManager = "sqlTransactionManager", rollbackFor = RuntimeException.class)
	public Long saveCheckInfo(HealthCheckSaveDTO healthCheckSave) {
		Long id = healthCheckSave.getId();
		if (Objects.isNull(id)) {
		    // 新增
			id = insertCheckInfo(healthCheckSave);
		} else {
			// 更新
			updateCheckInfo(healthCheckSave);
		}
		return id;
	}
	
	/**
	 * 更新体检信息
	 *
	 * @param healthCheckSave 体检信息
	 * @author xiao.xl 2022/6/18 12:47
	 */
	private void updateCheckInfo(HealthCheckSaveDTO healthCheckSave) {
		Long id = healthCheckSave.getId();
		HealthInfo healthInfo = healthInfoService.getById(id);
		if (Objects.isNull(healthInfo)) {
			log.error("health_info，体检编号为：<%s>的信息不存在");
			throw BusinessException.paramError(String.format("体检编号为：<%s>的信息有误，请联系管理员排查", id));
		}
		TransformUtils.transform(healthCheckSave, healthInfo);
		healthInfoService.saveOrUpdate(healthInfo);
		// 生活方式
		HealthShfsInfo healthShfsInfo = healthShfsInfoService.getByHealthInfoId(id);
		if (Objects.nonNull(healthShfsInfo)) {
			Long shId = healthShfsInfo.getId();
			TransformUtils.transform(healthCheckSave, healthShfsInfo);
			healthShfsInfo.setId(shId);
			healthShfsInfo.setHealthInfoId(id);
			healthShfsInfoService.saveOrUpdate(healthShfsInfo);
		}
		// 宣体信息
		HealthXtInfo healthXtInfo = healthXtInfoService.getByHealthInfoId(id);
		if (Objects.nonNull(healthXtInfo)) {
			Long xtId = healthXtInfo.getId();
			TransformUtils.transform(healthCheckSave, healthXtInfo);
			healthXtInfo.setId(xtId);
			healthXtInfo.setHealthInfoId(id);
			healthXtInfoService.saveOrUpdate(healthXtInfo);
		}
		// 辅助检查
		HealthFzjcInfo healthFzjcInfo = healthFzjcInfoService.getByHealthInfoId(id);
		if (Objects.nonNull(healthFzjcInfo)) {
			Long jcId = healthFzjcInfo.getId();
			TransformUtils.transform(healthCheckSave, healthFzjcInfo);
			healthFzjcInfo.setId(jcId);
			healthFzjcInfo.setHealthInfoId(id);
			healthFzjcInfoService.saveOrUpdate(healthFzjcInfo);
		}
		// 治疗用药接种
		HealthZlyyInfo healthZlyyInfo = healthZlyyInfoService.getByHealthInfoId(id);
		if (Objects.nonNull(healthZlyyInfo)) {
			Long zlId = healthZlyyInfo.getId();
			TransformUtils.transform(healthCheckSave, healthZlyyInfo);
			healthZlyyInfo.setId(zlId);
			healthZlyyInfo.setHealthInfoId(id);
			healthZlyyInfoService.saveOrUpdate(healthZlyyInfo);
		}
	}
	
	/**
	 * 新增体检信息
	 *
	 * @param healthCheckSave 体检信息
	 * @return 体检编号
	 * @author xiao.xl 2022/6/18 12:46
	 */
	private Long insertCheckInfo(HealthCheckSaveDTO healthCheckSave) {
		// 体检基础信息
		HealthInfo healthInfo = TransformUtils.transform(healthCheckSave, HealthInfo.class);
		healthInfoService.save(healthInfo);
		Long id = healthInfo.getId();
		// 体检-生活方式
		HealthShfsInfo healthShfsInfo = TransformUtils.transform(healthCheckSave, HealthShfsInfo.class);
		healthShfsInfo.setHealthInfoId(id);
		healthShfsInfoService.save(healthShfsInfo);
		// 体检-辅助检查
		HealthFzjcInfo healthFzjcInfo = TransformUtils.transform(healthCheckSave, HealthFzjcInfo.class);
		healthFzjcInfo.setHealthInfoId(id);
		healthFzjcInfoService.save(healthFzjcInfo);
		// 体检-宣体信息
		HealthXtInfo healthXtInfo = TransformUtils.transform(healthCheckSave, HealthXtInfo.class);
		healthXtInfo.setHealthInfoId(id);
		healthXtInfoService.save(healthXtInfo);
		// 体检-治疗用药接种信息
		HealthZlyyInfo healthZlyyInfo = TransformUtils.transform(healthCheckSave, HealthZlyyInfo.class);
		healthZlyyInfo.setHealthInfoId(id);
		healthZlyyInfoService.save(healthZlyyInfo);
		return id;
	}
	
	/**
	 * Excel导出
	 *
	 * @param query 导出数据参数
	 * @param response 响应对象
	 * @author xiao.xl 2022/6/18 12:37
	 */
	public void exportCheckExcel(HealthCheckPageDTO query, HttpServletResponse response) {
		if (Objects.nonNull(query.getStartDate())) {
			query.setStartDate(DateUtil.beginOfDay(query.getStartDate()));
		}
		if (Objects.nonNull(query.getEndDate())) {
			query.setEndDate(DateUtil.endOfDay(query.getEndDate()));
		}
		List<HealthCheckExcelVO> checkExcelList = healthInfoService.listExcelInfo(query);
		if (CollectionUtil.isEmpty(checkExcelList)) {
			throw BusinessException.paramError("当前参数条件下，不存在体检数据");
		}
		// 数据处理
		doDataBaseInfo(checkExcelList);
		ExportParams exportParams = new ExportParams();
		// 列超过256需要设置为XSSF格式，容许16384
		exportParams.setType(ExcelType.XSSF);
		Workbook workbook = ExcelExportUtil.exportExcel(exportParams, HealthCheckExcelVO.class, checkExcelList);
		try (ServletOutputStream outputStream = response.getOutputStream()) {
			String filename = "体检信息表-" + DateUtil.format(new Date(), DatePattern.NORM_DATE_PATTERN) + ".xlsx";
			filename = new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
			response.setCharacterEncoding(CharsetUtil.UTF_8);
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=" + filename);
			workbook.write(outputStream);
		} catch (Exception e) {
			log.error("Excel数据导出异常, 异常堆栈信息：{}", e.getMessage());
			throw BusinessException.paramError("Excel导出功能异常，请联系管理人处理!");
		}
		
	}
	
	private void doDataBaseInfo(List<HealthCheckExcelVO> checkExcelList) {
		checkExcelList.forEach(item -> {
			item.setFzjcBcJcbw(doPrefix(item.getFzjcBcJcbw()));
			item.setJctj(doPrefix(item.getJctj()));
			item.setZz(doPrefix(item.getZz()));
			item.setZqgnKqClZt(doPrefix(item.getZqgnKqClZt()));
			item.setXczyjkwtNxgjb(doPrefix(item.getXczyjkwtNxgjb()));
			item.setXczyjkwtSzjb(doPrefix(item.getXczyjkwtSzjb()));
			item.setXczyjkwtXzjb(doPrefix(item.getXczyjkwtXzjb()));
			item.setXczyjkwtXgjb(doPrefix(item.getXczyjkwtXgjb()));
			item.setXczyjkwtSjxtjb(doPrefix(item.getXczyjkwtSjxtjb()));
			item.setXczyjkwtQtxtjb(doPrefix(item.getXczyjkwtQtxtjb()));
			item.setJkzdZt(doPrefix(item.getJkzdZt()));
			item.setWxyskzZt(doPrefix(item.getWxyskzZt()));
			item.setShfsYjqkYjzl(doPrefix(item.getShfsYjqkYjzl()));
			item.setXtFLy(doPrefix(item.getXtFLy()));
			item.setXtRx(doPrefix(item.getXtRx()));
			item.setXczyjkwtYbjb(doPrefix(item.getXczyjkwtYbjb()));
		});
	}
	
	/**
	 * 复选框前缀
	 */
	private static final String CHECK_PREFIX_STR = "array_prefix_";
	
	/**
	 * 复选框前缀处理
	 *
	 * @param field 字段值
	 * @return 取前缀字段值
	 * @author xiao.xl 2022/6/30 0:33
	 */
	private String doPrefix(String field) {
		if (StringUtils.isNotBlank(field) && field.startsWith(CHECK_PREFIX_STR))  {
			return field.replaceFirst(CHECK_PREFIX_STR, StringPools.EMPTY);
		}
		return StringPools.EMPTY;
	}
	
	/**
	 * 获取体检异常消息
	 *
	 * @param healthCheckSaveDTO 体检报告信息
	 * @return 体检异常对象
	 * @author xiao.xl 2022/6/20 21:35
	 */
	public CheckAbnormalVO getAbnormalInfo(HealthCheckSaveDTO healthCheckSaveDTO) {
		CheckAbnormalVO checkAbnormal = new CheckAbnormalVO();
		String jkpjSfyc = "无";
		// 异常1
		String abnormal1 = getAbnormal1(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal1)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc1(abnormal1);
		} else { checkAbnormal.setJkpjYc1(""); }
		// 异常2
		String abnormal2 = getAbnormal2(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal2)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc2(abnormal2);
		} else { checkAbnormal.setJkpjYc2(""); }
		// 异常3
		String abnormal3 = getAbnormal3(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal3)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc3(abnormal3);
		} else { checkAbnormal.setJkpjYc3(""); }
		// 异常4
		String abnormal4 = getAbnormal4(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal4)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc4(abnormal4);
		} else { checkAbnormal.setJkpjYc4(""); }
		// 异常5
		String abnormal5 = getAbnormal5(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal5)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc5(abnormal5);
		} else { checkAbnormal.setJkpjYc5(""); }
		// 异常6
		String abnormal6 = getAbnormal6(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal6)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc6(abnormal6);
		} else { checkAbnormal.setJkpjYc6(""); }
		// 异常7
		String abnormal7 = getAbnormal7(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal7)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc7(abnormal7);
		} else { checkAbnormal.setJkpjYc7(""); }
		// 异常8
		String abnormal8 = getAbnormal8(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal8)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc8(abnormal8);
		} else { checkAbnormal.setJkpjYc8(""); }
		// 异常9
		String abnormal9 = getAbnormal9(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal9)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc9(abnormal9);
		} else { checkAbnormal.setJkpjYc9(""); }
		// 异常10
		String abnormal10 = getAbnormal10(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal10)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc10(abnormal10);
		} else { checkAbnormal.setJkpjYc10(""); }
		// 异常11
		String abnormal11 = getAbnormal11(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal11)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc11(abnormal11);
		} else { checkAbnormal.setJkpjYc11(""); }
		// 异常12
		String abnormal12 = getAbnormal12(healthCheckSaveDTO);
		if (StringUtils.isNotBlank(abnormal12)) {
			jkpjSfyc = "有";
			checkAbnormal.setJkpjYc12(abnormal12);
		} else { checkAbnormal.setJkpjYc12(""); }
		checkAbnormal.setJkpjSfyc(jkpjSfyc);
		return checkAbnormal;
	}
	
	/**
	 * 健康评价-异常12
	 * 指标（症状、其他症状）
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常12
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal12(HealthCheckSaveDTO healthCheckSaveDTO) {
		StringBuilder abnormal = new StringBuilder();
		appendErrorInfo(abnormal, healthCheckSaveDTO.getZz());
		appendErrorInfo(abnormal, healthCheckSaveDTO.getZzQt());
		return abnormal.toString();
	}
	
	/**
	 * 健康评价-异常11
	 * 指标（牙齿、视力、老年人健康状态、老年人生活自理能力、老年人认知功能、老年人情感状态）
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常11
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal11(HealthCheckSaveDTO healthCheckSaveDTO) {
		StringBuilder abnormal = new StringBuilder();
		// 牙齿
		String yz = healthCheckSaveDTO.getZqgnKqClZt();
		if (StringUtils.isNotBlank(yz) && !StringUtils.equals("正常", yz)) {
			appendErrorInfo(abnormal, yz);
		}
		// 视力
		if (compareSize(healthCheckSaveDTO.getZqgnSlZy(), "5.0") || compareSize(healthCheckSaveDTO.getZqgnSlYy(), "5.0")
		|| compareSize(healthCheckSaveDTO.getZqgnSlJzslZy(), "5.0") || compareSize(healthCheckSaveDTO.getZqgnSlJzslYy(), "5.0")) {
			appendErrorInfo(abnormal, "视力减退");
		}
		appendErrorInfo(abnormal, healthCheckSaveDTO.getZqgnSlQtslms());
		// 老年人健康状态
		if (!StringUtils.equals("满意", healthCheckSaveDTO.getYbztLnrjkztzwpg())) {
			appendErrorInfo(abnormal, healthCheckSaveDTO.getYbztLnrjkztzwpg());
		}
		// 老年人生活自理能力
		if (!StringUtils.equals("可自理",healthCheckSaveDTO.getYbztLnrshzlnlzwpg())) {
			appendErrorInfo(abnormal, healthCheckSaveDTO.getYbztLnrshzlnlzwpg());
		}
		// 老年人认知功能
		if (!StringUtils.equals("粗筛阴性",healthCheckSaveDTO.getYbztLnrrzgn())) {
			appendErrorInfo(abnormal, healthCheckSaveDTO.getYbztLnrrzgn());
		}
		// 老年人情感状态
		if (!StringUtils.equals("粗筛阴性",healthCheckSaveDTO.getYbztLnrqgzt())) {
			appendErrorInfo(abnormal, healthCheckSaveDTO.getYbztLnrqgzt());
		}
		return abnormal.toString();
	}
	
	/**
	 * 健康评价-异常10
	 * 指标（腰围）
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常10
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal10(HealthCheckSaveDTO healthCheckSaveDTO) {
		String hzxb = healthCheckSaveDTO.getHzxb();
		String ybztYw = healthCheckSaveDTO.getYbztYw();
		if ((StringUtils.equals(hzxb, "男") && compareSize(ybztYw, "90"))
				|| (StringUtils.equals(hzxb, "女") && compareSize(ybztYw, "85"))) {
			return "腹型肥胖";
		}
		return StringPool.EMPTY;
	}
	
	/**
	 * 健康评价-异常9
	 * 指标（体质指数）
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常9
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal9(HealthCheckSaveDTO healthCheckSaveDTO) {
		String ybztTzzsBmi = healthCheckSaveDTO.getYbztTzzsBmi();
		if (StringUtils.isNotBlank(ybztTzzsBmi)) {
			if (compareSize(ybztTzzsBmi, "30")) {
				return "重度肥胖";
			} else if (compareSize(ybztTzzsBmi, "27")) {
				return "肥胖";
			} else if (compareSize(ybztTzzsBmi, "24")) {
				return "偏胖";
			} else if (compareSize("18.5", ybztTzzsBmi)) {
				return "偏瘦";
			}
		}
		return StringPool.EMPTY;
	}
	
	/**
	 * 健康评价-异常8 TODO 血糖考虑年龄
	 * 指标（血压、血糖、糖化血红蛋白）
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常8
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal8(HealthCheckSaveDTO healthCheckSaveDTO) {
		StringBuilder abnormal = new StringBuilder();
		// 血压
		String zcssy = healthCheckSaveDTO.getYbztXyzcssy();
		String zcszy = healthCheckSaveDTO.getYbztXyzcszy();
		String ycssy = healthCheckSaveDTO.getYbztXyycssy();
		String ycszy = healthCheckSaveDTO.getYbztXyycszy();
		String hzsfz = healthCheckSaveDTO.getHzsfz();
		if (!StringUtils.isAllBlank(zcssy, zcssy, ycssy, ycssy)) {
			if (compareSize("90", zcssy) || compareSize("90", ycssy)
						|| compareSize("60", zcszy) || compareSize("60", ycszy)) {
				appendErrorInfo(abnormal, "血压偏低");
			} else if (compareSize(zcssy, "180") || compareSize(ycssy, "180")
							   || compareSize(zcszy, "110") || compareSize(ycszy, "110")) {
				appendErrorInfo(abnormal, "高血压，血压偏高");
			} else if (StringUtils.isNotBlank(hzsfz) && getAgeByIdCard(hzsfz) != null) {
				Integer age = this.getAgeByIdCard(hzsfz);
				if (age >=65 && ((compareSize(zcssy, "149") && compareSize("180", zcssy))
										 || (compareSize(ycssy, "149") && compareSize("180", ycssy)))) {
				     appendErrorInfo(abnormal, "高血压，血压偏高");
				} else if (age < 65 && (compareSize(zcssy, "139") || compareSize(ycssy, "139"))) {
					appendErrorInfo(abnormal, "高血压，血压偏高");
				}
			} else if (compareSize(zcssy, "139") || compareSize(ycssy, "139")
							   || compareSize(zcszy, "89") || compareSize(ycszy, "89")) {
				appendErrorInfo(abnormal, "血压偏高");
			}
		}
		// 血糖
		String kfxt1 = healthCheckSaveDTO.getFzjcKfxtmmoll();
		String kfxt2 = healthCheckSaveDTO.getFzjcKfxtmgdl();
		if (compareSize(kfxt1, "6.1") || compareSize(kfxt2, "6.1")) {
			appendErrorInfo(abnormal, "血糖偏高");
		} else if (compareSize("3.8", kfxt1) || compareSize(kfxt2, "3.8")) {
			appendErrorInfo(abnormal, "血糖偏低");
		}
		
		// 糖化血红蛋白
		String fzjcThxhdb = healthCheckSaveDTO.getFzjcThxhdb();
		if (compareSize(fzjcThxhdb, "6.1")) {
			appendErrorInfo(abnormal, "糖化血红蛋白偏高");
		} else if (compareSize("3.8", fzjcThxhdb)) {
			appendErrorInfo(abnormal, "糖化血红蛋白偏低");
		}
		return abnormal.toString();
	}
	
	/**
	 * 健康评价-异常7
	 * 指标（）
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常7
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal7(HealthCheckSaveDTO healthCheckSaveDTO) {
		return null;
	}
	
	/**
	 * 健康评价-异常6
	 * 指标（B超）
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常6
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal6(HealthCheckSaveDTO healthCheckSaveDTO) {
		return getInfoOrEmpty(healthCheckSaveDTO.getFzjcBcZtyc());
	}
	
	private String getInfoOrEmpty(String msg) {
		return StringUtils.isBlank(msg) ? StringPool.EMPTY : msg;
	}
	
	/**
	 * 健康评价-异常5
	 * 指标（心电图）
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常5
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal5(HealthCheckSaveDTO healthCheckSaveDTO) {
		return getInfoOrEmpty(healthCheckSaveDTO.getFzjcXdtYcms());
	}
	
	/**
	 * 健康评价-异常4
	 * 指标（血红蛋白、白细胞、血小板、红细胞、中性粒细胞绝对值、淋巴细胞绝对值、单核细胞数、嗜酸性粒细胞数、
	 * 嗜碱性粒细胞数、血清谷丙转氨酶、血清谷草转氨酶、白蛋白、总胆红素、血清肌酐、血尿素、尿酸、总胆固醇
	 * 甘油三酯、血清低密度脂蛋白胆固醇、血清高密度脂蛋白胆固醇）
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常4
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal4(HealthCheckSaveDTO healthCheckSaveDTO) {
		StringBuilder abnormal = new StringBuilder();
		// 血红蛋白
		String xhdb= healthCheckSaveDTO.getFzjcXcgXhdb();
		String hzxb = healthCheckSaveDTO.getHzxb();
		if (StringUtils.isNoneBlank(xhdb, hzxb)) {
			if ((StringUtils.equals("男", hzxb) && compareSize(xhdb, "175")) || (StringUtils.equals("女", hzxb) && compareSize(xhdb, "150")) ) {
			    appendErrorInfo(abnormal, "血红蛋白偏高");
			} else if ((StringUtils.equals("男", hzxb) && compareSize("130", xhdb)) || (StringUtils.equals("男", hzxb) && compareSize("115", xhdb))) {
				appendErrorInfo(abnormal, "血红蛋白偏低");
			}
		}
		// 白细胞
		String bxb = healthCheckSaveDTO.getFzjcXcgBxb();
		if (StringUtils.isNotBlank(bxb)) {
			if (compareSize(bxb, "9.5")) {
				appendErrorInfo(abnormal, "白细胞偏高");
			} else if (compareSize("3.5", bxb)) {
				appendErrorInfo(abnormal, "白细胞偏低");
			}
		}
		// 血小板
		String xxb = healthCheckSaveDTO.getFzjcXcgXxb();
		if (StringUtils.isNotBlank(xxb)) {
			if (compareSize(xxb, "350")) {
				appendErrorInfo(abnormal, "血小板偏高");
			} else if (compareSize("125", xxb)) {
				appendErrorInfo(abnormal, "血小板偏低");
			}
		}
		// 红细胞
		String hxb = healthCheckSaveDTO.getFzjcXcgHxb();
		if (StringUtils.isNoneBlank(hxb, hzxb)) {
			if ((StringUtils.equals("男", hzxb) && compareSize(hxb, "5.8")) || (StringUtils.equals("女", hzxb) && compareSize(hxb, "5.1")) ) {
				appendErrorInfo(abnormal, "红细胞偏高");
			} else if ((StringUtils.equals("男", hzxb) && compareSize("4.3", hxb)) || (StringUtils.equals("男", hzxb) && compareSize("3.8", hxb))) {
				appendErrorInfo(abnormal, "红细胞偏低");
			}
		}
		// 中性粒细胞绝对值
		String zxlxbjdz = healthCheckSaveDTO.getFzjcXcgZxlxbjdz();
		if (StringUtils.isNotBlank(zxlxbjdz)) {
			if (compareSize(zxlxbjdz, "6.3")) {
				appendErrorInfo(abnormal, "中性粒细胞偏高");
			} else if (compareSize("1.8", zxlxbjdz)) {
				appendErrorInfo(abnormal, "中性粒细胞偏低");
			}
		}
		// 淋巴细胞绝对值
		String lbxbjdz = healthCheckSaveDTO.getFzjcXcgLbxbjdz();
		if (StringUtils.isNotBlank(lbxbjdz)) {
			if (compareSize(lbxbjdz, "4")) {
				appendErrorInfo(abnormal, "淋巴细胞绝对值偏高");
			} else if (compareSize("0.8", lbxbjdz)) {
				appendErrorInfo(abnormal, "淋巴细胞绝对值偏低");
			}
		}
		// 单核细胞数
		String dhxbs = healthCheckSaveDTO.getFzjcXcgDhxbs();
		if (StringUtils.isNotBlank(dhxbs)) {
			if (compareSize(dhxbs, "0.6")) {
				appendErrorInfo(abnormal, "单核细胞绝对值偏高");
			} else if (compareSize("0.1", dhxbs)) {
				appendErrorInfo(abnormal, "单核细胞绝对值偏低");
			}
		}
		// 嗜酸性粒细胞数
		String ssxlxbs = healthCheckSaveDTO.getFzjcXcgSsxlxbs();
		if (StringUtils.isNotBlank(ssxlxbs)) {
			if (compareSize(ssxlxbs, "0.52")) {
				appendErrorInfo(abnormal, "嗜酸性粒细胞数偏高");
			} else if (compareSize("0.02", ssxlxbs)) {
				appendErrorInfo(abnormal, "嗜酸性粒细胞绝对值偏高");
			}
		}
		// 嗜碱性粒细胞数
		String sjxlxbs = healthCheckSaveDTO.getFzjcXcgSjxlxbs();
		if (StringUtils.isNotBlank(sjxlxbs)) {
			if (compareSize(sjxlxbs, "0.06")) {
				appendErrorInfo(abnormal, "嗜碱性粒细胞绝对值偏高");
			}
		}
		// 血清谷丙转氨酶
		String xqgbzam = healthCheckSaveDTO.getFzjcGgnXqgbzam();
		if (StringUtils.isNoneBlank(xqgbzam, hzxb)) {
			if ((StringUtils.equals("男", hzxb) && compareSize(xqgbzam, "50")) || (StringUtils.equals("女", hzxb) && compareSize(xqgbzam, "40")) ) {
				appendErrorInfo(abnormal, "谷丙转氨酶偏高");
			} else if ((StringUtils.equals("男", hzxb) && compareSize("9", xqgbzam)) || (StringUtils.equals("男", hzxb) && compareSize("7", xqgbzam))) {
				appendErrorInfo(abnormal, "谷丙转氨酶偏低");
			}
		}
		// 血清谷草转氨酶
		String xqgczam = healthCheckSaveDTO.getFzjcGgnXqgczam();
		if (StringUtils.isNoneBlank(xqgczam, hzxb)) {
			if ((StringUtils.equals("男", hzxb) && compareSize(xqgczam, "40")) || (StringUtils.equals("女", hzxb) && compareSize(xqgczam, "35")) ) {
				appendErrorInfo(abnormal, "谷草转氨酶偏高");
			} else if ((StringUtils.equals("男", hzxb) && compareSize("15", xqgczam)) || (StringUtils.equals("男", hzxb) && compareSize("13", xqgczam))) {
				appendErrorInfo(abnormal, "谷草转氨酶偏低");
			}
		}
		// 白蛋白
		// 总胆红素
		String zdhs = healthCheckSaveDTO.getFzjcGgnZdhs();
		if (StringUtils.isNotBlank(zdhs)) {
			if (compareSize(zdhs, "22")) {
				appendErrorInfo(abnormal, "总胆红素偏高");
			} else if (compareSize("1.7", zdhs)) {
				appendErrorInfo(abnormal, "总胆红素偏低");
			}
		}
		// 血清肌酐
		String xqjg = healthCheckSaveDTO.getFzjcSgnXqjg();
		String hzsfz = healthCheckSaveDTO.getHzsfz();
		if (StringUtils.isNoneBlank(xqjg, hzxb, hzsfz)) {
			int age = this.getAgeByIdCard(hzsfz);
			if (age >= 0) {
				if ((StringUtils.equals("女", hzxb) && compareSize(xqjg, "81"))
							|| (StringUtils.equals("男", hzxb) && age >= 60 && compareSize(xqjg, "111"))
							|| (StringUtils.equals("男", hzxb) && age < 60 && compareSize(xqjg, "97"))) {
					appendErrorInfo(abnormal, "肌酐偏高");
				} else if ((StringUtils.equals("女", hzxb) && compareSize("41", xqjg)) || (StringUtils.equals("男", hzxb) && compareSize("51", xqjg))) {
					appendErrorInfo(abnormal, "肌酐偏低");
				}
			}
		}
		// 血尿素
		String xns = healthCheckSaveDTO.getFzjcSgnXns();
		if (StringUtils.isNoneBlank(xns, hzxb, hzsfz)) {
			String age = this.getAgeByIdCard(hzsfz) + "";
			if ((StringUtils.equals("女", hzxb) && compareSize(xns, "8.8") && compareSize(age, "60"))
						|| (StringUtils.equals("女", hzxb) && compareSize(xns, "7.5") && compareSize("60", age))
						|| (StringUtils.equals("男", hzxb) && compareSize(xns, "9.5") && compareSize(age, "60"))
						|| (StringUtils.equals("男", hzxb) && compareSize(xns, "8.0") && compareSize("60", age))) {
				appendErrorInfo(abnormal, "血尿素偏高");
			} else if ((StringUtils.equals("女", hzxb) && compareSize("3.1", xns) && compareSize(age, "60"))
						|| (StringUtils.equals("女", hzxb) && compareSize("2.6", xns) && compareSize("60", age))
						|| (StringUtils.equals("男", hzxb) && compareSize("3.6", xns) && compareSize(age, "60"))
						|| (StringUtils.equals("男", hzxb) && compareSize("3.1", xns) && compareSize("60", age))) {
				appendErrorInfo(abnormal, "血尿素偏低");
			}
		}
		
		// 尿酸
		String ns = healthCheckSaveDTO.getFzjcSgnNs();
		if (StringUtils.isNotBlank(ns)) {
			if (compareSize(ns, "452")) {
				appendErrorInfo(abnormal, "尿酸偏高");
			} else if (compareSize("90", ns)) {
				appendErrorInfo(abnormal, "尿酸偏低");
			}
		}
		// 总胆固醇
	    // 甘油三酯
		// 血清低密度脂蛋白胆固醇
		// 血清高密度脂蛋白胆固醇
		String xqgmdzdbdgc = healthCheckSaveDTO.getFzjcXzXqgmdzdbdgc();
		if (compareSize("0.83", xqgmdzdbdgc)) {
		    appendErrorInfo(abnormal, "高密度脂蛋白偏低");
		}
		return null;
	}
	
	
	private Integer getAgeByIdCard(String sfz) {
		try {
			return IdcardUtil.getAgeByIdCard(sfz);
		} catch (Exception e) {
		
		}
		return -1;
	}
	
	/**
	 * 健康评价-异常3
	 * 指标（尿蛋白、尿糖、尿酮体、尿潜血、尿白细胞、尿胆红素）
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常3
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal3(HealthCheckSaveDTO healthCheckSaveDTO) {
		StringBuilder abnormal = new StringBuilder();
		// 尿蛋白
		String ndb = healthCheckSaveDTO.getFzjcNcgNdb();
		if (StringUtils.isNotBlank(ndb) && !StringUtils.equals("阴性", ndb)) {
			if (StringUtils.equals("弱阳性", ndb)) {
				appendErrorInfo(abnormal, "尿白细胞弱阳性");
			} else {
				appendErrorInfo(abnormal, "尿白细胞阳性");
			}
		}
		// 尿糖
		String nt = healthCheckSaveDTO.getFzjcNcgNt();
		if (StringUtils.isNotBlank(nt) && !StringUtils.equals("阴性", nt)) {
			if (StringUtils.equals("弱阳性", nt)) {
				appendErrorInfo(abnormal, "尿糖弱阳性");
			} else {
				appendErrorInfo(abnormal, "尿糖阳性");
			}
		}
		// 尿酮体
		String ntt = healthCheckSaveDTO.getFzjcNcgNtt();
		if (StringUtils.isNotBlank(ntt) && !StringUtils.equals("阴性", ntt)) {
			if (StringUtils.equals("弱阳性", ntt)) {
				appendErrorInfo(abnormal, "尿酮体弱阳性");
			} else {
				appendErrorInfo(abnormal, "尿酮体阳性");
			}
		}
		// 尿潜血
		String nqx = healthCheckSaveDTO.getFzjcNcgNqx();
		if (StringUtils.isNotBlank(nqx) && !StringUtils.equals("阴性", nqx)) {
			if (StringUtils.equals("弱阳性", nqx)) {
				appendErrorInfo(abnormal, "尿潜血弱阳性");
			} else {
				appendErrorInfo(abnormal, "尿潜血阳性");
			}
		}
		// 尿白细胞
		String nbxb = healthCheckSaveDTO.getFzjcNcgNbxb();
		if (StringUtils.isNotBlank(nbxb) && !StringUtils.equals("阴性", nbxb)) {
			if (StringUtils.equals("弱阳性", nbxb)) {
				appendErrorInfo(abnormal, "尿白细胞弱阳性");
			} else {
				appendErrorInfo(abnormal, "尿白细胞阳性");
			}
		}
		// 尿胆红素
		String ndhs = healthCheckSaveDTO.getFzjcNcgNdhs();
		if (StringUtils.isNotBlank(ndhs) && !StringUtils.equals("阴性", ndhs)) {
			if (StringUtils.equals("弱阳性", ndhs)) {
				appendErrorInfo(abnormal, "尿胆红素弱阳性");
			} else {
				appendErrorInfo(abnormal, "尿胆红素阳性");
			}
		}
		return abnormal.toString();
	}
	
	/**
	 * 健康评价-异常2
	 * 指标(口唇、咽部、听力、皮肤、巩膜、淋巴结、桶状胸、呼吸音、罗音、心律、杂音、压痛)
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常2
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal2(HealthCheckSaveDTO healthCheckSaveDTO) {
		StringBuilder abnormalBuilder = new StringBuilder();
		// 口唇
		String kqKc = healthCheckSaveDTO.getZqgnKqKc();
		if (StringUtils.isNotBlank(kqKc) && !StringUtils.equals("红润", kqKc)) {
			appendErrorInfo(abnormalBuilder, "口唇" + kqKc);
		}
		// 咽部
		String kqyb = healthCheckSaveDTO.getZqgnKqYb();
		if (StringUtils.isNotBlank(kqyb) && !StringUtils.equals("无充血", kqyb)) {
			appendErrorInfo(abnormalBuilder, "咽部" + kqyb);
		}
		// 听力
		String tlzt = healthCheckSaveDTO.getZqgnTlZt();
		if (StringUtils.isNotBlank(tlzt) && !StringUtils.equals("听见", tlzt)) {
			appendErrorInfo(abnormalBuilder, "听力" + tlzt);
		}
		// 皮肤
		String pfzt = healthCheckSaveDTO.getXtPfzt();
		if (StringUtils.isNotBlank(pfzt) && !StringUtils.equals("正常", pfzt)) {
			if (StringUtils.equals("其他", pfzt)) {
				if (StringUtils.isNotBlank(healthCheckSaveDTO.getXtPfQt())) {
					appendErrorInfo(abnormalBuilder, "皮肤" + healthCheckSaveDTO.getXtPfQt());
				}
			} else {
				appendErrorInfo(abnormalBuilder, "皮肤" + pfzt);
			}
		}
		// 巩膜
		String gmzt = healthCheckSaveDTO.getXtGmzt();
		if (StringUtils.isNotBlank(gmzt) && !StringUtils.equals("正常", gmzt)) {
			if (StringUtils.equals("其他", gmzt)) {
				if (StringUtils.isNotBlank(healthCheckSaveDTO.getXtGmQt())) {
					appendErrorInfo(abnormalBuilder, "巩膜" + healthCheckSaveDTO.getXtGmQt());
				}
			} else {
				appendErrorInfo(abnormalBuilder, "巩膜" + gmzt);
			}
		}
		// 淋巴结
		String lbjzt = healthCheckSaveDTO.getXtLbjzt();
		if (StringUtils.isNotBlank(lbjzt) && !StringUtils.equals("未触及", lbjzt)) {
			if (StringUtils.equals("其他", lbjzt)) {
				if (StringUtils.isNotBlank(healthCheckSaveDTO.getXtLbjQt())) {
					appendErrorInfo(abnormalBuilder, "淋巴结" + healthCheckSaveDTO.getXtLbjQt());
				}
			} else {
				appendErrorInfo(abnormalBuilder, "淋巴结" + lbjzt);
			}
		}
		// 桶状胸
		String tzx = healthCheckSaveDTO.getXtFTzx();
		if (StringUtils.isNotBlank(tzx) && StringUtils.equals("是", tzx)) {
			appendErrorInfo(abnormalBuilder, "桶状胸");
		}
		// 呼吸音
		String hxy = healthCheckSaveDTO.getXtFHxy();
		if (StringUtils.isNotBlank(hxy) && !StringUtils.equals("正常", hxy)) {
			appendErrorInfo(abnormalBuilder, "呼吸音异常");
		}
		// 罗音
		String ly = healthCheckSaveDTO.getXtFLy();
		if (StringUtils.isNotBlank(ly) && !StringUtils.equals("无", ly)) {
			if (StringUtils.equals("其他", ly)) {
				if (StringUtils.isNotBlank(healthCheckSaveDTO.getXtFLyQt())) {
					appendErrorInfo(abnormalBuilder, "罗音" + healthCheckSaveDTO.getXtFLyQt());
				}
			} else {
				appendErrorInfo(abnormalBuilder, "罗音" + lbjzt);
			}
		}
		// 心律
		String xl2 = healthCheckSaveDTO.getXtXzXl2();
		if (StringUtils.isNotBlank(xl2) && !StringUtils.equals("齐", xl2)) {
			appendErrorInfo(abnormalBuilder, "心律" + xl2);
		}
		// 杂音
		String zyyw = healthCheckSaveDTO.getXtXzZyyw();
		if (StringUtils.isNotBlank(zyyw) && !StringUtils.equals("无", zyyw)
					&& StringUtils.isNotBlank(healthCheckSaveDTO.getXtXzZyms())) {
			appendErrorInfo(abnormalBuilder, "心脏有杂音");
		}
		// 压痛
		String ytyw = healthCheckSaveDTO.getXtFbYtyw();
		if (StringUtils.isNotBlank(ytyw) && !StringUtils.equals("无", ytyw)
					&& StringUtils.isNotBlank(healthCheckSaveDTO.getXtFbYtms())) {
			appendErrorInfo(abnormalBuilder, "腹部有压痛");
		}
		return abnormalBuilder.toString();
	}
	
	/**
	 * 健康评价-异常1
	 * 指标(体温、脉率、呼吸频率)
	 *
	 * @param healthCheckSaveDTO 体检信息
	 * @return 异常1
	 * @author xiao.xl 2022/6/20 21:40
	 */
	private String getAbnormal1(HealthCheckSaveDTO healthCheckSaveDTO) {
		StringBuilder abnormalBuilder = new StringBuilder();
		// 体温
		String ybztTw = healthCheckSaveDTO.getYbztTw();
		if (StringUtils.isNotBlank(ybztTw)) {
			String twyc = "";
			if (compareSize(ybztTw, "39")) {
				twyc = "发热-建议转诊";
			} else if (compareSize(ybztTw, "37.2")) {
				twyc = "发热-建议复诊";
			}
			appendErrorInfo(abnormalBuilder, twyc);
		}
		// 脉率
		String ybztMl = healthCheckSaveDTO.getYbztMl();
		if (StringUtils.isNotBlank(ybztMl)) {
			String mlyc = "";
			if (compareSize(ybztMl, "100")) {
				mlyc = "心率过速";
			} else if (compareSize("60", ybztMl)) {
				mlyc = "心率过缓";
			}
			appendErrorInfo(abnormalBuilder, mlyc);
		}
		// 呼吸频率
		String ybztHxpl = healthCheckSaveDTO.getYbztHxpl();
		if (StringUtils.isNotBlank(ybztHxpl)) {
			String hxpl = "";
			if (compareSize(ybztHxpl, "24")) {
				hxpl = "呼吸过速";
			} else if (compareSize("12", ybztHxpl)) {
				hxpl = "呼吸过缓";
			}
			appendErrorInfo(abnormalBuilder, hxpl);
		}
		return abnormalBuilder.toString();
	}
	
	/**
	 * 错误信息冒号拼接
	 *
	 * @author xiao.xl 2022/6/20 22:30
	 */
	private void appendErrorInfo(StringBuilder sb, String errorMsg) {
		if (StringUtils.isNoneEmpty(sb, errorMsg)) {
			sb.append(StringPools.SEMICOLON).append(errorMsg);
		} else if (StringUtils.isNotBlank(errorMsg)) {
			sb.append(errorMsg);
		}
	}
	
	/**
	 * 比较字符串方法
	 * num >= standard           true
	 * num < standard          false
	 * NumberUtil#round转化异常  false
	 *
	 * @param num        比较值
	 * @param standard   标准值
	 * @return true：满足异常情况
	 * @author xiao.xl 2022/6/20 21:55
	 */
	private static Boolean compareSize(String num, String standard) {
		if (StringUtils.isAnyBlank(num, standard)) {
			return false;
		}
		try {
			return NumberUtil.round(num, 2).compareTo(NumberUtil.round(standard, 2)) >= 0;
		} catch (Exception e) {
			log.error(String.format("比较错误,字符串转< %s or %s >数字错误", num, standard));
		}
		return false;
	}
	
}
