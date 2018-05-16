package com.retail.price.serviceImp;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.retail.price.enitity.ProductDtls;
import com.retail.price.enitity.UserDtls;
import com.retail.price.repositories.DiscountRepositories;
import com.retail.price.repositories.ProductRepositories;
import com.retail.price.repositories.UserRepositories;
import com.retail.price.service.BillingService;
import com.retail.ref.data.ProductTypeEnum;
import com.retail.web.form.BillingForm;
import com.retail.web.form.ProductDtlsForm;

public class BillingServiceImpl implements BillingService {

	@Autowired
	private ProductRepositories productRepositories;

	@Autowired
	private DiscountRepositories discountRepositories;

	@Autowired
	private UserRepositories userRepositories;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BillingServiceImpl.class);

	@Override
	public BillingForm calculateDiscountBasedOnUserType(long userId,
			BillingForm form) {
		
		LOGGER.info("DiscountBasedOnUser Start Time: " + System.currentTimeMillis());

		UserDtls userDetail = userRepositories.findUserById(userId);

		boolean isDiscountApplied = false;

		BigDecimal totalOtherCost = form.getOtherTotalCost();
	

		// Find Discount
		if (totalOtherCost.compareTo(BigDecimal.ZERO) > 0) {
			BigDecimal percentage = discountRepositories
					.findDiscountByUserTypeCode(userDetail.getUserType()
							.getCode());
			if (percentage != null) {

				totalOtherCost = totalOtherCost.subtract(totalOtherCost
						.multiply(percentage));
				isDiscountApplied = true;
				form.setDiscountPercentage(percentage);
			}
			if (!isDiscountApplied) {
				percentage = discountRepositories
						.findDiscountByTotalAmount(totalOtherCost);
				totalOtherCost = totalOtherCost.subtract(totalOtherCost
						.multiply(percentage));
				form.setDiscountPercentage(percentage);
				isDiscountApplied = true;
			}
		}

		form.setDiscountApplied(isDiscountApplied);
		form.setDiscountedOtherCost(totalOtherCost);

		LOGGER.info("DiscountBasedOnUser End Time: " + System.currentTimeMillis()+ "with parameter data" + form.toString());
		
		return form;
	}

	@Override
	public BillingForm calcualteBills(List<ProductDtlsForm> products) {
		// List of products bought
		
		LOGGER.info("CalcualteBills Start Time: " + System.currentTimeMillis());
		BillingForm form = new BillingForm();
		BigDecimal totalGroceriesCost = null;
		BigDecimal totalOtherCost = null;
		for (ProductDtlsForm productForm : products) {

			ProductDtls productDetail = productRepositories
					.findProductById(productForm.getProductId());
			if (ProductTypeEnum.Groceries.name().equalsIgnoreCase(
					productDetail.getProductType())) {
				totalGroceriesCost = totalGroceriesCost.add(BigDecimal.valueOf(productDetail.getProductCost()));
			} else {
				totalOtherCost = totalOtherCost.add(BigDecimal.valueOf(productDetail.getProductCost()));;
			}
		}
		LOGGER.info("totalGroceriesCost : {} , totalOtherCost : {} ",
				totalGroceriesCost, totalOtherCost);
		form.setProductDtls(products);
		form.setGroceryTotalCost(totalGroceriesCost);
		form.setOtherTotalCost(totalOtherCost);
		
		LOGGER.info("calcualteBills End Time: " + System.currentTimeMillis()+ "with parameter data" + form.toString());
		return form;
	}

}
