package com.retail.web.form;

import java.io.Serializable;

public class ProductDtlsForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long productId;
	
	private String productName;
	
	private String productType;
	
	private long productCost;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public long getProductCost() {
		return productCost;
	}

	public void setProductCost(long productCost) {
		this.productCost = productCost;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
	

