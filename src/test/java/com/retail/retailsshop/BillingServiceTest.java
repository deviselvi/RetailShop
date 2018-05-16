package com.retail.retailsshop;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

import com.retail.price.enitity.ProductDtls;
import com.retail.price.enitity.UserDtls;
import com.retail.price.enitity.UserType;
import com.retail.price.repositories.DiscountRepositories;
import com.retail.price.repositories.ProductRepositories;
import com.retail.price.repositories.UserRepositories;
import com.retail.price.serviceImp.BillingServiceImpl;
import com.retail.ref.data.ProductTypeEnum;
import com.retail.web.form.BillingForm;
import com.retail.web.form.ProductDtlsForm;

public class BillingServiceTest {

	@Mock
	private ProductRepositories productRepositories;

	@Mock
	private DiscountRepositories discountRepositories;

	@Mock
	private UserRepositories userRepositories;
	
	private BillingServiceImpl billingService;
	
	
	

	@Test
	public void calcualteBillsTest() {
		ProductDtls productDetail = new ProductDtls();
		productDetail.setProductId(1L);
		productDetail.setProductType(ProductTypeEnum.Cosmetic.name());
		productDetail.setProductCost(1000);
		
		List<ProductDtlsForm> products = new ArrayList<ProductDtlsForm>();
		when(productRepositories.findProductById(1L)).thenReturn(productDetail);

		 BillingForm form= billingService.calcualteBills(products);
		assertEquals(true,form.getOtherTotalCost().compareTo(BigDecimal.ZERO)); 
		
	}

	
	@Test
	public void calculateDiscountBasedOnUserTypeTest() {
		Long userId = 321l;
		
		UserDtls user= new UserDtls();
		user.setUserId(userId);	
		UserType userType =new UserType();
		userType.setCode(1L);
		user.setUserType(userType);
		
		
		
		BillingForm form = new BillingForm();
		
		
		List<ProductDtlsForm> products = new ArrayList<ProductDtlsForm>();
		ProductDtlsForm productDetail = new ProductDtlsForm();
		productDetail.setProductId(1L);
		productDetail.setProductName(ProductTypeEnum.Groceries.name());
		productDetail.setProductCost(750);
		
		ProductDtlsForm productDetail1 = new ProductDtlsForm();
		productDetail.setProductId(2L);
		productDetail.setProductName(ProductTypeEnum.Cosmetic.name());
		productDetail.setProductCost(1750);
		
		form.setOtherTotalCost(BigDecimal.valueOf(750));
		form.setGroceryTotalCost(BigDecimal.valueOf(750));
		
		products.add(productDetail);
		products.add(productDetail1);
		
		
		form.setProductDtls(products );
		when(userRepositories.findUserById(userId)).thenReturn(user);
		
		when(discountRepositories.findDiscountByUserTypeCode(1L)).thenReturn(BigDecimal.valueOf(0.30));
		when(discountRepositories.findDiscountByTotalAmount(BigDecimal.valueOf(500))).thenReturn(BigDecimal.valueOf(0));
		 form=billingService.calculateDiscountBasedOnUserType(userId,form);


		 form= billingService.calculateDiscountBasedOnUserType(321l,form);
		assertEquals(true,form.getOtherTotalCost().compareTo(BigDecimal.ZERO)); 
		
	}


	public void setProductRepositories(ProductRepositories productRepositories) {
		this.productRepositories = productRepositories;
	}

	public void setDiscountRepositories(DiscountRepositories discountRepositories) {
		this.discountRepositories = discountRepositories;
	}
	public void setUserRepositories(UserRepositories userRepositories) {
		this.userRepositories = userRepositories;
	}

}
