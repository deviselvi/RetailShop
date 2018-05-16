package com.retail.price.service;

import java.util.List;

import com.retail.web.form.BillingForm;
import com.retail.web.form.ProductDtlsForm;

public interface BillingService {
	BillingForm calcualteBills(List<ProductDtlsForm> products);

	BillingForm calculateDiscountBasedOnUserType(long userId, BillingForm form);
}
