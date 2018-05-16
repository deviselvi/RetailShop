package com.retail.price.service;

import org.springframework.stereotype.Service;

import com.retail.web.form.CalculateForm;
import com.retail.web.form.UserDtlsForm;

@Service
public interface UserDtlsService {
	
	public UserDtlsForm insertUser(UserDtlsForm userDtlsForm);
	public CalculateForm getDiscountService(long id);	
	

}