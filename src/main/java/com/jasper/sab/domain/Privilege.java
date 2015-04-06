package com.jasper.sab.domain;

public class Privilege {
	private String module;
	private String privilege;
	private String name;
	
	public Privilege() {}
	public Privilege(String module, String privilege, String name) {
		super();
		this.module = module;
		this.privilege = privilege;
		this.name = name;
	}
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Privilege [module=" + module + ", privilege=" + privilege + ", name=" + name + "]";
	}
	
}
