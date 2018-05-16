package com.retail.price.enitity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Employee, Affiliated Customer, Privileged Customer,Customer

@Entity
@Table(name = "DISCOUNT")
public class DiscountDtls implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6557108979042553211L;

	@Column(name = "DISCOUNT_CODE")
	private Long code;

	@Column(name = "DISCOUNT_PERCENTAGE")
	private BigDecimal percentage;
	
	@Column(name = "ABOVE_COST")
	private BigDecimal aboveCost;

	@Column(name = "USER_TYPE")
	private Long userTypeCode;

	@Column(name = "USER_TYPE")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_TYPE_CODE")
	private UserType userType;

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

	public long getUserTypeCode() {
		return userTypeCode;
	}

	public void setUserTypeCode(long userTypeCode) {
		this.userTypeCode = userTypeCode;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
}
