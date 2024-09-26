package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.repo.Account;
import com.bankapp.repo.AccountRepo;

@Service(value ="as")
public class AccountServiceImpl implements AccountService{

	private AccountRepo accountRepo;
	
	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public List<Account> getAll() {
		//extra logic in service layer
		return accountRepo.getAll();
	}

}
