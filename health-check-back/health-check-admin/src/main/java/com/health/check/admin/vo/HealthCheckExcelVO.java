package com.health.check.admin.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.hutool.core.date.DatePattern;
import lombok.Data;

import java.util.Date;

/**
 * 健康体检Excel导出VO
 *
 * @author xiao.xl 2022/6/18 13:51
 */
@Data
public class HealthCheckExcelVO {
	
	@Excel(name = "身份证", width = 30)
	private String hzsfz;
	
	@Excel(name = "体检日期", width = 20, exportFormat = DatePattern.NORM_DATE_PATTERN)
	private Date tjrq;
	
	@Excel(name = "录入员工", width = 20)
	private String lrys;
	
	@Excel(name = "录入单位", width = 20)
	private String lrdw;
	
	@Excel(name = "录入日期", width = 20, exportFormat = DatePattern.NORM_DATE_PATTERN)
	private Date createTime;
	
	@Excel(name = "体检类型", width = 20)
	private String tjlx;
	
	@Excel(name = "检查途径", width = 20)
	private String jctj;
	
	@Excel(name = "自定义体检编号", width = 20)
	private String zdytjbh;
	
	@Excel(name = "备注", width = 20)
	private String bz;
	
	@Excel(name = "症状", width = 20)
	private String zz;
	
	@Excel(name = "其他症状", width = 20)
	private String zzQt;
	
	@Excel(name = "体温(℃)", width = 20)
	private String ybztTw;
	
	@Excel(name = "脉率(次/分钟)", width = 20)
	private String ybztMl;
	
	@Excel(name = "呼吸频率(次/分钟)", width = 20)
	private String ybztHxpl;
	
	@Excel(name = "左侧收缩压(mmHg)", width = 20)
	private String ybztXyzcssy;
	
	@Excel(name = "左侧舒张压(mmHg)", width = 20)
	private String ybztXyzcszy;
	
	@Excel(name = "右侧收缩压(mmHg)", width = 20)
	private String ybztXyycssy;
	
	@Excel(name = "右侧舒张压(mmHg)", width = 20)
	private String ybztXyycszy;
	
	@Excel(name = "身高(cm)", width = 20)
	private String ybztSg;
	
	@Excel(name = "体重(kg)", width = 20)
	private String ybztTz;
	
	@Excel(name = "腰围(cm)", width = 20)
	private String ybztYw;
	
	@Excel(name = "臀围(cm)", width = 20)
	private String ybztTunwei;
	
	@Excel(name = "老年人健康状态自我评估", width = 20)
	private String ybztLnrjkztzwpg;
	
	@Excel(name = "老年人生活自理能力自我评估", width = 20)
	private String ybztLnrshzlnlzwpg;
	
	@Excel(name = "老年人认知功能", width = 20)
	private String ybztLnrrzgn;
	
	@Excel(name = "简易智力状态检查总分", width = 20)
	private String ybztJyzlztjcZf;
	
	@Excel(name = "老年人情感状态", width = 20)
	private String ybztLnrqgzt;
	
	@Excel(name = "老年人抑郁评分", width = 20)
	private String ybztLnryypfjcZf;
	
	@Excel(name = "锻炼频率", width = 20)
	private String shfsTydlDlpl;
	
	@Excel(name = "每次锻炼时间(分钟)", width = 20)
	private String shfsTydlMcdlsj;
	
	@Excel(name = "坚持锻炼时间(年)", width = 20)
	private String shfsTydlJcdlsj;
	
	@Excel(name = "锻炼方式", width = 20)
	private String shfsTydlDlfs;
	
	@Excel(name = "饮食习惯", width = 20)
	private String shfsYsxg;
	
	@Excel(name = "吸烟状况", width = 20)
	private String shfsXyqkXyzk;
	
	@Excel(name = "日吸烟量(支)", width = 20)
	private String shfsXyqkRxyl;
	
	@Excel(name = "开始吸烟年龄(岁)", width = 20)
	private String shfsXyqkKsxynl;
	
	@Excel(name = "戒烟年龄(岁)", width = 20)
	private String shfsXyqkJynl;
	
	@Excel(name = "饮酒频率", width = 20)
	private String shfsYjqkYjpl;
	
