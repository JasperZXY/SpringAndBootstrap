package com.jasper.sab.web.listener;

import java.util.Arrays;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebInitListener extends ContextLoaderListener {
	private WebApplicationContext ctx;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		System.out.println("contextInitialized");
		ctx = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		System.out.println("==========contextDestroyed=========");
	}

}
