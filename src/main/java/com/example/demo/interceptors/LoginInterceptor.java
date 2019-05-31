package com.example.demo.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String servletPath = request.getServletPath();
        servletPath = servletPath.toLowerCase();
        System.out.println(servletPath);



       /* String remoteUser = request.getRemoteUser();
		if (remoteUser!=null||servletPath.contains("login")){
			return true;
		}
		//ajax 请求是 : XMLHttpRequest
		String header = request.getHeader("X-Requested-With");
		//是ajax请求
		if("XMLHttpRequest".equals(header)){
			response.setHeader("REDIRECT","REDIRECT");
			response.setHeader("CONTENTPATH",request.getContextPath()+"/login");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}else{
			response.sendRedirect(request.getContextPath()+"/login");
		}*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
