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

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		System.out.println("getRequestURL:" + request.getRequestURL());
		System.out.println("getRequestURI:" + request.getRequestURI());
		if (request.getRequestURI().startsWith("/loginout")) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			if (request.getSession().getAttribute(Const.LOGIN_UID) == null) {
				if (request.getParameter("callback") == null) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/loginout/index");
					dispatcher.forward(request, response);
				} else {
					BaseServletUtil.sendResponseJsonP(response, 
							request.getParameter("callback"), JsonResult.buildNotLogin());
				}
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
