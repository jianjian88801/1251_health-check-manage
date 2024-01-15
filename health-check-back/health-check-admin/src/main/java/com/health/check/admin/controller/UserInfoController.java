package com.health.check.admin.controller;

import com.health.check.admin.dto.UserLoginDTO;
import com.health.check.admin.facade.UserInfoFacade;
import com.health.check.admin.vo.UserLoginVO;
import com.health.check.framework.base.RestResponse;
import com.health.check.framework.constant.CommonConstant;
import com.health.check.framework.exception.AuthException;
import com.health.check.framework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户授权登录
 *
 * @author xiao.xl 2022/6/17 23:02
 */
@RestController
@RequestMapping("/auth")
public class UserInfoController {
	
	private UserInfoFacade userInfoFacade;
	
	/**
	 * 用户登录
	 *
	 * @param userLogin 登录请求信息
	 * @return token信息
	 * @author xiao.xl 2022/3/9 16:09
	 */
	@PostMapping("/login")
	public RestResponse<UserLoginVO> login(@RequestBody @Validated UserLoginDTO userLogin) {
		UserLoginVO result = userInfoFacade.login(userLogin);
		return RestResponse.result(result);
	}
	
	/**
	 * 退出登录
	 *
	 * @param token        token信息
	 * @param accessToken token信息
	 * @return 提示消息
	 * @author xiao.xl 2022/6/20 16:00
	 */
	@PostMapping("/logout")
	public RestResponse<String> logout(@RequestHeader(required = false, value = CommonConstant.HEADER_AUTH) String token,
									   String accessToken) {
		if (StringUtils.isNotBlank(accessToken)) {
			token = accessToken;
		}
		if (StringUtils.isNotBlank(token)) {
			if (userInfoFacade.logout(token)) {
				return RestResponse.result("user logout success.");
			}
			throw AuthException.authTokenError("user token info timeout.");
		} else {
			throw AuthException.authTokenError("logout token can't be empty.");
		}
	}
	
	@Autowired
	public void setUserInfoFacade(UserInfoFacade userInfoFacade) {
		this.userInfoFacade = userInfoFacade;
	}
}
