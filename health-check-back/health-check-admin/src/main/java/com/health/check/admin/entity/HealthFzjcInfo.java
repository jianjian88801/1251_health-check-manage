package com.health.check.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.health.check.framework.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 辅助检查信息
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
@Data
@TableName("health_fzjc_info")
public class HealthFzjcInfo extends BaseEntity<HealthFzjcInfo> {

    /**
     * 体检id
     */
    private Long healthInfoId;

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
    
}
