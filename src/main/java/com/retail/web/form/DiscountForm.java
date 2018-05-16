package com.retail.web.form;

import java.math.BigDecimal;

//Employee, Affiliated Customer, Privileged Customer,Customer

public class DiscountForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6557108979042553211L;

	private Long code;

	private BigDecimal percentage;

	private BigDecimal aboveCost;

	private Long userTypeCode;

	private UserTypeForm userType;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public BigDecimal getAboveCost() {
		return aboveCost;
	}

	public void setAboveCost(BigDecimal aboveCost) {
		this.aboveCost = aboveCost;
	}

	public Long getUserTypeCode() {
		return userTypeCode;
	}

	public void setUserTypeCode(Long userTypeCode) {
		this.userTypeCode = userTypeCode;
	}

	public UserTypeForm getUserType() {
		return userType;
	}

	public void setUserType(UserTypeForm userType) {
		this.userType = userType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
