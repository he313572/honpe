package com.honpe.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.honpe.mapper.AuthFunctionMapper;
import com.honpe.po.AuthFunction;
import com.honpe.po.TUser;
import com.honpe.utils.CookieUtils;
/**
 * 
 * <p>Title: AutoLoginInterceptor</p>
 * <p>Description:自动登录拦截器 </p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
public class AutoLoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private AuthFunctionMapper functionMapper;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("user") == null) {
			String cookieValue = CookieUtils.getCookieValue(request, "RememberMe");
			if (StringUtils.isNotBlank(cookieValue)) {
				String[] valus = cookieValue.split(",");
				String username = valus[0];
				String password = valus[1];
				Subject subject = SecurityUtils.getSubject();
				UsernamePasswordToken token = new UsernamePasswordToken(username, password);
				subject.login(token);
				if (subject.isAuthenticated()) {
					TUser tUser = (TUser) subject.getPrincipal();
					request.getSession().setAttribute("user", tUser);
					// 0表示不生成菜单1表示生成菜单
					List<AuthFunction> userMenu = functionMapper.selectAuthFunctionByUserId(tUser.getId(), "1");
					request.getSession().setAttribute("userMenu", userMenu);
				}
			}
		}
		return true;
	}
}
