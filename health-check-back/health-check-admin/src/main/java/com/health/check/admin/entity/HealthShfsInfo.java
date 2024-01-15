package com.health.check.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.health.check.framework.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 生活方式信息
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
@Data
@TableName("health_shfs_info")
public class HealthShfsInfo extends BaseEntity<HealthShfsInfo> {

    /**
     * 体检id
     */
    private Long healthInfoId;

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
}
