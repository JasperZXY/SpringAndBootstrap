package com.jasper.sab.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jasper.sab.service.AdminService;
import com.jasper.sab.util.Const;

@Controller
@RequestMapping("/loginout")
public class LoginController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("index")
	public String index() {
		System.out.println("LoginController  index");
		return "login/index";
	}
	
	@RequestMapping("login2")
	public String login2(@RequestParam("uid") String uid, 
			@RequestParam("password") String password,
			HttpServletRequest request) {
		System.out.println("login:" + uid + " " + password);
		if (adminService.check(uid, password)) {
			request.getSession().setAttribute(Const.LOGIN_UID, uid);
			return "admin/index";
		}
		return "login/index";
	}
	
	@RequestMapping("login")
	public String login(@RequestParam("uid") String uid, 
			@RequestParam("password") String password,
			HttpServletRequest request) {
		System.out.println("login:" + uid + " " + password);
		if (adminService.check(uid, password)) {
			request.getSession().setAttribute(Const.LOGIN_UID, uid);
			//重定向
			return "redirect:/admin/index";
		}
		return "login/index";
	}
	
	@RequestMapping("logout")
	public String login(HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    System.out.println("logout uid=" + session.getAttribute(Const.LOGIN_UID));
	    session.removeAttribute(Const.LOGIN_UID);
	    return "login/index";
	}

}
