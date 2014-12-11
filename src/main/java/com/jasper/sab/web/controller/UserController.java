package com.jasper.sab.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jasper.sab.dao.mapper.UserDao;
import com.jasper.sab.domain.User;
import com.jasper.sab.util.BaseServletUtil;
import com.jasper.sab.util.JsonResult;
import com.jasper.sab.util.JsonUtil;

@Controller
@RequestMapping("user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserDao userDao;
	
	@RequestMapping("listAll")
	public ModelAndView listAll() {
		logger.info("UserController  listAll");
		ModelAndView view = new ModelAndView();
		view.setViewName("user/list");
		logger.info("users:" + userDao.listAll());
		view.addObject("users", userDao.listAll());
		return view;
	}

	@RequestMapping("addForJsonp")
	public void addForJsonp(@RequestParam("name") String name, 
			@RequestParam("password") String password,
			@RequestParam("age") int age,
			@RequestParam("callback") String callback,
			HttpServletResponse response) {
		logger.info("UserController  add");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setAge(age);
		userDao.insert(user);
		BaseServletUtil.sendResponseJsonP(response, callback, JsonResult.buildSuccess(user.getId()));
	}
	
	@RequestMapping("addForJson")
	public void addForJson(@RequestParam("name") String name, 
	        @RequestParam("password") String password,
	        @RequestParam("age") int age,
	        HttpServletResponse response) {
	    logger.info("UserController  add");
	    User user = new User();
	    user.setName(name);
	    user.setPassword(password);
	    user.setAge(age);
	    userDao.insert(user);
	    BaseServletUtil.sendResponseJson(response, JsonResult.buildSuccess(user.getId()));
	}
	
	@RequestMapping("addUI")
	public String addUI() {
		logger.info("UserController  addUI");
		return "/user/add";
	}
	
	@RequestMapping("getUserById")
	public void getUserById(@RequestParam("id") int id, 
			@RequestParam("callback") String callback,
			HttpServletResponse response) {
		logger.info("UserController  getUserById");
		User user = userDao.getUserById(id);
		if (user == null) {
			BaseServletUtil.sendResponseJsonP(response, callback, JsonResult.buildException("can't get id=" + id));
		} else {
			BaseServletUtil.sendResponseJsonP(response, callback, JsonResult.buildSuccess(JsonUtil.obj2str(user)));
		}
	}
	
	
	
	@RequestMapping("update")
	public ModelAndView update(
			@RequestParam("id") int id, 
			@RequestParam("name") String name, 
			@RequestParam("password") String password,
			@RequestParam("age") int age,
			HttpServletResponse response) {
		logger.info("UserController  update");
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setAge(age);
		userDao.update(user);
		return listAll();
	}

}
