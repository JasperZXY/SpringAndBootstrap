package com.jasper.sab.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.jasper.sab.domain.Module;
import com.jasper.sab.domain.Privilege;
import com.jasper.sab.exception.ServiceException;

@Service
public class PrivilegeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PrivilegeService.class);
	private List<Module> modules;
	private List<Privilege> privileges;
	
	@PostConstruct
	public void init() {
		modules = new ArrayList<Module>();
		privileges = new ArrayList<Privilege>();
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = null;
		String[] moduleStrings = null;
		String[] privilegeStrings = null;
		try {
			resource = resourceLoader.getResource("classpath:/conf/module");
			moduleStrings = FileUtils.readFileToString(resource.getFile()).split("\n");
			resource = resourceLoader.getResource("classpath:/conf/privilege");
			privilegeStrings = FileUtils.readFileToString(resource.getFile()).split("\n");
		} catch (IOException e) {
			LOGGER.error("PrivilegeService init error:", e);
		}
		
		for (int i=0; i<moduleStrings.length; i++) {
			if (! ("".equals(moduleStrings[i].trim()) || moduleStrings[i].startsWith("#"))) {
				String[] tmp = moduleStrings[i].split("#");
				if (tmp != null && tmp.length == 2) {
					Module module = new Module(tmp[0], tmp[1]);
					modules.add(module);
				} else {
					throw new ServiceException("conf/module file is something wrong," + moduleStrings[i]);
				}
			}
		}
		
		for (int i=0; i<privilegeStrings.length; i++) {
			if (! ("".equals(privilegeStrings[i].trim()) || privilegeStrings[i].startsWith("#"))) {
				String[] tmp = privilegeStrings[i].split("#");
				if (tmp != null && tmp.length == 3) {
					Privilege privilege = new Privilege(tmp[0], tmp[1], tmp[2]);
					privileges.add(privilege);
				} else {
					throw new ServiceException("conf/privilege file is something wrong," + privilegeStrings[i]);
				}
			}
		}
		
		System.out.println(modules);
		System.out.println(privileges);
	}
}
