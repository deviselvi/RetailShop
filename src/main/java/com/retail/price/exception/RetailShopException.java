package com.retail.price.exception;

import java.util.List;



public class RetailShopException extends RuntimeException {
  
  private static final long serialVersionUID = 1L;
  
  private final String errorCode;
  private final String errorDescription;
  private final transient List<RetailShopError> retailShopError;
  
  
  /**
   * This is the constructor used for RetailShopException
   * 
   * @param errorCode, errorDescription  
   * @param RetailShopException
   */

  public RetailShopException(String errorCode, String errorDescription, List<RetailShopError> retailShopError) {
    super();
    this.errorCode = errorCode;
    this.errorDescription = errorDescription;
    this.retailShopError = retailShopError;
  }




  @Override
  public String toString() {
    return "RetailShopException [errorCode=" + errorCode + ", errorDescription=" + errorDescription + ", retailError="
        + retailShopError + "]";
  }


}