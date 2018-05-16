package com.retail.price.serviceImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.price.enitity.ProductDtls;
import com.retail.price.mapper.ProductDtlsMapper;
import com.retail.price.repositories.ProductRepositories;
import com.retail.price.repositories.UserRepositories;
import com.retail.price.service.ProductDtlsService;
import com.retail.web.form.ProductDtlsForm;

@Service
public class ProductImp implements ProductDtlsService {

	@Autowired
	UserRepositories userRepositories;

	@Autowired
	ProductRepositories productRepositories;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProductImp.class);

	@Override
	public ProductDtlsForm insertproduct(ProductDtlsForm productDtlsForm) {

		LOGGER.info("Data Insert Start Time: " + System.currentTimeMillis()
				+ "with parameter productDtlsForm " + "and productDtlsForm  "
				+ productDtlsForm.toString());

		ProductDtls productDtls = ProductDtlsMapper
				.mapDomainToForm(productDtlsForm);
		ProductDtls productData = productRepositories.saveAndFlush(productDtls);

		LOGGER.info("Data Insert End Time:" + System.currentTimeMillis()
				+ "with parameter ProdcutData " + "and ProdcutData  "
				+ productData.toString());

		return ProductDtlsMapper.mapFormToDomain(productData);
	}


	public ProductDtlsForm updateproduct(ProductDtlsForm productDtlsForm,
			Long productId) {

		LOGGER.info("Data Update Start Time: " + System.currentTimeMillis()
				+ "with parameter productDtlsForm " + "and productDtlsForm  "
				+ productDtlsForm.toString());

		ProductDtls pp = productRepositories.findProductById(productDtlsForm
				.getProductId());

		pp.setProductCost(productDtlsForm.getProductCost());
		pp.setProductName(productDtlsForm.getProductName());

		ProductDtls productData = productRepositories.saveAndFlush(pp);

		LOGGER.info("Data Update End Time: " + System.currentTimeMillis()
				+ "with parameter ProdcutData " + "and ProdcutData  "
				+ productData.toString());

		return ProductDtlsMapper.mapFormToDomain(productData);
	}

	public ProductDtlsForm searchproduct(ProductDtlsForm productDtlsForm) {

		LOGGER.info("Product Name Search Start Time: "
				+ System.currentTimeMillis()
				+ "with parameter productDtlsForm " + "and productDtlsForm  "
				+ productDtlsForm.toString());

		ProductDtls pp = (ProductDtls) productRepositories
				.findAllByProductName(productDtlsForm.getProductName());

		LOGGER.info("Product Name Search End Time: " + System.currentTimeMillis()
				+ "with parameter ProdcutData " + "and ProdcutData  "
				+ pp.toString());

		return ProductDtlsMapper.mapFormToDomain(pp);
	}

}
