package com.health.check.admin.vo;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 健康体检明细VO
 *
 * @author xiao.xl 2022/6/18 10:37
 */
@Data
public class HealthCheckDetailVO {
	
	/* 体检基础信息 */
	/**
	 * 体检编号
	 */
	private Long id;
	
	/**
	 * 体检日期
	 */
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private Date tjrq;
	
	/**
	 * 录入医生
	 */
	private String lrys;
	
	/**
	 * 录入单位
	 */
	private String lrdw;
	
	/**
	 * 内容
	 */
	private String nr;
	
	/**
	 * 检查项目
	 */
	private String jcxm;
	
	/**
	 * 患者名称
	 */
	private String hzmc;
	
	/**
	 * 患者身份证
	 */
	private String hzsfz;
	
	/**
	 * 患者性别
	 */
	private String hzxb;
	
	/**
	 * 自定义体检编号
	 */
	private String zdytjbh;
	
	/**
	 * 备注
	 */
	private String bz;
	
	/**
	 * 体检类型
	 */
	private String tjlx;
	
	/**
	 * 检查途径
	 */
	private String jctj;
	
	/**
	 * 症状
	 */
	private String zz;
	
	/**
	 * 症状-其他
	 */
	private String zzQt;
	
	/**
	 * 一般状态-体温
	 */
	private String ybztTw;
	
	/**
	 * 一般状态-脉率
	 */
	private String ybztMl;
	
	/**
	 * 一般状态-呼吸频率
	 */
	private String ybztHxpl;
	
	/**
	 * 一般状态-血压左侧收缩压(mmHg)
	 */
	private String ybztXyzcssy;
	
	/**
	 * 一般状态-血压左侧舒张压(mmHg)
	 */
	private String ybztXyzcszy;
	
	/**
	 * 一般状态-血压右侧收缩压(mmHg)
	 */
	private String ybztXyycssy;
	
	/**
	 * 一般状态-血压右侧舒张压(mmHg)
	 */
	private String ybztXyycszy;
	
	/**
	 * 一般状态-身高
	 */
	private String ybztSg;
	
	/**
	 * 一般状态-体重
	 */
	private String ybztTz;
	
	/**
	 * 一般状态-腰围
	 */
	private String ybztYw;
	
	/**
	 * 一般状态-体质指数(BMI)
	 */
	private String ybztTzzsBmi;
	
	/**
	 * 一般状态-臀围
	 */
	private String ybztTunwei;
	
	/**
	 * 一般状态-老年人健康状态自我评估
	 */
	private String ybztLnrjkztzwpg;
	
	/**
	 * 一般状态-老年人生活自理能力自我评估
	 */
	private String ybztLnrshzlnlzwpg;
	
	/**
	 * 一般状态-老年人认知功能
	 */
	private String ybztLnrrzgn;
	
	/**
	 * 一般状态-简易智力状态检查-总分
	 */
	private String ybztJyzlztjcZf;
	
	/**
	 * 一般状态-老年人情感状态
	 */
	private String ybztLnrqgzt;
	
	/**
	 * 一般状态-老年人抑郁评分检查-总分
	 */
	private String ybztLnryypfjcZf;
	
	/**
	 * 脏器功能-口腔-口唇
	 */
	private String zqgnKqKc;
	
	/**
	 * 脏器功能-口腔-齿列-状态
	 */
	private String zqgnKqClZt;
	
	/**
	 * 脏器功能-口腔-缺齿-左上
	 */
	private String zqgnKqQcZs;
	
	/**
	 * 脏器功能-口腔-缺齿-左下
	 */
	private String zqgnKqQcZx;
	
	/**
	 * 脏器功能-口腔-缺齿-右上
	 */
	private String zqgnKqQcYs;
	
	/**
	 * 脏器功能-口腔-缺齿-右下
	 */
	private String zqgnKqQcYx;
	
	/**
	 * 脏器功能-口腔-龋齿-左上
	 */
	private String zqgnKqQuchiZs;
	
	/**
	 * 脏器功能-口腔-龋齿-左下
	 */
	private String zqgnKqQuchiZx;
	
	/**
	 * 脏器功能-口腔-龋齿-右上
	 */
	private String zqgnKqQuchiYs;
	
	/**
	 * 脏器功能-口腔-龋齿-右下
	 */
	private String zqgnKqQuchiYx;
	
	/**
	 * 脏器功能-口腔-义齿(假牙)-左上
	 */
	private String zqgnKqYcJyZs;
	
	/**
	 * 脏器功能-口腔-义齿(假牙)-左下
	 */
	private String zqgnKqYcJyZx;
	