	@Excel(name = "日饮酒量(两)", width = 20)
	private String shfsYjqkRyjl;
	
	@Excel(name = "是否戒酒", width = 20)
	private String shfsYjqkSfjj;
	
	@Excel(name = "戒酒年龄(岁)", width = 20)
	private String shfsYjqkJjnl;
	
	@Excel(name = "开始饮酒年龄(岁)", width = 20)
	private String shfsYjqkKsyjnl;
	
	@Excel(name = "近一年内是否曾醉酒", width = 20)
	private String shfsYjqkJynnsfczj;
	
	@Excel(name = "饮酒种类", width = 20)
	private String shfsYjqkYjzl;
	
	@Excel(name = "其他饮酒种类", width = 20)
	private String shfsYjqkYjzlQt;
	
	@Excel(name = "职业病危害因素接触史", width = 20)
	private String shfsZybwhysjcsYw;
	
	@Excel(name = "工种", width = 20)
	private String shfsZybwhysjcsGz;
	
	@Excel(name = "从业时间(年)", width = 20)
	private String shfsZybwhysjcsCysjn;
	
	@Excel(name = "粉尘", width = 20)
	private String shfsZybwhysjcsFc;
	
	@Excel(name = "防护措施(粉尘)", width = 20)
	private String shfsZybwhysjcsFcffcs;
	
	@Excel(name = "防护描述(粉尘)", width = 20)
	private String shfsZybwhysjcsFcffcsms;
	
	@Excel(name = "放射物质", width = 20)
	private String shfsZybwhysjcsFswz;
	
	@Excel(name = "防护措施(放射物质)", width = 20)
	private String shfsZybwhysjcsFswzffcs;
	
	@Excel(name = "防护描述(放射物质)", width = 20)
	private String shfsZybwhysjcsFswzffcsms;
	
	@Excel(name = "物理因素", width = 20)
	private String shfsZybwhysjcsWlys;
	
	@Excel(name = "防护措施(物理因素)", width = 20)
	private String shfsZybwhysjcsWlysffcs;
	
	@Excel(name = "防护描述(物理因素)", width = 20)
	private String shfsZybwhysjcsWlysffcsms;
	
	@Excel(name = "化学物质", width = 20)
	private String shfsZybwhysjcsHxwz;
	
	@Excel(name = "防护措施(化学物质)", width = 20)
	private String shfsZybwhysjcsHxwzffcs;
	
	@Excel(name = "防护描述(化学物质)", width = 20)
	private String shfsZybwhysjcsHxwzffcsms;
	
	@Excel(name = "其他毒物", width = 20)
	private String shfsZybwhysjcsQt;
	
	@Excel(name = "防护措施(其他毒物)", width = 20)
	private String shfsZybwhysjcsQtffcs;
	
	@Excel(name = "防护描述(其他毒物)", width = 20)
	private String shfsZybwhysjcsQtffcsms;
	
	@Excel(name = "口唇", width = 20)
	private String zqgnKqKc;
	
	@Excel(name = "齿列", width = 20)
	private String zqgnKqClZt;
	
	@Excel(name = "左上(缺齿)", width = 20)
	private String zqgnKqQcZs;
	
	@Excel(name = "左下(缺齿)", width = 20)
	private String zqgnKqQcZx;
	
	@Excel(name = "右上(缺齿)", width = 20)
	private String zqgnKqQcYs;
	
	@Excel(name = "右下(缺齿)", width = 20)
	private String zqgnKqQcYx;
	
	@Excel(name = "左上(龋齿)", width = 20)
	private String zqgnKqQuchiZs;
	
	@Excel(name = "左下(龋齿)", width = 20)
	private String zqgnKqQuchiZx;
	
	@Excel(name = "右上(龋齿)", width = 20)
	private String zqgnKqQuchiYs;
	
	@Excel(name = "右下(龋齿)", width = 20)
	private String zqgnKqQuchiYx;
	
	@Excel(name = "左上(义齿)", width = 20)
	private String zqgnKqYcJyZs;
	
	@Excel(name = "左下(义齿)", width = 20)
	private String zqgnKqYcJyZx;
	
