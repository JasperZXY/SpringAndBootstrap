package com.jasper.sab.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:appContext.xml" })
public class PrivileteServiceTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private PrivilegeService privilegeService;
	
	@Test
	public void m() {
		System.out.println(privilegeService);
	}

}
