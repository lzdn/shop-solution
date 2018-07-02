package com.xiangqin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangqin.domain.Account;
import com.xiangqin.repository.AccountRepository;
import com.xiangqin.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account findById(Integer id) {
		return accountRepository.getOne(id);
	}
}