	@Excel(name = "右上(义齿)", width = 20)
	private String zqgnKqYcJyYs;
	
	@Excel(name = "右下(义齿)", width = 20)
	private String zqgnKqYcJyYx;
	
	@Excel(name = "咽部", width = 20)
	private String zqgnKqYb;
	
	@Excel(name = "左眼视力", width = 20)
	private String zqgnSlZy;
	
	@Excel(name = "右眼视力", width = 20)
	private String zqgnSlYy;
	
	@Excel(name = "矫正左眼视力", width = 20)
	private String zqgnSlJzslZy;
	
	@Excel(name = "矫正右眼视力", width = 20)
	private String zqgnSlJzslYy;
	
	@Excel(name = "其他视力描述", width = 20)
	private String zqgnSlQtslms;
	
	@Excel(name = "听力", width = 20)
	private String zqgnTlZt;
	
	@Excel(name = "运动功能", width = 20)
	private String zqgnYdgnzt;
	
	@Excel(name = "眼底", width = 20)
	private String xtYdzt;
	
	@Excel(name = "眼底描述", width = 20)
	private String xtYdyc;
	
	@Excel(name = "皮肤", width = 20)
	private String xtPfzt;
	
	@Excel(name = "皮肤其他", width = 20)
	private String xtPfQt;
	
	@Excel(name = "巩膜", width = 20)
	private String xtGmzt;
	
	@Excel(name = "巩膜其他", width = 20)
	private String xtGmQt;
	
	@Excel(name = "淋巴结", width = 20)
	private String xtLbjzt;
	
	@Excel(name = "淋巴结其他", width = 20)
	private String xtLbjQt;
	
	@Excel(name = "桶状胸", width = 20)
	private String xtFTzx;
	
	@Excel(name = "呼吸音", width = 20)
	private String xtFHxy;
	
	@Excel(name = "呼吸音异常描述", width = 20)
	private String xtFHxyms;
	
	@Excel(name = "罗音", width = 20)
	private String xtFLy;
	
	@Excel(name = "其他罗音描述", width = 20)
	private String xtFLyQt;
	
	@Excel(name = "心率(次/分)", width = 20)
	private String xtXzXl1;
	
	@Excel(name = "心律", width = 20)
	private String xtXzXl2;
	
	@Excel(name = "杂音", width = 20)
	private String xtXzZyyw;
	
	@Excel(name = "杂音描述", width = 20)
	private String xtXzZyms;
	
	@Excel(name = "压痛", width = 20)
	private String xtFbYtyw;
	
	@Excel(name = "压痛描述", width = 20)
	private String xtFbYtms;
	
	@Excel(name = "包块", width = 20)
	private String xtFbBkyw;
	
	@Excel(name = "包块描述", width = 20)
	private String xtFbBkms;
	
	@Excel(name = "肝大", width = 20)
	private String xtFbGdyw;
	
	@Excel(name = "肝大描述", width = 20)
	private String xtFbGdms;
	
	@Excel(name = "脾大", width = 20)
	private String xtFbPdyw;
	
	@Excel(name = "脾大描述", width = 20)
	private String xtFbPdms;
	
	@Excel(name = "移动性浊音", width = 20)
	private String xtFbYdxzyyw;
	
	@Excel(name = "移动性浊音描述", width = 20)
	private String xtFbYdxzyms;
	
	@Excel(name = "下肢水肿", width = 20)
	private String xtXzsz;
	
	@Excel(name = "足背动脉搏动", width = 20)
	private String xtZbdmbd;
	
	@Excel(name = "肛门指诊", width = 20)
	private String xtGmzz;
	
	@Excel(name = "肛门指诊其他描述", width = 20)
	private String xtGmzzQt;
	
	@Excel(name = "乳腺", width = 20)
	private String xtRx;
	
	@Excel(name = "乳腺其他描述", width = 20)
	private String xtRxQt;
	
	@Excel(name = "外阴", width = 20)
	private String xtFkWy;
	
	@Excel(name = "外阴异常描述", width = 20)
	private String xtFkWyyc;
	
	@Excel(name = "阴道", width = 20)
	private String xtFkYd;
	
	@Excel(name = "阴道异常描述", width = 20)
	private String xtFkYdyc;
	
