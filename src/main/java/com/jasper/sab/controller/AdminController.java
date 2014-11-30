package com.jasper.sab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@RequestMapping("index")
	public String index() {
		System.out.println("AdminController  index");
		return "admin/index";
	}

}