	/**
	 * 脏器功能-口腔-义齿(假牙)-右上
	 */
	private String zqgnKqYcJyYs;
	
	/**
	 * 脏器功能-口腔-义齿(假牙)-右下
	 */
	private String zqgnKqYcJyYx;
	
	/**
	 * 脏器功能-口腔-咽部
	 */
	private String zqgnKqYb;
	
	/**
	 * 脏器功能-视力-左眼
	 */
	private String zqgnSlZy;
	
	/**
	 * 脏器功能-视力-右眼
	 */
	private String zqgnSlYy;
	
	/**
	 * 脏器功能-视力-矫正视力-左眼
	 */
	private String zqgnSlJzslZy;
	
	/**
	 * 脏器功能-视力-矫正视力-右眼
	 */
	private String zqgnSlJzslYy;
	
	/**
	 * 脏器功能-视力-其他视力描述
	 */
	private String zqgnSlQtslms;
	
	/**
	 * 脏器功能-听力-状态
	 */
	private String zqgnTlZt;
	
	/**
	 * 脏器功能-运动功能状态
	 */
	private String zqgnYdgnzt;
	
	/**
	 * 现存主要健康问题-脑血管疾病
	 */
	private String xczyjkwtNxgjb;
	
	/**
	 * 现存主要健康问题-脑血管疾病-其他
	 */
	private String xczyjkwtNxgjbQt;
	
	/**
	 * 现存主要健康问题-肾脏疾病
	 */
	private String xczyjkwtSzjb;
	
	/**
	 * 现存主要健康问题-肾脏疾病-其他
	 */
	private String xczyjkwtSzjbQt;
	
	/**
	 * 现存主要健康问题-心脏疾病
	 */
	private String xczyjkwtXzjb;
	
	/**
	 * 现存主要健康问题-心脏疾病-其他
	 */
	private String xczyjkwtXzjbQt;
	
	/**
	 * 现存主要健康问题-血管疾病
	 */
	private String xczyjkwtXgjb;
	
	/**
	 * 现存主要健康问题-血管疾病-其他
	 */
	private String xczyjkwtXgjbQt;
	
	/**
	 * 现存主要健康问题-眼部疾病
	 */
	private String xczyjkwtYbjb;
	
	/**
	 * 现存主要健康问题-眼部疾病-其他
	 */
	private String xczyjkwtYbjbQt;
	
	/**
	 * 现存主要健康问题-神经系统疾病
	 */
	private String xczyjkwtSjxtjb;
	
	/**
	 * 现存主要健康问题-神经系统疾病-其他
	 */
	private String xczyjkwtSjxtjbQt;
	
	/**
	 * 现存主要健康问题-其他系统疾病
	 */
	private String xczyjkwtQtxtjb;
	
	/**
	 * 现存主要健康问题-其他系统疾病-其他
	 */
	private String xczyjkwtQtxtjbQt;
	
	/**
	 * 健康评价-是否异常
	 */
	private String jkpjSfyc;
	
	/**
	 * 健康评价-异常1
	 */
	private String jkpjYc1;
	
	/**
	 * 健康评价-异常2
	 */
	private String jkpjYc2;
	
	/**
	 * 健康评价-异常3
	 */
	private String jkpjYc3;
	
	/**
	 * 健康评价-异常4
	 */
	private String jkpjYc4;
	
	/**
	 * 健康评价-异常5
	 */
	private String jkpjYc5;
	
	/**
	 * 健康评价-异常6
	 */
	private String jkpjYc6;
	
	/**
	 * 健康评价-异常7
	 */
	private String jkpjYc7;
	
	/**
	 * 健康评价-异常8
	 */
	private String jkpjYc8;
	
	/**
	 * 健康评价-异常9
	 */
	private String jkpjYc9;
	
	/**
	 * 健康评价-异常10
	 */
	private String jkpjYc10;
	
	/**
	 * 健康评价-异常11
	 */
	private String jkpjYc11;
	
	/**
	 * 健康评价-异常12
	 */
	private String jkpjYc12;
	
	/**
	 * 健康指导-状态
	 */
	private String jkzdZt;
	
	/**
	 * 健康评价-其他
	 */
	private String jkpjQt;
	
	/**
	 * 危险因素控制-状态
	 */
	private String wxyskzZt;
	
	/**
	 * 危险因素控制-减体重目标表
	 */
	private String wxyskzJtzmbb;
	
	/**
	 * 危险因素控制-建议接种疫苗
	 */
	private String wxyskzJyjzym;
	
	/**
	 * 危险因素控制-其他
	 */
	private String wxyskzQt;
	