	@Excel(name = "宫颈", width = 20)
	private String xtFkGj;
	
	@Excel(name = "宫颈异常描述", width = 20)
	private String xtFkGjyc;
	
	@Excel(name = "宫体", width = 20)
	private String xtFkGt;
	
	@Excel(name = "宫体异常描述", width = 20)
	private String xtFkGtyc;
	
	@Excel(name = "附件", width = 20)
	private String xtFkFj;
	
	@Excel(name = "附件异常描述", width = 20)
	private String xtFkFjyc;
	
	@Excel(name = "其他查体", width = 20)
	private String xtQt;
	
	@Excel(name = "血红蛋白(g/L)", width = 20)
	private String fzjcXcgXhdb;
	
	@Excel(name = "白细胞(10^9/L)", width = 20)
	private String fzjcXcgBxb;
	
	@Excel(name = "血小板(10^9/L)", width = 20)
	private String fzjcXcgXxb;
	
	@Excel(name = "红细胞(10^9/L)", width = 20)
	private String fzjcXcgHxb;
	
	@Excel(name = "中性粒细胞绝对值(10^9/L)", width = 20)
	private String fzjcXcgZxlxbjdz;
	
	@Excel(name = "淋巴细胞绝对值（LY#）(10^9/L)", width = 20)
	private String fzjcXcgLbxbjdz;
	
	@Excel(name = "单核细胞数(10^9/L)", width = 20)
	private String fzjcXcgDhxbs;
	
	@Excel(name = "嗜酸性粒细胞数(10^9/L)", width = 20)
	private String fzjcXcgSsxlxbs;
	
	@Excel(name = "嗜碱性粒细胞数(10^9/L)", width = 20)
	private String fzjcXcgSjxlxbs;
	
	@Excel(name = "血常规其他", width = 20)
	private String fzjcXcgQt;
	
	@Excel(name = "尿蛋白", width = 20)
	private String fzjcNcgNdb;
	
	@Excel(name = "尿糖", width = 20)
	private String fzjcNcgNt;
	
	@Excel(name = "尿酮体", width = 20)
	private String fzjcNcgNtt;
	
	@Excel(name = "尿潜血", width = 20)
	private String fzjcNcgNqx;
	
	@Excel(name = "尿白细胞", width = 20)
	private String fzjcNcgNbxb;
	
	@Excel(name = "尿胆红素", width = 20)
	private String fzjcNcgNdhs;
	
	@Excel(name = "尿亚硝酸盐", width = 20)
	private String fzjcNcgNyxsy;
	
	@Excel(name = "尿常规其他", width = 20)
	private String fzjcNcgQt;
	
	@Excel(name = "空腹血糖(mmol/L)", width = 20)
	private String fzjcKfxtmmoll;
	
	@Excel(name = "餐后血糖(mmol/L)", width = 20)
	private String fzjcChxt;
	
	@Excel(name = "心电图", width = 20)
	private String fzjcXdtZt;
	
	@Excel(name = "心电图异常描述", width = 20)
	private String fzjcXdtYcms;
	
	@Excel(name = "心电图心律", width = 20)
	private String fzjcXdtXdtxl;
	
	@Excel(name = "心房率", width = 20)
	private String fzjcXdtXfl;
	
	@Excel(name = "心室率", width = 20)
	private String fzjcXdtBpmxsl;
	
	@Excel(name = "电轴", width = 20)
	private String fzjcXdtDz;
	
	@Excel(name = "P-R间期", width = 20)
	private String fzjcXdtPRjq;
	
	@Excel(name = "QRS时限", width = 20)
	private String fzjcXdtQRSsx;
	
	@Excel(name = "Q-T间期", width = 20)
	private String fzjcXdtQTjq;
	
	@Excel(name = "心电图描述", width = 20)
	private String fzjcXdtMs;
	
	@Excel(name = "心电图提示", width = 20)
	private String fzjcXdtTs;
	
	@Excel(name = "心电图报告医生", width = 20)
	private String fzjcXdtXdtbgys;
	
	@Excel(name = "其他心电图报告医生", width = 20)
	private String fzjcXdtQtxdtbgys;
	
