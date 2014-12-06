package com.jasper.sab.util;

import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class JsonResult implements java.io.Serializable {
	private static final long serialVersionUID = -896988536994426785L;
	private String code;
	private Object data;
	private String message;

	public static class Code {
		public static final String success = "0";
		public static final String exception = "1";
		public static final String notlogin = "2";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JsonResult(String code, Object data, String message) {
		super();
		this.code = code;
		this.data = data;
		this.message = message;
	}

	public JsonResult() {
	}

	public static JsonResult buildException(String message) {
		JsonResult r = new JsonResult();
		r.setCode(JsonResult.Code.exception);
		r.setData(null);
		r.setMessage(message);
		return r;
	}
	
	public static JsonResult buildNotLogin(String message) {
        JsonResult r = new JsonResult();
        r.setCode(JsonResult.Code.notlogin);
        r.setData(null);
        r.setMessage(message);
        return r;
    }
	
	public static JsonResult buildNotLogin() {
		return buildNotLogin("no login");
	}

	public static JsonResult buildSuccess(Object data) {
		JsonResult r = new JsonResult();
		r.setCode(JsonResult.Code.success);
		r.setData(data);
		r.setMessage(null);
		return r;
	}
	
}
