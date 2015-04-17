package com.jasper.sab.web.controller;

import java.io.IOException;
import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
    
    private static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.configure(org.codehaus.jackson.JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
    }
	
	@Value("${logs_level}")
	private String str;
	
	@Value("#{settings.logs_level}")
	private String logDir;
	
	@PostConstruct
	public void init() {
		System.out.println("=============" + str + "==========");
		System.out.println("=============" + logDir + "==========");
	}
	
	@RequestMapping("index")
	@ResponseBody
	public String index() {
		System.out.println("TestController  index");
		return "success";
	}
	
	@RequestMapping("clean")
	public void clean(HttpServletRequest request, HttpServletResponse response) {
	    logger.info("clean");
	    System.gc();
	}
	
	@RequestMapping("simpleMethod")
	public void simpleMethod(HttpServletRequest request, HttpServletResponse response) {
	    logger.info("simpleMethod");
	    String result = doSomething();
	    sendResponse(response, result);
	}
	
	//注意：这里一定要有这两个参数（request，response），不然会报错
	@RequestMapping("asyncMethod")
	public void asyncMethod(HttpServletRequest request, HttpServletResponse response) {
	    logger.info("asyncMethod");
	    _asyncMethod(request.startAsync());
	}
	
	@Async
    public void _asyncMethod(AsyncContext context) {
	    String result = doSomething();
	    sendResponse(context.getResponse(), result);
	    context.complete();
	}
	
	public static void sendResponse(ServletResponse response, Object result) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            ServletOutputStream stream = response.getOutputStream();
            mapper.writeValue(stream, result);// mapper.writeValue(writer, result);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	/**
	 * 费时操作，测试结果是差不多500ms
	 * @return
	 */
	public String doSomething() {
	    String str = "";
	    for (int i=0; i<20000; i++) {
	        str += i;
	    }
	    return str;
	}
	
	public static void main(String[] args) {
	    long time = System.currentTimeMillis();
        new TestController().doSomething();
        System.out.println(System.currentTimeMillis() - time);
    }
	

}