	/**
	 * 健康指导处方
	 */
	private String jkzdCf;
	
	/**
	 * 生活方面-进餐
	 */
	private String shfmJc;
	
	/**
	 * 生活方面-梳洗
	 */
	private String shfmSx;
	
	/**
	 * 生活方面-穿衣
	 */
	private String shfmCy;
	
	/**
	 * 生活方面-如厕
	 */
	private String shfmRc;
	
	/**
	 * 生活方面-活动
	 */
	private String shfmHd;
	
	/* 治疗用药接种信息 */
	
	/**
	 * 住院治疗情况-住院史有无
	 */
	private String zyzlqkZysyw;
	
	/**
	 * 住院治疗情况-入院日期1
	 */
	private String zyzlqkRyrq1;
	
	/**
	 * 住院治疗情况-出院日期1
	 */
	private String zyzlqkCyrq1;
	
	/**
	 * 住院治疗情况-住院原因1
	 */
	private String zyzlqkZyyy1;
	
	/**
	 * 住院治疗情况-住院医疗机构名称1
	 */
	private String zyzlqkZyyljgmc1;
	
	/**
	 * 住院治疗情况-住院病案号1
	 */
	private String zyzlqkZyblh1;
	
	/**
	 * 住院治疗情况-入院日期2
	 */
	private String zyzlqkRyrq2;
	
	/**
	 * 住院治疗情况-出院日期2
	 */
	private String zyzlqkCyrq2;
	
	/**
	 * 住院治疗情况-住院原因2
	 */
	private String zyzlqkZyyy2;
	
	/**
	 * 住院治疗情况-住院医疗机构名称2
	 */
	private String zyzlqkZyyljgmc2;
	
	/**
	 * 住院治疗情况-住院病案号2
	 */
	private String zyzlqkZyblh2;
	
	/**
	 * 建床日期1
	 */
	private String zyzlqkJcrq1;
	
	/**
	 * 撤床日期1
	 */
	private String zyzlqkCcrq1;
	
	/**
	 * 建床原因1
	 */
	private String zyzlqkJcyy1;
	
	/**
	 * 建床医疗机构名称1
	 */
	private String zyzlqkJcyljgmc1;
	
	/**
	 * 建床病案号1
	 */
	private String zyzlqkJcblh1;
	
	/**
	 * 建床日期2
	 */
	private String zyzlqkJcrq2;
	
	/**
	 * 撤床日期2
	 */
	private String zyzlqkCcrq2;
	
	/**
	 * 建床原因2
	 */
	private String zyzlqkJcyy2;
	
	/**
	 * 建床医疗机构名称2
	 */
	private String zyzlqkJcyljgmc2;
	
	/**
	 * 建床病案号2
	 */
	private String zyzlqkJcblh2;
	
	/**
	 * 住院治疗情况-家族病床史有无
	 */
	private String zyzlqkJzbcsyw;
	
	/**
	 * 住院治疗情况-家族病床史JSON字符串
	 */
	private String zyzlqkJzbcsjsonzfc;
	
	/**
	 * 主要用药情况-有无
	 */
	private String zyyyqkYw;
	
	/**
	 * 药物名称1
	 */
	private String zyyyqkYwmc1;
	
	/**
	 * 用法1
	 */
	private String zyyyqkYf1;
	
	/**
	 * 其他用法1
	 */
	private String zyyyqkQtyf1;
	
	/**
	 * 用量1
	 */
	private String zyyyqkYl1;
	
	/**
	 * 剂量单位1
	 */
	private String zyyyqkJldw1;
	
	/**
	 * 用药时间1
	 */
	private String zyyyqkYysj1;
	
	/**
	 * 时间单位1
	 */
	private String zyyyqkYydw1;
	
	/**
	 * 服药依从性1
	 */
	private String zyyyqkFycyx1;
	
	/**
	 * 药物名称2
	 */
	private String zyyyqkYwmc2;
	
	/**
	 * 用法2
	 */
	private String zyyyqkYf2;
	
	/**
	 * 其他用法2
	 */
	private String zyyyqkQtyf2;
	
	/**
	 * 用量2
	 */
	private String zyyyqkYl2;
	
	/**
	 * 剂量单位2
	 */
	private String zyyyqkJldw2;
	
	/**
	 * 用药时间2
	 */
	private String zyyyqkYysj2;
	
	/**
	 * 时间单位2
	 */
	private String zyyyqkYydw2;
	
	/**
	 * 服药依从性2
	 */
	private String zyyyqkFycyx2;
	
	/**
	 * 药物名称3
	 */
	private String zyyyqkYwmc3;
	
