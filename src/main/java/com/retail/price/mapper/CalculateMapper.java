package com.retail.price.mapper;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.retail.price.enitity.UserDtls;
import com.retail.price.serviceImp.BillingServiceImpl;
import com.retail.web.form.CalculateForm;
import com.retail.web.form.UserDtlsForm;


public class CalculateMapper {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BillingServiceImpl.class);	
	
	public static CalculateForm mapDomainToForm(UserDtls calculateForm) {
		CalculateForm userDetails = new CalculateForm();
		return userDetails;
	}
	


	public static CalculateForm mapFormToDomain(UserDtls userDetails,long totalCost,int discount) {
		CalculateForm calculateForm = new CalculateForm();
		return calculateForm;
	}
	
	public static List<CalculateForm> mapDomainListToFormList(List<UserDtls> userDetails,long totalCost,int discount) {
 	   List<CalculateForm> calculateForm = new ArrayList<CalculateForm>();
 	   for (UserDtls UserDtlsObj : userDetails) {
 		  calculateForm.add(mapDomainToForm(UserDtlsObj));
 	   }
 	   return calculateForm;

    }
	public static CalculateForm mapFormToDomainForGroceries(UserDtlsForm userDtlsForm, int discount,
			long totalcost,String productType,long actualprice) {
		LOGGER.info("Mapper CalculateDtls mapFormToDomainForGroceries Start Time: " + System.currentTimeMillis());
		CalculateForm calculateForm=new CalculateForm();
		calculateForm.setProductId(userDtlsForm.getProductId());
		calculateForm.setUserId(userDtlsForm.getUserId());
		calculateForm.setUserName(userDtlsForm.getUserName());
		calculateForm.setUserType(userDtlsForm.getUserTypeId());
		calculateForm.setTotalCost(totalcost);
		calculateForm.setDiscount(discount);
		calculateForm.setProducttype(productType);
		calculateForm.setActualprice(actualprice);
		LOGGER.info("Mapper CalculateDtls mapFormToDomainForGroceries End Time: " + System.currentTimeMillis());
		return calculateForm;
		
	}
	
	public static CalculateForm mapFormToDomainForNormalProduct(UserDtlsForm userDetailsForm, int discount,
			long totalcost,String productType,long actualPrice) {
		LOGGER.info("Mapper ProductDtls mapFormToDomainForNormalProduct Start Time: " + System.currentTimeMillis());
		CalculateForm calculateForm=new CalculateForm();
		calculateForm.setProductId(userDetailsForm.getProductId());
		calculateForm.setUserId(userDetailsForm.getUserId());
		calculateForm.setUserName(userDetailsForm.getUserName());
		calculateForm.setUserType(userDetailsForm.getUserTypeId());
		calculateForm.setTotalCost(totalcost);
		calculateForm.setDiscount(discount);
		calculateForm.setProducttype(productType);
		calculateForm.setActualprice(actualPrice);
		LOGGER.info("Mapper ProductDtls mapFormToDomainForNormalProduct End Time: " + System.currentTimeMillis());
		return calculateForm;
	}

	
	
}
