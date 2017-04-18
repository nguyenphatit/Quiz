package com.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.domain.Account;

public interface AccountR extends CrudRepository<Account, Integer> {

}
