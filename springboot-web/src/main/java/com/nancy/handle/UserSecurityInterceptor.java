package com.nancy.handle;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserSecurityInterceptor implements HandlerInterceptor {


	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView!=null){
			modelAndView.addObject("ctx", request.getContextPath());
		}
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
