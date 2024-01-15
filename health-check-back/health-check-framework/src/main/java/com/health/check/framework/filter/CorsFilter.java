package com.health.check.framework.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 请求跨域问题
 *
 * @author xiao.xl 2022/3/11 22:01
 */
@Component
public class CorsFilter implements Filter {
	
	protected static final String OPTIONS = "OPTIONS";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		// res.addHeader("Access-Control-Allow-Credentials", "true");
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT,OPTIONS");
		res.addHeader("Access-Control-Allow-Headers", "*");
		if (OPTIONS.equals(((HttpServletRequest) request).getMethod())) {
			response.getWriter().println("ok");
			return;
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filterConfig) {
	
	}
	
	@Override
	public void destroy() {
	
	}
}
