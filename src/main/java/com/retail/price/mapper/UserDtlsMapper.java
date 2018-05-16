package com.retail.price.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.retail.price.enitity.UserDtls;
import com.retail.price.serviceImp.BillingServiceImpl;
import com.retail.web.form.UserDtlsForm;

public class UserDtlsMapper {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BillingServiceImpl.class);
	
	public static UserDtls mapDomainToForm(UserDtlsForm userDtls) {
		LOGGER.info("Mapper UserDtls mapDomainToForm Start Time: " + System.currentTimeMillis());
		UserDtls userDtlsObj = new UserDtls();
		userDtlsObj.setUserId(userDtls.getUserId());
		userDtlsObj.setUserName(userDtls.getUserName());
		userDtlsObj.setUserTypeId(userDtls.getUserTypeId());
		if (userDtls.getCreatedDate() == null)
			userDtlsObj.setCreatedDate(new Date());
		userDtlsObj.setUpdatedDate(userDtls.getUpdatedDate());
		userDtlsObj.setProductId(userDtls.getProductId());
		LOGGER.info("Mapper UserDtls mapDomainToForm End Time: " + System.currentTimeMillis());
		return userDtlsObj;
	}

	public static List<UserDtls> mapFormListtoDomain(
		
			List<UserDtlsForm> UserDtlsForms) {
		List<UserDtls> userDetails = new ArrayList<UserDtls>();

		if (!CollectionUtils.isEmpty(UserDtlsForms)) {
			for (UserDtlsForm form : UserDtlsForms) {
				UserDtls userDtls = mapDomainToForm(form);
				userDetails.add(userDtls);
			}
		}

		return userDetails;
	}

	public static UserDtlsForm mapFormToDomain(UserDtls userDetails) {
		LOGGER.info("Mapper UserDtls mapFormToDomain Start Time: " + System.currentTimeMillis());
		
		UserDtlsForm userDtlsForm = new UserDtlsForm();
		userDtlsForm.setUserId(userDetails.getUserId());
		userDtlsForm.setUserName(userDetails.getUserName());
		userDtlsForm.setUserTypeId(userDetails.getUserTypeId());
		userDtlsForm.setCreatedDate(userDetails.getCreatedDate());
		userDtlsForm.setUpdatedDate(userDetails.getUpdatedDate());
		userDtlsForm.setProductId(userDetails.getProductId());
		LOGGER.info("Mapper UserDtls mapFormToDomain End Time: " + System.currentTimeMillis());
		return userDtlsForm;

	}

	public static List<UserDtlsForm> mapDomainListToFormList(
			List<UserDtls> userDetails) {
		LOGGER.info("Mapper UserDtls mapDomainListToFormList Start Time: " + System.currentTimeMillis());
		List<UserDtlsForm> resultForm = new ArrayList<UserDtlsForm>();
		for (UserDtls UserDetailsdata : userDetails) {
			resultForm.add(mapFormToDomain(UserDetailsdata));
		}
		LOGGER.info("Mapper UserDtls mapDomainListToFormList End Time: " + System.currentTimeMillis() +"resultForm : "+ resultForm.toString());
		return resultForm;

	}
}
