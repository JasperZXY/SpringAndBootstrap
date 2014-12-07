package com.jasper.sab.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import scala.collection.script.End;

import com.jasper.sab.util.Page;

@Controller
@RequestMapping("admin")
public class AdminController {
    private final static Logger logger = LoggerFactory.getLogger(AdminController.class);
    private List<String> list;
    
    @PostConstruct
    public void init() {
    	list = new ArrayList<String>();
    	for (int i=0; i<105; i++) {
    		list.add(Integer.toString(i));
    	}
    }
    
	@RequestMapping("index")
	public String index() {
		logger.info("AdminController  index");
		return "admin/index";
	}
	
	@RequestMapping("testPage")
	public ModelAndView testPage(@RequestParam("topage") int topage, 
			@RequestParam(value="pageSize", defaultValue="10") int pageSize) {
		ModelAndView view = new ModelAndView();
		int start = Page.getStart(topage, pageSize);
		int end = start + pageSize > list.size() ? list.size() : start + pageSize;
		Page page = new Page(start, list.size(), pageSize, list.subList(start, end));
		view.setViewName("/admin/testPage");
		view.addObject("page", page);
		return view;
	}

}
