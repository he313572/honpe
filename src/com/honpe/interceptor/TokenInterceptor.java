package com.honpe.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * 
 * <p>Title: TokenInterceptor</p>
 * <p>Description: 防止表单重复提交</p>
 * <p>Company: www.honpe.com</p> 
 * @version 1.0
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			SameUrlData annotation = method.getAnnotation(SameUrlData.class);
			if (annotation != null) {
				if (repeatDataValidator(request))
					return false;
				else
					return true;
			}
			return true;
		} else {
			return super.preHandle(request, response, handler);
		}
	}
	/**
	 * 
	 * <p>Title: repeatDataValidator</p>
	 * <p>Description: 通过url和请求数据判断是否表单重复提交</p>
	 * @param httpServletRequest
	 * @return
	 */
	public boolean repeatDataValidator(HttpServletRequest httpServletRequest) {
		String params = httpServletRequest.getParameterMap().toString(); 
		String url = httpServletRequest.getRequestURI();
		Map<String, String> map = new HashMap<String, String>();
		map.put(url, params);
		String nowUrlParams = map.toString();//

		Object preUrlParams = httpServletRequest.getSession().getAttribute(
				"repeatData");
		if (preUrlParams == null)
		{
			httpServletRequest.getSession().setAttribute("repeatData",
					nowUrlParams);
			return false;
		} else
		{
			if (preUrlParams.toString().equals(nowUrlParams))
			{

				return true;
			} else
			{
				httpServletRequest.getSession().setAttribute("repeatData",
						nowUrlParams);
				return false;
			}

		}
	}
}