	@Excel(name = "尿微量白蛋白", width = 20)
	private String fzjcNwlbdb;
	
	@Excel(name = "大便潜血", width = 20)
	private String fzjcDbqx;
	
	@Excel(name = "糖化血红蛋白(%)", width = 20)
	private String fzjcThxhdb;
	
	@Excel(name = "乙型肝炎表面抗原", width = 20)
	private String fzjcYxgybmky;
	
	@Excel(name = "血清谷丙转氨酶(U/L)", width = 20)
	private String fzjcGgnXqgbzam;
	
	@Excel(name = "血清谷草转氨酶(U/L)", width = 20)
	private String fzjcGgnXqgczam;
	
	@Excel(name = "白蛋白(g/L)", width = 20)
	private String fzjcGgnBdb;
	
	@Excel(name = "总胆红素(μmol/L)", width = 20)
	private String fzjcGgnZdhs;
	
	@Excel(name = "结合胆红素(μmol/L)", width = 20)
	private String fzjcGgnJhdhs;
	
	@Excel(name = "血清肌酐(μmol/L)", width = 20)
	private String fzjcSgnXqjg;
	
	@Excel(name = "血尿素(mmol/L)", width = 20)
	private String fzjcSgnNs;
	
	@Excel(name = "尿酸(mmol/L)", width = 20)
	private String fzjcSgnXns;
	
	@Excel(name = "血钾浓度(mmol/L)", width = 20)
	private String fzjcSgnXjnd;
	
	@Excel(name = "血钠浓度(mmol/L)", width = 20)
	private String fzjcSgnXnnd;
	
	@Excel(name = "总胆固醇(mmol/L)", width = 20)
	private String fzjcXzZdgc;
	
	@Excel(name = "甘油三酯(mmol/L)", width = 20)
	private String fzjcXzGysz;
	
	@Excel(name = "血清低密度脂蛋白胆固醇(mmol/L)", width = 20)
	private String fzjcXzXqdmdzdbdgc;
	
	@Excel(name = "血清高密度脂蛋白胆固醇(mmol/L)", width = 20)
	private String fzjcXzXqgmdzdbdgc;
	
	@Excel(name = "胸部X线片", width = 20)
	private String fzjcXbXxpZt;
	
	@Excel(name = "胸部X线片异常描述", width = 20)
	private String fzjcXbXxpZtyc;
	
	@Excel(name = "胸部X线片检查情况", width = 20)
	private String fzjcXbXxpJcqkms;
	
	@Excel(name = "胸部X线片诊断意见", width = 20)
	private String fzjcXbXxpZdyj;
	
	@Excel(name = "X光报告医生", width = 20)
	private String fzjcXbXxpXgbgys;
	
	@Excel(name = "其他X光报告医生", width = 20)
	private String fzjcXbXxpQtXgbgys;
	
	@Excel(name = "B超", width = 20)
	private String fzjcBcZt;
	
	@Excel(name = "B超异常描述", width = 20)
	private String fzjcBcZtyc;
	
	@Excel(name = "B超检查部位", width = 20)
	private String fzjcBcJcbw;
	
	@Excel(name = "B超检查部位其他", width = 20)
	private String fzjcBcJcbwQt;
	
	@Excel(name = "B超描述", width = 20)
	private String fzjcBcMs;
	
	@Excel(name = "B超提示", width = 20)
	private String fzjcBcTs;
	
	@Excel(name = "B超报告医生", width = 20)
	private String fzjcBcBcbgys;
	
	@Excel(name = "其他B超报告医生", width = 20)
	private String fzjcBcQtBcbgys;
	
	@Excel(name = "宫颈涂片", width = 20)
	private String fzjcGjtpZt;
	
	@Excel(name = "宫颈涂片异常描述", width = 20)
	private String fzjcGjtpZtyc;
	
	@Excel(name = "清洁度", width = 20)
	private String fzjcBdcgQjd;
	
	@Excel(name = "滴虫", width = 20)
	private String fzjcBdcgDc;
	
	@Excel(name = "念球菌", width = 20)
	private String fzjcBdcgNqj;
	
	@Excel(name = "甲胎蛋白", width = 20)
	private String fzjcZlsxJtdbzt;
	