	/**
	 * 用法3
	 */
	private String zyyyqkYf3;
	
	/**
	 * 其他用法3
	 */
	private String zyyyqkQtyf3;
	
	/**
	 * 用量3
	 */
	private String zyyyqkYl3;
	
	/**
	 * 剂量单位3
	 */
	private String zyyyqkJldw3;
	
	/**
	 * 用药时间3
	 */
	private String zyyyqkYysj3;
	
	/**
	 * 时间单位3
	 */
	private String zyyyqkYydw3;
	
	/**
	 * 服药依从性3
	 */
	private String zyyyqkFycyx3;
	
	/**
	 * 药物名称4
	 */
	private String zyyyqkYwmc4;
	
	/**
	 * 用法4
	 */
	private String zyyyqkYf4;
	
	/**
	 * 其他用法4
	 */
	private String zyyyqkQtyf4;
	
	/**
	 * 用量4
	 */
	private String zyyyqkYl4;
	
	/**
	 * 剂量单位4
	 */
	private String zyyyqkJldw4;
	
	/**
	 * 用药时间4
	 */
	private String zyyyqkYysj4;
	
	/**
	 * 时间单位4
	 */
	private String zyyyqkYydw4;
	
	/**
	 * 服药依从性4
	 */
	private String zyyyqkFycyx4;
	
	/**
	 * 药物名称5
	 */
	private String zyyyqkYwmc5;
	
	/**
	 * 用法5
	 */
	private String zyyyqkYf5;
	
	/**
	 * 其他用法5
	 */
	private String zyyyqkQtyf5;
	
	/**
	 * 用量5
	 */
	private String zyyyqkYl5;
	
	/**
	 * 剂量单位5
	 */
	private String zyyyqkJldw5;
	
	/**
	 * 用药时间5
	 */
	private String zyyyqkYysj5;
	
	/**
	 * 时间单位5
	 */
	private String zyyyqkYydw5;
	
	/**
	 * 服药依从性5
	 */
	private String zyyyqkFycyx5;
	
	/**
	 * 药物名称6
	 */
	private String zyyyqkYwmc6;
	
	/**
	 * 用法6
	 */
	private String zyyyqkYf6;
	
	/**
	 * 其他用法6
	 */
	private String zyyyqkQtyf6;
	
	/**
	 * 用量6
	 */
	private String zyyyqkYl6;
	
	/**
	 * 剂量单位6
	 */
	private String zyyyqkJldw6;
	
	/**
	 * 用药时间6
	 */
	private String zyyyqkYysj6;
	
	/**
	 * 时间单位6
	 */
	private String zyyyqkYydw6;
	
	/**
	 * 服药依从性6
	 */
	private String zyyyqkFycyx6;
	
	/**
	 * 非免疫规划预防接种史-有无
	 */
	private String fmyghyfjzsYw;
	
	/**
	 * 接种名称1
	 */
	private String fmyghyfjzsJzmc1;
	
	/**
	 * 接种日期1
	 */
	private String fmyghyfjzsJzrq1;
	
	/**
	 * 接种机构1
	 */
	private String fmyghyfjzsJzjg1;
	
	/**
	 * 接种名称2
	 */
	private String fmyghyfjzsJzmc2;
	
	/**
	 * 接种日期2
	 */
	private String fmyghyfjzsJzrq2;
	
	/**
	 * 接种机构2
	 */
	private String fmyghyfjzsJzjg2;
	
	/**
	 * 接种名称3
	 */
	private String fmyghyfjzsJzmc3;
	
	/**
	 * 接种日期3
	 */
	private String fmyghyfjzsJzrq3;
	
	/**
	 * 接种机构3
	 */
	private String fmyghyfjzsJzjg3;
	
	/* 生活方式 */
	
	/**
	 * 生活方式-体育锻炼-锻炼频率
	 */
	private String shfsTydlDlpl;
	
	/**
	 * 生活方式-体育锻炼-每次锻炼时间
	 */
	private String shfsTydlMcdlsj;
	
	/**
	 * 生活方式-体育锻炼-坚持锻炼时间
	 */
	private String shfsTydlJcdlsj;
	
	/**
	 * 生活方式-体育锻炼-锻炼方式
	 */
	private String shfsTydlDlfs;
	
	/**
	 * 生活方式-体育锻炼-锻炼方式-其他
	 */
	private String shfsTydlDlfsQt;
	
	/**
	 * 生活方式-饮食习惯
	 */
	private String shfsYsxg;
	
	/**
	 * 生活方式-吸烟情况-吸烟状况
	 */
	private String shfsXyqkXyzk;
	
