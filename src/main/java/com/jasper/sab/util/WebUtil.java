package com.jasper.sab.util;

import javax.servlet.http.HttpServletRequest;

import com.jasper.sab.domain.User;

public class WebUtil {
	
	public static User getUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute("user");
	}
	
	public static void setUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute("user", user);
	}

}
