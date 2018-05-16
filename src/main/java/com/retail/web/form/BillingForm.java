package com.retail.web.form;

import java.math.BigDecimal;
import java.util.List;

public class BillingForm {
	private List<ProductDtlsForm> productDtls;

	private BigDecimal discountPercentage;

	private BigDecimal groceryTotalCost;

	private BigDecimal otherTotalCost;

	private boolean isDiscountApplied;

	private BigDecimal finalTotalAmount;

	private BigDecimal discountedOtherCost;

	public List<ProductDtlsForm> getProductDtls() {
		return productDtls;
	}

	public void setProductDtls(List<ProductDtlsForm> productDtls) {
		this.productDtls = productDtls;
	}

	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public BigDecimal getGroceryTotalCost() {
		return groceryTotalCost;
	}

	public void setGroceryTotalCost(BigDecimal groceryTotalCost) {
		this.groceryTotalCost = groceryTotalCost;
	}

	public BigDecimal getOtherTotalCost() {
		return otherTotalCost;
	}

	public void setOtherTotalCost(BigDecimal otherTotalCost) {
		this.otherTotalCost = otherTotalCost;
	}

	public boolean isDiscountApplied() {
		return isDiscountApplied;
	}

	public void setDiscountApplied(boolean isDiscountApplied) {
		this.isDiscountApplied = isDiscountApplied;
	}

	public BigDecimal getFinalTotalAmount() {
		return finalTotalAmount;
	}

	public void setFinalTotalAmount(BigDecimal finalTotalAmount) {
		this.finalTotalAmount = finalTotalAmount;
	}

	public BigDecimal getDiscountedOtherCost() {
		return discountedOtherCost;
	}

	public void setDiscountedOtherCost(BigDecimal discountedOtherCost) {
		this.discountedOtherCost = discountedOtherCost;
	}

}