	/**
	 * 生活方式-吸烟情况-日吸烟量
	 */
	private String shfsXyqkRxyl;
	
	/**
	 * 生活方式-吸烟情况-开始吸烟年龄
	 */
	private String shfsXyqkKsxynl;
	
	/**
	 * 生活方式-吸烟情况-戒烟年龄
	 */
	private String shfsXyqkJynl;
	
	/**
	 * 生活方式-饮酒情况-饮酒频率
	 */
	private String shfsYjqkYjpl;
	
	/**
	 * 生活方式-饮酒情况-日饮酒量
	 */
	private String shfsYjqkRyjl;
	
	/**
	 * 生活方式-饮酒情况-是否戒酒
	 */
	private String shfsYjqkSfjj;
	
	/**
	 * 生活方式-饮酒情况-戒酒年龄
	 */
	private String shfsYjqkJjnl;
	
	/**
	 * 生活方式-饮酒情况-开始饮酒年龄
	 */
	private String shfsYjqkKsyjnl;
	
	/**
	 * 生活方式-饮酒情况-近一年内是否曾醉酒
	 */
	private String shfsYjqkJynnsfczj;
	
	/**
	 * 生活方式-饮酒情况-饮酒种类
	 */
	private String shfsYjqkYjzl;
	
	/**
	 * 生活方式-饮酒情况-饮酒种类-其他
	 */
	private String shfsYjqkYjzlQt;
	
	/**
	 * 生活方式-职业病危害因素接触式-有无
	 */
	private String shfsZybwhysjcsYw;
	
	/**
	 * 生活方式-职业病危害因素接触式-工种
	 */
	private String shfsZybwhysjcsGz;
	
	/**
	 * 生活方式-职业病危害因素接触式-从业时间年
	 */
	private String shfsZybwhysjcsCysjn;
	
	/**
	 * 生活方式-职业病危害因素接触式-粉尘
	 */
	private String shfsZybwhysjcsFc;
	
	/**
	 * 生活方式-职业病危害因素接触式-粉尘防范措施
	 */
	private String shfsZybwhysjcsFcffcs;
	
	/**
	 * 生活方式-职业病危害因素接触式-粉尘防范措施描述
	 */
	private String shfsZybwhysjcsFcffcsms;
	
	/**
	 * 生活方式-职业病危害因素接触式-放射物质
	 */
	private String shfsZybwhysjcsFswz;
	
	/**
	 * 生活方式-职业病危害因素接触式-放射物质防范措施
	 */
	private String shfsZybwhysjcsFswzffcs;
	
	/**
	 * 生活方式-职业病危害因素接触式-放射物质防范措施描述
	 */
	private String shfsZybwhysjcsFswzffcsms;
	
	/**
	 * 生活方式-职业病危害因素接触式-物理因素
	 */
	private String shfsZybwhysjcsWlys;
	
	/**
	 * 生活方式-职业病危害因素接触式-物理因素防范措施
	 */
	private String shfsZybwhysjcsWlysffcs;
	
	/**
	 * 生活方式-职业病危害因素接触式-物理因素防范措施描述
	 */
	private String shfsZybwhysjcsWlysffcsms;
	
	/**
	 * 生活方式-职业病危害因素接触式-化学物质
	 */
	private String shfsZybwhysjcsHxwz;
	
	/**
	 * 生活方式-职业病危害因素接触式-化学物质防范措施
	 */
	private String shfsZybwhysjcsHxwzffcs;
	
	/**
	 * 生活方式-职业病危害因素接触式-化学物质防范措施描述
	 */
	private String shfsZybwhysjcsHxwzffcsms;
	
	/**
	 * 生活方式-职业病危害因素接触式-其他
	 */
	private String shfsZybwhysjcsQt;
	
	/**
	 * 生活方式-职业病危害因素接触式-其他防范措施
	 */
	private String shfsZybwhysjcsQtffcs;
	
	/**
	 * 生活方式-职业病危害因素接触式-其他防范措施描述
	 */
	private String shfsZybwhysjcsQtffcsms;
	
	/* 辅助检查信息 */
	
	/**
	 * 辅助检查-血常规-血红蛋白
	 */
	private String fzjcXcgXhdb;
	
	/**
	 * 辅助检查-血常规-白细胞
	 */
	private String fzjcXcgBxb;
	
	/**
	 * 辅助检查-血常规-血小板
	 */
	private String fzjcXcgXxb;
	
	/**
	 * 辅助检查-血常规-红细胞
	 */
	private String fzjcXcgHxb;
	
