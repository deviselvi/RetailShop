package com.retail.price.exception;




public class RetailShopError {

	  private final String field;
	  private final String reasonHeader;
	  private final String reason;

	  /**
	   * This is the constructor used for RetailShopError
	   * 
	   * @param field
	   * @param reasionHeader
	   * @param reason
	   */
	  public RetailShopError(String field, String reasonHeader, String reason) {
	    super();
	    this.field = field;
	    this.reasonHeader = reasonHeader;
	    this.reason = reason;
	  }

	  /**
	   * Method to get Field
	   * 
	   * @return {@link String}
	   */
	  public String getField() {
	    return field;
	  }

	  /**
	   * Method to get Reason Header
	   * 
	   * @return {@link String}
	   */
	  public String getReasonHeader() {
	    return reasonHeader;
	  }

	  /**
	   * Method to get Reason
	   * 
	   * @return {@link String}
	   */
	  public String getReason() {
	    return reason;
	  }

	  @Override
	  public String toString() {
	    return "RetailShopError [field=" + field + ", reasonHeader=" + reasonHeader + ", reason=" + reason
	        + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
	        + super.toString() + "]";
	  }


	}