package com.jasper.sab.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jasper.sab.util.BaseServletUtil;
import com.jasper.sab.util.Const;
import com.jasper.sab.util.JsonResult;

/**
 * 登录拦截
 * @author Jasper
 *
 */
public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		if (request.getRequestURI().startsWith("/loginout") || request.getRequestURI().startsWith("/test/")) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			if (request.getSession().getAttribute(Const.LOGIN_UID) == null) {
			    if (request.getRequestURI().startsWith("/json/")) {
					BaseServletUtil.sendResponseJson(response, JsonResult.buildNotLogin());
				} else if (request.getRequestURI().startsWith("/jsonp/")) { 
				    BaseServletUtil.sendResponseJsonP(response, 
                            request.getParameter("callback"), JsonResult.buildNotLogin());
				} else {
				    RequestDispatcher dispatcher = request.getRequestDispatcher("/loginout/index");
				    dispatcher.forward(request, response);
				}
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("LoginFilter init");
	}

}