	/**
	 * 辅助检查-血常规-中性粒细胞绝对值
	 */
	private String fzjcXcgZxlxbjdz;
	
	/**
	 * 辅助检查-血常规-淋巴细胞绝对值
	 */
	private String fzjcXcgLbxbjdz;
	
	/**
	 * 辅助检查-血常规-单核细胞数
	 */
	private String fzjcXcgDhxbs;
	
	/**
	 * 辅助检查-血常规-嗜酸性粒细胞数
	 */
	private String fzjcXcgSsxlxbs;
	
	/**
	 * 辅助检查-血常规-嗜碱性粒细胞数
	 */
	private String fzjcXcgSjxlxbs;
	
	/**
	 * 辅助检查-血常规-其他
	 */
	private String fzjcXcgQt;
	
	/**
	 * 辅助检查-尿常规-尿蛋白
	 */
	private String fzjcNcgNdb;
	
	/**
	 * 辅助检查-尿常规-尿糖
	 */
	private String fzjcNcgNt;
	
	/**
	 * 辅助检查-尿常规-尿酮体
	 */
	private String fzjcNcgNtt;
	
	/**
	 * 辅助检查-尿常规-尿潜血
	 */
	private String fzjcNcgNqx;
	
	/**
	 * 辅助检查-尿常规-尿白细胞
	 */
	private String fzjcNcgNbxb;
	
	/**
	 * 辅助检查-尿常规-尿胆红素
	 */
	private String fzjcNcgNdhs;
	
	/**
	 * 辅助检查-尿常规-尿亚硝酸盐
	 */
	private String fzjcNcgNyxsy;
	
	/**
	 * 辅助检查-尿常规-其他
	 */
	private String fzjcNcgQt;
	
	/**
	 * 辅助检查-空腹血糖mmol/L
	 */
	private String fzjcKfxtmmoll;
	
	/**
	 * 辅助检查-空腹血糖mg/dL
	 */
	private String fzjcKfxtmgdl;
	
	/**
	 * 辅助检查-餐后血糖
	 */
	private String fzjcChxt;
	
	/**
	 * 辅助检查-心电图-状态
	 */
	private String fzjcXdtZt;
	
	/**
	 * 辅助检查-心电图-异常描述
	 */
	private String fzjcXdtYcms;
	
	/**
	 * 辅助检查-心电图-心电图心律
	 */
	private String fzjcXdtXdtxl;
	
	/**
	 * 辅助检查-心电图-心房率
	 */
	private String fzjcXdtXfl;
	
	/**
	 * 辅助检查-心电图-bpm心室率
	 */
	private String fzjcXdtBpmxsl;
	
	/**
	 * 辅助检查-心电图-PR间期
	 */
	private String fzjcXdtPrjq;
	
	/**
	 * 辅助检查-心电图-QRS时限
	 */
	private String fzjcXdtQrssx;
	
	/**
	 * 辅助检查-心电图-QT间期
	 */
	private String fzjcXdtQtjq;
	
	/**
	 * 辅助检查-心电图-描述
	 */
	private String fzjcXdtMs;
	
	/**
	 * 辅助检查-心电图-提示
	 */
	private String fzjcXdtTs;
	
	/**
	 * 辅助检查-心电图-心电图报告医生
	 */
	private String fzjcXdtXdtbgys;
	
	/**
	 * 辅助检查-心电图-其他心电图报告医生
	 */
	private String fzjcXdtQtxdtbgys;
	
	/**
	 * 辅助检查-心电图-电轴
	 */
	private String fzjcXdtDz;
	
	/**
	 * 辅助检查-肝吸虫抗体
	 */
	private String fzjcGxckt;
	
	/**
	 * 辅助检查-肝吸虫抗体-定量
	 */
	private String fzjcGxcktdl;
	
	/**
	 * 辅助检查-骨源性碱性磷酸酶(IU/L)
	 */
	private String fzjcGyxjxlsm;
	
	/**
	 * 辅助检查-尿微量白蛋白
	 */
	private String fzjcNwlbdb;
	
	/**
	 * 辅助检查-大便潜血
	 */
	private String fzjcDbqx;
	
	/**
	 * 辅助检查-糖化血红蛋白
	 */
	private String fzjcThxhdb;
	
	/**
	 * 辅助检查-乙型肝炎表面抗原
	 */
	private String fzjcYxgybmky;
	
	/**
	 * 辅助检查-肝功能-血清谷丙转氨酶
	 */
	private String fzjcGgnXqgbzam;
	
	/**
	 * 辅助检查-肝功能-血清谷草转氨酶
	 */
	private String fzjcGgnXqgczam;
	
