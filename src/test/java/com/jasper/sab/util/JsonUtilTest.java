package com.jasper.sab.util;

import com.jasper.sab.domain.User;

public class JsonUtilTest {
	public static void main(String[] args) {
		User user = new User();
		user.setName("小明");
		user.setPassword("123");
		String string = JsonUtil.obj2str(user);
		System.out.println(string);
		User user2 = JsonUtil.str2obj(string, User.class);
		System.out.println(user2);
	}

}
