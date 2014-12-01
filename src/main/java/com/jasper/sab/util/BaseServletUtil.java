package com.jasper.sab.util;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

public class BaseServletUtil {

	 private static ObjectMapper mapper = new ObjectMapper();
	 static {
	        mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
	 }
	 
	 public static void sendResponseJsonP(ServletResponse response, String callback, JsonResult result) {
        response.setContentType("application/javascript");
        response.setCharacterEncoding("UTF-8");
        try {
            ServletOutputStream stream = response.getOutputStream();
            String ret = mapper.writeValueAsString(result);
            String funcName = "callBackFunction";
            if (StringUtils.isBlank(callback)) {
            	funcName = callback;
			}
            stream.write((funcName+"(" + ret + ");").getBytes("UTF-8"));
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	    
    public static String getRemortIP(HttpServletRequest request) {
        String ips = "";
        if (request.getHeader("x-forwarded-for") == null) {
            ips = request.getRemoteAddr();
        } else {
            ips = request.getHeader("x-forwarded-for");
        }
        String ip = "";
        if (ips.contains(",")) {
            ip = ips.split(",")[0].trim();
        }
        return ip;
    }
	 
}