	/**
	 * 辅助检查-肝功能-白蛋白
	 */
	private String fzjcGgnBdb;
	
	/**
	 * 辅助检查-肝功能-总胆红素
	 */
	private String fzjcGgnZdhs;
	
	/**
	 * 辅助检查-肝功能-结合胆红素
	 */
	private String fzjcGgnJhdhs;
	
	/**
	 * 辅助检查-肾功能-血清肌酐
	 */
	private String fzjcSgnXqjg;
	
	/**
	 * 辅助检查-肾功能-尿酸
	 */
	private String fzjcSgnNs;
	
	/**
	 * 辅助检查-肾功能-血尿素
	 */
	private String fzjcSgnXns;
	
	/**
	 * 辅助检查-肾功能-血钾浓度
	 */
	private String fzjcSgnXjnd;
	
	/**
	 * 辅助检查-肾功能-血钠浓度
	 */
	private String fzjcSgnXnnd;
	
	/**
	 * 辅助检查-血脂-总胆固醇
	 */
	private String fzjcXzZdgc;
	
	/**
	 * 辅助检查-血脂-甘油三酯
	 */
	private String fzjcXzGysz;
	
	/**
	 * 辅助检查-血脂-血清低密度脂蛋白胆固醇
	 */
	private String fzjcXzXqdmdzdbdgc;
	
	/**
	 * 辅助检查-血脂-血清高密度脂蛋白胆固醇
	 */
	private String fzjcXzXqgmdzdbdgc;
	
	/**
	 * 辅助检查-胸部X线片-状态
	 */
	private String fzjcXbxxpZt;
	
	/**
	 * 辅助检查-胸部X线片-状态异常
	 */
	private String fzjcXbxxpZtyc;
	
	/**
	 * 辅助检查-胸部X线片-检查情况描述
	 */
	private String fzjcXbxxpJcqkms;
	
	/**
	 * 辅助检查-胸部X线片-诊断意见
	 */
	private String fzjcXbxxpZdyj;
	
	/**
	 * 辅助检查-胸部X线片-X光报告医生
	 */
	private String fzjcXbxxpXgbgys;
	
	/**
	 * 辅助检查-胸部X线片-其他X光报告医生
	 */
	private String fzjcXbxxpQtxgbgys;
	
	/**
	 * 辅助检查-B超-状态
	 */
	private String fzjcBcZt;
	
	/**
	 * 辅助检查-B超-状态异常
	 */
	private String fzjcBcZtyc;
	
	/**
	 * 辅助检查-B超-检查部位
	 */
	private String fzjcBcJcbw;
	
	/**
	 * 辅助检查-B超-检查部位-其他
	 */
	private String fzjcBcJcbwQt;
	
	/**
	 * 辅助检查-B超-描述
	 */
	private String fzjcBcMs;
	
	/**
	 * 辅助检查-B超-提示
	 */
	private String fzjcBcTs;
	
	/**
	 * 辅助检查-B超-B超报告医生
	 */
	private String fzjcBcBcbgys;
	
	/**
	 * 辅助检查-B超-其他B超报告医生
	 */
	private String fzjcBcQtbcbgys;
	
	/**
	 * 辅助检查-宫颈涂片-状态
	 */
	private String fzjcGjtpZt;
	
	/**
	 * 辅助检查-宫颈涂片-状态异常
	 */
	private String fzjcGjtpZtyc;
	
	/**
	 * 辅助检查-白带常规-清洁度
	 */
	private String fzjcBdcgQjd;
	
	/**
	 * 辅助检查-白带常规-滴虫
	 */
	private String fzjcBdcgDc;
	
	/**
	 * 辅助检查-白带常规-念球菌
	 */
	private String fzjcBdcgNqj;
	
	/**
	 * 辅助检查-肿瘤三项-甲胎蛋白状态
	 */
	private String fzjcZlsxJtdbzt;
	
	/**
	 * 辅助检查-肿瘤三项-甲胎蛋白阳性值
	 */
	private String fzjcZlsxJtdbyxz;
	
	/**
	 * 辅助检查-肿瘤三项-癌胚抗原状态
	 */
	private String fzjcZlsxApkyzt;
	
	/**
	 * 辅助检查-肿瘤三项-癌胚抗原阳性值
	 */
	private String fzjcZlsxApkyyxz;
	
	/**
	 * 辅助检查-肿瘤三项-癌抗原50状态
	 */
	private String fzjcZlsxAky50zt;
	
	/**
	 * 辅助检查-肿瘤三项-癌抗原50阳性值
	 */
	private String fzjcZlsxAky50yxz;
	