	@Excel(name = "甲胎蛋白-定量(ng/ml)", width = 20)
	private String fzjcZlsxJtdbyxz;
	
	@Excel(name = "癌胚抗原", width = 20)
	private String fzjcZlsxApkyzt;
	
	@Excel(name = "癌胚抗原-定量(ng/ml)", width = 20)
	private String fzjcZlsxApkyyxz;
	
	@Excel(name = "癌抗原50", width = 20)
	private String fzjcZlsxAky50zt;
	
	@Excel(name = "癌抗原50-定量(u/ml)", width = 20)
	private String fzjcZlsxAky50yxz;
	
	@Excel(name = "EB病毒抗体", width = 20)
	private String fzjcEBbdktzt;
	
	@Excel(name = "EB病毒抗体-定量", width = 20)
	private String fzjcEBbdktyxz;
	
	@Excel(name = "肝吸虫抗体", width = 20)
	private String fzjcGxckt;
	
	@Excel(name = "肝吸虫抗体-定量", width = 20)
	private String fzjcGxcktdl;
	
	@Excel(name = "骨源性碱性磷酸酶(IU/L)", width = 20)
	private String fzjcGyxjxlsm;
	
	@Excel(name = "其他辅助检查", width = 20)
	private String fzjcQt;
	
	@Excel(name = "脑血管疾病", width = 20)
	private String xczyjkwtNxgjb;
	
	@Excel(name = "其他脑血管疾病", width = 20)
	private String xczyjkwtNxgjbQt;
	
	@Excel(name = "肾脏疾病", width = 20)
	private String xczyjkwtSzjb;
	
	@Excel(name = "其他肾脏疾病", width = 20)
	private String xczyjkwtSzjbQt;
	
	@Excel(name = "心脏疾病", width = 20)
	private String xczyjkwtXzjb;
	
	@Excel(name = "其他心脏疾病", width = 20)
	private String xczyjkwtXzjbQt;
	
	@Excel(name = "血管疾病", width = 20)
	private String xczyjkwtXgjb;
	
	@Excel(name = "其他血管疾病", width = 20)
	private String xczyjkwtXgjbQt;
	
	@Excel(name = "眼部疾病", width = 20)
	private String xczyjkwtYbjb;
	
	@Excel(name = "其他眼部疾病", width = 20)
	private String xczyjkwtYbjbQt;
	
	@Excel(name = "神经系统疾病", width = 20)
	private String xczyjkwtSjxtjb;
	
	@Excel(name = "神经系统疾病描述", width = 20)
	private String xczyjkwtSjxtjbQt;
	
	@Excel(name = "其他系统疾病", width = 20)
	private String xczyjkwtQtxtjb;
	
	@Excel(name = "其他系统疾病描述", width = 20)
	private String xczyjkwtQtxtjbQt;
	
	@Excel(name = "入院日期1", width = 20)
	private String zyzlqkRyrq1;
	
	@Excel(name = "出院日期1", width = 20)
	private String zyzlqkCyrq1;
	
	@Excel(name = "住院原因1", width = 20)
	private String zyzlqkZyyy1;
	
	@Excel(name = "住院医疗机构名称1", width = 20)
	private String zyzlqkZyyljgmc1;
	
	@Excel(name = "住院病案号1", width = 20)
	private String zyzlqkZyblh1;
	
	@Excel(name = "入院日期2", width = 20)
	private String zyzlqkRyrq2;
	
	@Excel(name = "出院日期2", width = 20)
	private String zyzlqkCyrq2;
	
	@Excel(name = "住院原因2", width = 20)
	private String zyzlqkZyyy2;
	
	@Excel(name = "住院医疗机构名称2", width = 20)
	private String zyzlqkZyyljgmc2;
	
	@Excel(name = "住院病案号2", width = 20)
	private String zyzlqkZyblh2;
	
	@Excel(name = "建床日期1", width = 20)
	private String zyzlqkJcrq1;
	
	@Excel(name = "撤床日期1", width = 20)
	private String zyzlqkCcrq1;
	
	@Excel(name = "建床原因1", width = 20)
	private String zyzlqkJcyy1;
	
