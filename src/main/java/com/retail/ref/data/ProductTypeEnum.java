package com.retail.ref.data;

public enum ProductTypeEnum {
	Cosmetic(1L, "Cosmetic"), Groceries(2L, "Groceries"), Electronic(
			3L, "Electronic");

	private final Long productTypeCode;
	private final String productTypename;

	ProductTypeEnum(Long productTypeCode, String productTypename) {
		this.productTypeCode = productTypeCode;
		this.productTypename = productTypename;
	}

	public Long getProductTypeCode() {
		return productTypeCode;
	}

	public String getProductTypename() {
		return productTypename;
	}

	public ProductTypeEnum fromProductTypeName(String productTypename) {
		return ProductTypeEnum.valueOf(productTypename);
	}
}
