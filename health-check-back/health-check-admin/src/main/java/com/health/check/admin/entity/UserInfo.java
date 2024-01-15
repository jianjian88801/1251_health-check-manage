package com.health.check.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.health.check.framework.base.MarkEntityLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * PaaS平台账户
 * </p>
 *
 * @author xiao.xl
 * @since 2022-04-23
 */
@Data
@TableName("base_user_info")
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends MarkEntityLogic<UserInfo> {

    /**
     * 姓名
     */
    private String name;
    
    /**
     * 机构
     */
    private String chain;

    /**
     * 头像
     */
    private String photo;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 电子邮箱地址
     */
    private String email;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 状态(LOCK:锁定;UNLOCK:未锁定)
     */
    private String status;
    
}
