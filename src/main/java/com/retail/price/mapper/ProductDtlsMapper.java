package com.retail.price.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.retail.price.enitity.ProductDtls;
import com.retail.price.serviceImp.BillingServiceImpl;
import com.retail.web.form.ProductDtlsForm;


public class ProductDtlsMapper {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BillingServiceImpl.class);

	public static ProductDtls mapDomainToForm(ProductDtlsForm productDetailsForm) {
		LOGGER.info("Mapper ProductDtls mapDomainToForm Start Time: " + System.currentTimeMillis());
		ProductDtls productObj = new ProductDtls();
		productObj.setProductId(productDetailsForm.getProductId());
		productObj.setProductName(productDetailsForm.getProductName());
		productObj.setProductType(productDetailsForm.getProductType());
		productObj.setProductCost(productDetailsForm.getProductCost());
		LOGGER.info("Mapper ProductDtls mapDomainToForm End Time: " + System.currentTimeMillis());
		return productObj;
	}
	
	public static List<ProductDtls> mapFormListtoDomain(
			List<ProductDtlsForm> ProductDtlsForms) {
		LOGGER.info("Mapper List ProductDtls mapFormListtoDomain Start Time: " + System.currentTimeMillis());
		List<ProductDtls> productDetails = new ArrayList<ProductDtls>();

		if (!CollectionUtils.isEmpty(ProductDtlsForms)) {
			for (ProductDtlsForm form : ProductDtlsForms) {
				ProductDtls productDtls = mapDomainToForm(form);
				productDetails.add(productDtls);
			}
		}

		LOGGER.info("Mapper List ProductDtls mapFormListtoDomain End Time: " + System.currentTimeMillis()+"productDetails :"+productDetails);
		return productDetails;
	}	

	public static List<ProductDtlsForm> mapDomainToFormList(
			List<ProductDtls> productDetails) {
		
		LOGGER.info("Mapper List ProductDtls mapDomainToFormList Start Time: " + System.currentTimeMillis());
		List<ProductDtlsForm> productDetailForms = new ArrayList<ProductDtlsForm>();

		if (!CollectionUtils.isEmpty(productDetails)) {
			for (ProductDtls productDtl : productDetails) {
				ProductDtlsForm form = mapFormToDomain(productDtl);
				productDetailForms.add(form);
			}
		}
		LOGGER.info("Mapper List ProductDtls mapDomainToFormList End Time: " + System.currentTimeMillis());

		return productDetailForms;
	}

	public static ProductDtlsForm mapFormToDomain(ProductDtls productDtls) {

		LOGGER.info("Mapper List ProductDtls mapFormToDomain Start Time: " + System.currentTimeMillis());
		ProductDtlsForm productDtlsForm = new ProductDtlsForm();
		productDtlsForm.setProductId(productDtls.getProductId());
		productDtlsForm.setProductName(productDtls.getProductName());
		productDtlsForm.setProductType(productDtls.getProductType());
		productDtlsForm.setProductCost(productDtls.getProductCost());

		LOGGER.info("Mapper List ProductDtls mapFormToDomain End Time: " + System.currentTimeMillis()+"productDtlsForm :"+productDtlsForm);
		return productDtlsForm;

	}

}
