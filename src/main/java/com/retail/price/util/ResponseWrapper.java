package com.retail.price.util;



import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.retail.price.exception.RetailShopException;

public class ResponseWrapper<T> implements Serializable {

	  private static final long serialVersionUID = 1L;
	  private RetailShopException retailShopException;
	  private HttpStatus statusCode;
	  private String reason;
	  private T data;

	  public ResponseWrapper() {
	    // Default constructor
	  }

	  public ResponseWrapper(RetailShopException retailShopException) {
	    super();
	    this.retailShopException = retailShopException;
	  }

	   public ResponseWrapper(RetailShopException retailShopException, HttpStatus statusCode, String message,
	      T data) {
	    super();
	    this.retailShopException = retailShopException;
	    this.statusCode = statusCode;
	    this.reason = this.reason;
	    this.data = data;
	  }

	public RetailShopException getRetailShopException() {
		return retailShopException;
	}

	public void setRetailShopException(RetailShopException retailShopException) {
		this.retailShopException = retailShopException;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	   
	 
	}
