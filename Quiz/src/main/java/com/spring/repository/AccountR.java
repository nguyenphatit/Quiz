package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.domain.Account;

public interface AccountR extends CrudRepository<Account, Integer> {
	/**
	 * Lấy danh sách tài khoản từ địa chỉ email nhận vào
	 * @param email địa chỉ email
	 * @return danh sách tài khoản 
	 */
	@Query("FROM Account a WHERE a.email=:email AND  a.state=true")
	public List<Account>searchByEmail(@Param("email")String email);
	/**
	 * Lấy danh sách tài khoản từ địa chỉ email và password nhận vào
	 * @param email 
	 * @param password
	 * @return danh sách tài khoản
	 */
	@Query("FROM Account a WHERE a.email=:email AND a.password=:password AND a.state=true")
	public List<Account>searchByEmail(@Param("email")String email,@Param("password")String password);

}
