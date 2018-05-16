package com.retail.price.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.retail.price.enitity.ProductDtls;

public interface ProductRepositories extends JpaRepository<ProductDtls, Long> {
	
	@Query("select p from ProductDtls p where p.productId=?1 ")
	public ProductDtls findProductById(@Param("productId") long productId);
	
	@Query("select p from ProductDtls p where p.productName like %:A%") 
	List<ProductDtls> findAllByProductName(String productName);

	

}

