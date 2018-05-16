package com.retail.price.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.retail.price.enitity.UserDtls;

public interface DiscountRepositories extends JpaRepository<UserDtls, Long>{
	
	@Query("select p.percentage from Discount p where p.userTypeCode=?1 ")
	BigDecimal findDiscountByUserTypeCode(@Param("userTypeCode") long userTypeCode);
	
	@Query("select p.percentage from Discount p where p.aboveCost<=?1 ")
	BigDecimal findDiscountByTotalAmount(@Param("aboveCost") BigDecimal amount);
}