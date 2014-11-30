package com.jasper.sab.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AdminService {
	private Map<String, String> admins;
	
	public AdminService() {
		admins = new HashMap<String, String>();
		admins.put("Jasper", "123456");
	}
	
	public boolean check(String uid, String password) {
		if (admins.containsKey(uid)) {
			return admins.get(uid).equals(password);
		}
		return false;
	}

}
