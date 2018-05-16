package com.retail.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.price.service.BillingService;
import com.retail.price.service.ProductDtlsService;
import com.retail.price.service.UserDtlsService;
import com.retail.price.util.ResponseWrapper;
import com.retail.web.form.BillingForm;
import com.retail.web.form.CalculateForm;
import com.retail.web.form.ProductDtlsForm;
import com.retail.web.form.UserDtlsForm;

@RestController
@RequestMapping("/retail")
public class RetailShopController {

	@Autowired
	UserDtlsService userDtlsService;
	@Autowired
	ProductDtlsService productDtlsService;

	@Autowired
	public BillingService billingSerivce;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(RetailShopController.class);

	@ResponseBody
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public ResponseWrapper<UserDtlsForm> saveUser(
			@RequestBody UserDtlsForm userDtlsForm) {
		LOGGER.info("Controller saveUser method Started Time: "
				+ System.currentTimeMillis());
		UserDtlsForm userDtlsFormObj = userDtlsService.insertUser(userDtlsForm);

		LOGGER.info("Controller saveUser method End Time: "
				+ System.currentTimeMillis());

		return new ResponseWrapper<UserDtlsForm>(null, HttpStatus.OK, "",
				userDtlsFormObj);

	}

	@ResponseBody
	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public ResponseWrapper<ProductDtlsForm> saveProduct(
			@RequestBody ProductDtlsForm productDtlsForm) {
		LOGGER.info("Controller saveProduct method Started Time: "
				+ System.currentTimeMillis());

		ProductDtlsForm productDetailsFormObj = productDtlsService
				.insertproduct(productDtlsForm);

		LOGGER.info("Controller saveProduct method End Time "
				+ System.currentTimeMillis());

		return new ResponseWrapper<ProductDtlsForm>(null, HttpStatus.OK, "",
				productDetailsFormObj);

	}

	@ResponseBody
	@RequestMapping(value = "/getdiscount/{id}", method = RequestMethod.GET)
	public ResponseWrapper<CalculateForm> getDiscount(@PathVariable long id) {
		LOGGER.info("Controller saveProduct method Started Time: "
				+ System.currentTimeMillis());
		// UserDetailsForm
		// userDetailsFormdata=userService.insertUser(userDetailsForm);
		CalculateForm calculateFormObj = userDtlsService.getDiscountService(id);

		LOGGER.info("Controller saveProduct method End Time: "
				+ System.currentTimeMillis());

		return new ResponseWrapper<CalculateForm>(null, HttpStatus.OK, "",
				calculateFormObj);

	}

	@ResponseBody
	@RequestMapping(value = "/calculateBill", method = RequestMethod.POST)
	public ResponseWrapper<BillingForm> submitForBilling(
			@ModelAttribute List<ProductDtlsForm> formData) {

		BillingForm billingForm = billingSerivce.calcualteBills(formData);
		return new ResponseWrapper<BillingForm>(null, HttpStatus.OK, "",
				billingForm);

	}

	@ResponseBody
	@RequestMapping(value = "/findDiscount}", method = RequestMethod.POST)
	public ResponseWrapper<BillingForm> getDiscount(
			@ModelAttribute BillingForm billingForm, Long userId) {
		LOGGER.info("BillingController find Discount method Start @: "
				+ System.currentTimeMillis());

		billingForm = billingSerivce.calculateDiscountBasedOnUserType(userId,
				billingForm);

		LOGGER.info("BillingController find Discount method End @ "
				+ System.currentTimeMillis());

		return new ResponseWrapper<BillingForm>(null, HttpStatus.OK, "",
				billingForm);

	}

}
