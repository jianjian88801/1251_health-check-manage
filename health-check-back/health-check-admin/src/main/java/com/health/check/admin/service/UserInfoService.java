package com.health.check.admin.service;

import com.health.check.admin.entity.UserInfo;
import com.health.check.framework.base.BaseService;

/**
 * <p>
 * PaaS平台账户 服务类
 * </p>
 *
 * @author xiao.xl
 * @since 2022-04-23
 */
public interface UserInfoService extends BaseService<UserInfo> {
	
	/**
	 * 通过手机号码查询用户信息
	 *
	 * @param phone 手机号码
	 * @return 用户信息
	 * @author xiao.xl 2022/4/23 20:31
	 */
	UserInfo getByPhone(String phone);
	
}