package com.retail.price.service;

import org.springframework.stereotype.Service;

import com.retail.web.form.ProductDtlsForm;

@Service
public interface ProductDtlsService {

	public ProductDtlsForm insertproduct(ProductDtlsForm productDtlsForm);

}