package com.health.check.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.health.check.framework.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 宣体信息
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
@Data
@TableName("health_xt_info")
public class HealthXtInfo extends BaseEntity<HealthXtInfo> {

    /**
     * 体检id
     */
    private Long healthInfoId;

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
    @TableField("xt_xz_xl_1")
    private String xtXzXl1;

    /**
     * 宣体-心脏-心律-2
     */
    @TableField("xt_xz_xl_2")
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
