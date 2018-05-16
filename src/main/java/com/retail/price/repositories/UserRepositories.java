package com.retail.price.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.retail.price.enitity.UserDtls;

public interface UserRepositories extends JpaRepository<UserDtls, Long>{
	
	@Query("select u from UserDetails u where u.userId=?1")
	public UserDtls findUserById(@Param("userId") long userId);

}