	@Excel(name = "建床医疗机构名称1", width = 20)
	private String zyzlqkJcyljgmc1;
	
	@Excel(name = "建床病案号1", width = 20)
	private String zyzlqkJcblh1;
	
	@Excel(name = "建床日期2", width = 20)
	private String zyzlqkJcrq2;
	
	@Excel(name = "撤床日期2", width = 20)
	private String zyzlqkCcrq2;
	
	@Excel(name = "建床原因2", width = 20)
	private String zyzlqkJcyy2;
	
	@Excel(name = "建床医疗机构名称2", width = 20)
	private String zyzlqkJcyljgmc2;
	
	@Excel(name = "建床病案号2", width = 20)
	private String zyzlqkJcblh2;
	
	@Excel(name = "药物名称1", width = 20)
	private String zyyyqkYwmc1;
	
	@Excel(name = "用法1", width = 20)
	private String zyyyqkYf1;
	
	@Excel(name = "其他用法1", width = 20)
	private String zyyyqkQtyf1;
	
	@Excel(name = "用量1", width = 20)
	private String zyyyqkYl1;
	
	@Excel(name = "剂量单位1", width = 20)
	private String zyyyqkJldw1;
	
	@Excel(name = "用药时间1", width = 20)
	private String zyyyqkYysj1;
	
	@Excel(name = "时间单位1", width = 20)
	private String zyyyqkYydw1;
	
	@Excel(name = "服药依从性1", width = 20)
	private String zyyyqkFycyx1;
	
	@Excel(name = "药物名称2", width = 20)
	private String zyyyqkYwmc2;
	
	@Excel(name = "用法2", width = 20)
	private String zyyyqkYf2;
	
	@Excel(name = "其他用法2", width = 20)
	private String zyyyqkQtyf2;
	
	@Excel(name = "用量2", width = 20)
	private String zyyyqkYl2;
	
	@Excel(name = "剂量单位2", width = 20)
	private String zyyyqkJldw2;
	
	@Excel(name = "用药时间2", width = 20)
	private String zyyyqkYysj2;
	
	@Excel(name = "时间单位2", width = 20)
	private String zyyyqkYydw2;
	
	@Excel(name = "服药依从性2", width = 20)
	private String zyyyqkFycyx2;
	
	@Excel(name = "药物名称3", width = 20)
	private String zyyyqkYwmc3;
	
	@Excel(name = "用法3", width = 20)
	private String zyyyqkYf3;
	
	@Excel(name = "其他用法3", width = 20)
	private String zyyyqkQtyf3;
	
	@Excel(name = "用量3", width = 20)
	private String zyyyqkYl3;
	
	@Excel(name = "剂量单位3", width = 20)
	private String zyyyqkJldw3;
	
	@Excel(name = "用药时间3", width = 20)
	private String zyyyqkYysj3;
	
	@Excel(name = "时间单位3", width = 20)
	private String zyyyqkYydw3;
	
	@Excel(name = "服药依从性3", width = 20)
	private String zyyyqkFycyx3;
	
	@Excel(name = "药物名称4", width = 20)
	private String zyyyqkYwmc4;
	
	@Excel(name = "用法4", width = 20)
	private String zyyyqkYf4;
	
	@Excel(name = "其他用法4", width = 20)
	private String zyyyqkQtyf4;
	
	@Excel(name = "用量4", width = 20)
	private String zyyyqkYl4;
	
	@Excel(name = "剂量单位4", width = 20)
	private String zyyyqkJldw4;
	
	@Excel(name = "用药时间4", width = 20)
	private String zyyyqkYysj4;
	
	@Excel(name = "时间单位4", width = 20)
	private String zyyyqkYydw4;
	
	@Excel(name = "服药依从性4", width = 20)
	private String zyyyqkFycyx4;
	
	@Excel(name = "药物名称5", width = 20)
	private String zyyyqkYwmc5;
	
	@Excel(name = "用法5", width = 20)
	private String zyyyqkYf5;
	
	@Excel(name = "其他用法5", width = 20)
	private String zyyyqkQtyf5;
	
	@Excel(name = "用量5", width = 20)
	private String zyyyqkYl5;
	
