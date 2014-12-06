package com.jasper.sab.util;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	private final static ObjectMapper MAPPER = new ObjectMapper();
	
	public static String obj2str(Object obj) {
		try {
			return MAPPER.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T str2obj(String str, Class<T> t) {
		try {
			return (T) MAPPER.readValue(str, t);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
