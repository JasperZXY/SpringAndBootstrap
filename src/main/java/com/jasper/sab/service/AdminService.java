package com.jasper.sab.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasper.sab.dao.mapper.UserDao;

@Service
public class AdminService {
    @Autowired
    private UserDao userDao;
    
	private Map<String, String> admins;
	
	public AdminService() {
		admins = new HashMap<String, String>();
		admins.put("Jasper", "1");
	}
	
	public boolean check(String uid, String password) {
		if (admins.containsKey(uid)) {
			return admins.get(uid).equals(password);
		}
		return false;
	}

}
