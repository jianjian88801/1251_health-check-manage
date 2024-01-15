package com.health.check.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.health.check.framework.base.MarkEntityLogic;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 体检信息
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
@Data
@TableName("health_info")
public class HealthInfo extends MarkEntityLogic<HealthInfo> {

    /**
     * 体检日期
     */
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
     * 生活方面-穿衣
     */
    private String shfmRc;
    
    /**
     * 生活方面-活动
     */
    private String shfmHd;
    
}
