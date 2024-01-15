package com.health.check.admin.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.health.check.framework.base.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 治疗用药接种信息
 * </p>
 *
 * @author xiao.xl
 * @since 2022-06-18
 */
@Data
@TableName("health_zlyy_info")
public class HealthZlyyInfo extends BaseEntity<HealthZlyyInfo> {
	
	/**
	 * 体检id
	 */
	private Long healthInfoId;
	
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

}