	@Excel(name = "剂量单位5", width = 20)
	private String zyyyqkJldw5;
	
	@Excel(name = "用药时间5", width = 20)
	private String zyyyqkYysj5;
	
	@Excel(name = "时间单位5", width = 20)
	private String zyyyqkYydw5;
	
	@Excel(name = "服药依从性5", width = 20)
	private String zyyyqkFycyx5;
	
	@Excel(name = "药物名称6", width = 20)
	private String zyyyqkYwmc6;
	
	@Excel(name = "用法6", width = 20)
	private String zyyyqkYf6;
	
	@Excel(name = "其他用法6", width = 20)
	private String zyyyqkQtyf6;
	
	@Excel(name = "用量6", width = 20)
	private String zyyyqkYl6;
	
	@Excel(name = "剂量单位6", width = 20)
	private String zyyyqkJldw6;
	
	@Excel(name = "用药时间6", width = 20)
	private String zyyyqkYysj6;
	
	@Excel(name = "时间单位6", width = 20)
	private String zyyyqkYydw6;
	
	@Excel(name = "服药依从性6", width = 20)
	private String zyyyqkFycyx6;
	
	@Excel(name = "接种名称1", width = 20)
	private String fmyghyfjzsJzmc1;
	
	@Excel(name = "接种日期1", width = 20)
	private String fmyghyfjzsJzrq1;
	
	@Excel(name = "接种机构1", width = 20)
	private String fmyghyfjzsJzjg1;
	
	@Excel(name = "接种名称2", width = 20)
	private String fmyghyfjzsJzmc2;
	
	@Excel(name = "接种日期2", width = 20)
	private String fmyghyfjzsJzrq2;
	
	@Excel(name = "接种机构2", width = 20)
	private String fmyghyfjzsJzjg2;
	
	@Excel(name = "接种名称3", width = 20)
	private String fmyghyfjzsJzmc3;
	
	@Excel(name = "接种日期3", width = 20)
	private String fmyghyfjzsJzrq3;
	
	@Excel(name = "接种机构3", width = 20)
	private String fmyghyfjzsJzjg3;
	
	@Excel(name = "健康评价", width = 20)
	private String jkpjSfyc;
	
	@Excel(name = "异常1", width = 20)
	private String jkpjYc1;
	
	@Excel(name = "异常2", width = 20)
	private String jkpjYc2;
	
	@Excel(name = "异常3", width = 20)
	private String jkpjYc3;
	
	@Excel(name = "异常4", width = 20)
	private String jkpjYc4;
	
	@Excel(name = "异常5", width = 20)
	private String jkpjYc5;
	
	@Excel(name = "异常6", width = 20)
	private String jkpjYc6;
	
	@Excel(name = "异常7", width = 20)
	private String jkpjYc7;
	
	@Excel(name = "异常8", width = 20)
	private String jkpjYc8;
	
	@Excel(name = "异常9", width = 20)
	private String jkpjYc9;
	
	@Excel(name = "异常10", width = 20)
	private String jkpjYc10;
	
	@Excel(name = "异常11", width = 20)
	private String jkpjYc11;
	
	@Excel(name = "异常12", width = 20)
	private String jkpjYc12;
	
	@Excel(name = "健康指导", width = 20)
	private String jkzdZt;
	
	@Excel(name = "其他健康指导", width = 20)
	private String jkpjQt;
	
	@Excel(name = "危险因素控制", width = 20)
	private String wxyskzZt;
	
	@Excel(name = "目标体重(kg)", width = 20)
	private String wxyskzJtzmbb;
	
	@Excel(name = "建议接种疫苗", width = 20)
	private String wxyskzJyjzym;
	
	@Excel(name = "其他控制", width = 20)
	private String wxyskzQt;
	
	@Excel(name = "健康指导处方", width = 20)
	private String jkzdCf;
	
	@Excel(name = "进餐", width = 20)
	private String shfmJc;
	
	@Excel(name = "梳洗", width = 20)
	private String shfmSx;
	
	@Excel(name = "穿衣", width = 20)
	private String shfmCy;
	
	@Excel(name = "如厕", width = 20)
	private String shfmRc;
	
	@Excel(name = "活动", width = 20)
	private String shfmHd;
}
