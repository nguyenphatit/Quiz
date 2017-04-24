package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.Account;
import com.spring.repository.AccountR;

@Service
@Transactional
public class AccountSI implements AccountS {
	@Autowired
	private AccountR r;

	@Override
	public boolean checkEmail(String email) {
		List<Account> lAccount = r.searchByEmail(email);
		return (lAccount.size() > 0) ? true : false;
	}

	@Override
	public boolean checkEmailAndPassword(String email, String password) {

		List<Account> lAccount = r.searchByEmail(email, password);
		return (lAccount.size() > 0) ? true : false;
	}

	@Override
	public Account getAccountByEmail(String email) {

		return r.searchByEmail(email).get(0);
	}

}
