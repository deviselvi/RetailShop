package com.retail.web.form;

import java.io.Serializable;

//Employee, Affiliated Customer, Privileged Customer,Customer


public class UserTypeForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6557108979042553211L;
	
	private Long code;
	
	private String name;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
