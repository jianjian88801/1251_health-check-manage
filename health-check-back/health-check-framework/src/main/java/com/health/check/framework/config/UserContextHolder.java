package com.health.check.framework.config;

import com.health.check.framework.base.UserJwt;

/**
 * 用户本地缓存
 *
 * @author xiao.xl 2022/3/9 13:46
 */
public class UserContextHolder {

	protected static ThreadLocal<UserJwt> userContext = new ThreadLocal();

	/**
	 * 获取用户名称
	 *
	 * @return 用户名称
	 * @author xiao.xl 2022/3/9 13:49
	 */
	public static UserJwt currentUser() {
		return userContext.get();
	}

	/**
	 * 设置用户信息
	 *
	 * @param user 用户信息
	 * @author xiao.xl 2022/3/9 13:50
	 */
	public static void setUser(UserJwt user) {
		userContext.set(user);
	}

	/**
	 * 清除缓存
	 *
	 * @author xiao.xl 2022/3/9 13:50
	 */
	public static void shutdown() {
		userContext.remove();
	}

	public static Long getUserId(){
		UserJwt userJwt = currentUser();
		return userJwt == null ? null : userJwt.getUserId();
	}

}
