package com.spring.service;

import com.spring.domain.Account;

public interface AccountS {
	/**
	 *  kiểm tra địa chỉ mail có tồn tại trong hệ thống
	 * @param email địa chỉ email
	 * @return true: tồn tại, false: không tồn tại
	 */
	public boolean checkEmail(String email);
	/**
	 * kiểm tra địa chỉ email vào password có tồn tại trong hệ thống hay không
	 * @param email
	 * @param password
	 * @return true: tồn tại| false: không
	 */
	public boolean checkEmailAndPassword(String email,String password);
	
	/**
	 * lấy ra tài khoản từ email nhận vào
	 * @param địa chỉ email
	 */
	public Account getAccountByEmail(String email);

}
