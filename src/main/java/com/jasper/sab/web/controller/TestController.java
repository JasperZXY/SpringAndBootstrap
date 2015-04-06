package com.jasper.sab.web.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Value("${logs_level}")
	private String str;
	
	@PostConstruct
	public void init() {
		System.out.println("=============" + str + "==========");
	}
	
	@RequestMapping("index")
	public String index() {
		System.out.println("TestController  index");
		return "test/index";
	}

}