	/**
	 * 辅助检查-EB病毒抗体状态
	 */
	private String fzjcEbbdktzt;
	
	/**
	 * 辅助检查-EB病毒抗体阳性值
	 */
	private String fzjcEbbdktyxz;
	
	/**
	 * 辅助检查-其他
	 */
	private String fzjcQt;
	
	/* 宣体信息 */
	
	/**
	 * 宣体-眼底状态
	 */
	private String xtYdzt;
	
	/**
	 * 宣体-眼底异常
	 */
	private String xtYdyc;
	
	/**
	 * 宣体-皮肤状态
	 */
	private String xtPfzt;
	
	/**
	 * 宣体-皮肤-其他
	 */
	private String xtPfQt;
	
	/**
	 * 宣体-巩膜状态
	 */
	private String xtGmzt;
	
	/**
	 * 宣体-巩膜-其他
	 */
	private String xtGmQt;
	
	/**
	 * 宣体-淋巴结状态
	 */
	private String xtLbjzt;
	
	/**
	 * 宣体-淋巴结-其他
	 */
	private String xtLbjQt;
	
	/**
	 * 宣体-肺-桶状胸
	 */
	private String xtFTzx;
	
	/**
	 * 宣体-肺-呼吸音
	 */
	private String xtFHxy;
	
	/**
	 * 宣体-肺-呼吸音描述
	 */
	private String xtFHxyms;
	
	/**
	 * 宣体-肺-罗音
	 */
	private String xtFLy;
	
	/**
	 * 宣体-肺-罗音-其他
	 */
	private String xtFLyQt;
	
	/**
	 * 宣体-心脏-心率-1
	 */
	private String xtXzXl1;
	
	/**
	 * 宣体-心脏-心律-2
	 */
	private String xtXzXl2;
	
	/**
	 * 宣体-心脏-杂音有无
	 */
	private String xtXzZyyw;
	
	/**
	 * 宣体-心脏-杂音描述
	 */
	private String xtXzZyms;
	
	/**
	 * 宣体-腹部-压痛有无
	 */
	private String xtFbYtyw;
	
	/**
	 * 宣体-腹部-压痛描述
	 */
	private String xtFbYtms;
	
	/**
	 * 宣体-腹部-包块有无
	 */
	private String xtFbBkyw;
	
	/**
	 * 宣体-腹部-包块描述
	 */
	private String xtFbBkms;
	
	/**
	 * 宣体-腹部-肝大有无
	 */
	private String xtFbGdyw;
	
	/**
	 * 宣体-腹部-肝大描述
	 */
	private String xtFbGdms;
	
	/**
	 * 宣体-腹部-脾大有无
	 */
	private String xtFbPdyw;
	
	/**
	 * 宣体-腹部-脾大描述
	 */
	private String xtFbPdms;
	
	/**
	 * 宣体-腹部-移动性浊音有无
	 */
	private String xtFbYdxzyyw;
	
	/**
	 * 宣体-腹部-移动性浊音描述
	 */
	private String xtFbYdxzyms;
	
	/**
	 * 宣体-下肢水肿
	 */
	private String xtXzsz;
	
	/**
	 * 宣体-足背动脉搏动
	 */
	private String xtZbdmbd;
	
	/**
	 * 宣体-肛门指诊
	 */
	private String xtGmzz;
	
	/**
	 * 宣体-肛门指诊-其他
	 */
	private String xtGmzzQt;
	
	/**
	 * 宣体-乳腺
	 */
	private String xtRx;
	
	/**
	 * 宣体-乳腺-其他
	 */
	private String xtRxQt;
	
	/**
	 * 宣体-妇科-外阴
	 */
	private String xtFkWy;
	
	/**
	 * 宣体-妇科-外阴异常
	 */
	private String xtFkWyyc;
	
	/**
	 * 宣体-妇科-阴道
	 */
	private String xtFkYd;
	
	/**
	 * 宣体-妇科-阴道异常
	 */
	private String xtFkYdyc;
	
	/**
	 * 宣体-妇科-宫颈
	 */
	private String xtFkGj;
	
	/**
	 * 宣体-妇科-宫颈异常
	 */
	private String xtFkGjyc;
	
	/**
	 * 宣体-妇科-宫体
	 */
	private String xtFkGt;
	
	/**
	 * 宣体-妇科-宫体异常
	 */
	private String xtFkGtyc;
	
	/**
	 * 宣体-妇科-附件
	 */
	private String xtFkFj;
	
	/**
	 * 宣体-妇科-附件异常
	 */
	private String xtFkFjyc;
	
	/**
	 * 宣体-其他
	 */
	private String xtQt;
	
}
