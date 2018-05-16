package com.retail.price.serviceImp;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.price.enitity.ProductDtls;
import com.retail.price.enitity.UserDtls;
import com.retail.price.mapper.CalculateMapper;
import com.retail.price.mapper.UserDtlsMapper;
import com.retail.price.repositories.ProductRepositories;
import com.retail.price.repositories.UserRepositories;
import com.retail.price.service.UserDtlsService;
import com.retail.price.util.DiscountCalculation;
import com.retail.web.form.CalculateForm;
import com.retail.web.form.UserDtlsForm;

@Service
public class UserImp implements UserDtlsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserImp.class);

	@Autowired
	UserRepositories userRepositories;

	@Autowired
	ProductRepositories productRepositories;

	@Override
	public UserDtlsForm insertUser(UserDtlsForm userDtlsForm) {

		LOGGER.info("InsertUser method Start Time "
				+ System.currentTimeMillis());

		UserDtls userDetails = UserDtlsMapper.mapDomainToForm(userDtlsForm);
		UserDtls userData = userRepositories.saveAndFlush(userDetails);

		LOGGER.info("InsertUser method End Time " + System.currentTimeMillis());

		return UserDtlsMapper.mapFormToDomain(userData);
	}

	@Override
	public CalculateForm getDiscountService(long id) {
		LOGGER.info("getDiscountDtls Start Time " + System.currentTimeMillis());

		UserDtls userDetails = userRepositories.findUserById(id);
		UserDtlsForm userForm = UserDtlsMapper.mapFormToDomain(userDetails);
		long productId = userDetails.getProductId();

		ProductDtls productDtls = productRepositories
				.findProductById(productId);
		String productType = productDtls.getProductType();
		long totalcost = productDtls.getProductCost();
		Date createddate = userDetails.getCreatedDate();
		String userType = userDetails.getUserTypeId();
		Date date = new Date();

		if (productType.equalsIgnoreCase("Groceries")) {
			int discountonbil = 0;
			long actualprice = 0;
			if (totalcost >= 100) {
				discountonbil = DiscountCalculation
						.getDiscountByDoller(totalcost);
			}

			actualprice = totalcost - discountonbil;

			return CalculateMapper.mapFormToDomainForGroceries(userForm,
					discountonbil, totalcost, productType, actualprice);

		}

		else {

			if (userDetails.getUserTypeId().equalsIgnoreCase("Employee")) {
				int discount = DiscountCalculation.getDiscountBypercentage(
						totalcost, userType);
				int discountonbil = 0;
				int totaldiscount = 0;
				long actualprice = 0;
				if (totalcost >= 100) {
					discountonbil = DiscountCalculation
							.getDiscountByDoller(totalcost);
					totaldiscount = discount + discountonbil;
				} else
					totaldiscount = discount;
				actualprice = totalcost - totaldiscount;

				return CalculateMapper.mapFormToDomainForNormalProduct(
						userForm, totaldiscount, totalcost, productType,
						actualprice);

			} else if (userDetails.getUserTypeId().equalsIgnoreCase(
					"Affliated Employee")) {
				int discount = DiscountCalculation.getDiscountBypercentage(
						totalcost, userType);
				int discountonbil = 0;
				int totaldiscount = 0;
				long actualprice = 0;
				if (totalcost >= 100) {
					discountonbil = DiscountCalculation
							.getDiscountByDoller(totalcost);
					totaldiscount = discount + discountonbil;
				} else
					totaldiscount = discount;
				actualprice = totalcost - totaldiscount;

				return CalculateMapper.mapFormToDomainForNormalProduct(
						userForm, totaldiscount, totalcost, productType,
						actualprice);

			} else if (userDetails.getUserTypeId().equalsIgnoreCase(
					"Previleged User")) {
				int discount = DiscountCalculation.getDiscountBypercentage(
						totalcost, userType);
				int discountonbil = 0;
				int totaldiscount = 0;
				long actualprice = 0;
				if (totalcost >= 100) {
					discountonbil = DiscountCalculation
							.getDiscountByDoller(totalcost);
					totaldiscount = discount + discountonbil;
				} else
					totaldiscount = discount;
				actualprice = totalcost - totaldiscount;

				return CalculateMapper.mapFormToDomainForNormalProduct(
						userForm, totaldiscount, totalcost, productType,
						actualprice);

			} else if (createddate.before(date)) {
				int discount = DiscountCalculation.getDiscountBypercentage(
						totalcost, userType);
				int discountonbil = 0;
				int totaldiscount = 0;
				long actualprice = 0;
				if (totalcost >= 100) {
					discountonbil = DiscountCalculation
							.getDiscountByDoller(totalcost);
					totaldiscount = discount + discountonbil;
				} else
					totaldiscount = discount;
				actualprice = totalcost - totaldiscount;

				return CalculateMapper.mapFormToDomainForNormalProduct(
						userForm, totaldiscount, totalcost, productType,
						actualprice);

			} else if (totalcost > 100) {
				int discountonbil = 0;
				long actualprice = 0;
				if (totalcost >= 100) {
					discountonbil = DiscountCalculation
							.getDiscountByDoller(totalcost);
				}
				actualprice = totalcost - discountonbil;

				return CalculateMapper.mapFormToDomainForNormalProduct(
						userForm, discountonbil, totalcost, productType,
						actualprice);

			} else {
				return CalculateMapper.mapFormToDomainForGroceries(userForm, 0,
						totalcost, productType, totalcost);
			}
		}
	}
	
	
}
