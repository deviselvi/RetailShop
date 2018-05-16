package com.retail.price.enitity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//UserTypeCode and userTypeName

@Entity
@Table(name = "USER_TYPE")
public class UserType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6557108979042553211L;

	@Column(name = "USER_TYPE_CODE")
	private Long code;

	@Column(name = "USER_TYPE_NAME")
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

}
