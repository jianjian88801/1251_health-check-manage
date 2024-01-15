package com.health.check.admin.facade;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.health.check.admin.dto.UserLoginDTO;
import com.health.check.admin.entity.UserInfo;
import com.health.check.admin.service.UserInfoService;
import com.health.check.admin.vo.UserLoginVO;
import com.health.check.admin.vo.UserVO;
import com.health.check.framework.base.UserJwt;
import com.health.check.framework.constant.CommonConstant;
import com.health.check.framework.enums.CacheScopeEnum;
import com.health.check.framework.enums.EnableStatusEnum;
import com.health.check.framework.exception.AuthException;
import com.health.check.framework.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;

/**
 * 用户管理聚合
 *
 * @author xiao.xl 2022/6/17 23:02
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserInfoFacade {
	
	/**
	 * token过期时间
	 */
	@Value("${bmp.auth.tokenExpirationTime:1440}")
	private Integer tokenExpirationTime;
	
	private final UserInfoService userInfoService;
	private final CacheUtils cacheUtils;
	
	/**
	 * 用户登录
	 *
	 * @param userLogin 登录参数
	 * @return 响应结果
	 * @author xiao.xl 2022/6/17 23:34
	 */
	public UserLoginVO login(UserLoginDTO userLogin) {
		UserLoginVO result = new UserLoginVO();
		String userName = userLogin.getUserName();
		UserInfo userInfo = userInfoService.getByPhone(userName);
		if (userInfo == null) {
			throw AuthException.authTokenError("账号不存在，请先注册!");
		}
		if (EnableStatusEnum.DISABLE.match(userInfo.getStatus())) {
			throw AuthException.authTokenError("账号已停用");
		}
		if (!StringUtils.equals(userLogin.getPassword(), userInfo.getPassword())) {
			throw AuthException.authTokenError("密码错误");
		}
		// 持久化的redis
		Date expire = DateUtil.offset(new Date(), DateField.MINUTE, tokenExpirationTime);
		UserJwt userJwt = new UserJwt(userInfo.getPhone(), userInfo.getName(), userInfo.getEmail(), userInfo.getId(), expire);
		String token = JwtUtils.generateToken(userJwt, expire);
		String authTokenKey = CommonConstant.AUTHORIZATION_TOKEN_PREFIX + userName;
		cacheUtils.set(authTokenKey, token, CacheScopeEnum.GLOBAL, Duration.ofMinutes(tokenExpirationTime));
		result.setToken(token);
		result.setUserInfo(TransformUtils.transform(userInfo, UserVO.class));
		result.setExpiration(expire);
		return result;
	}
	
	/**
	 * 退出登录
	 *
	 * @param token 用户token信息
	 * @return true: 成功
	 * @author xiao.xl 2022/6/20 16:00
	 */
	public boolean logout(String token) {
		if (token != null) {
			// 获取账户信息
			UserJwt userJwt = JwtUtils.getUserInfoToToken(token);
			// 删除token
			String username = userJwt.getPhone();
			cacheUtils.remove(CommonConstant.AUTHORIZATION_TOKEN_PREFIX + username, CacheScopeEnum.GLOBAL);
			return true;
		}
		return false;
	}
	
}
