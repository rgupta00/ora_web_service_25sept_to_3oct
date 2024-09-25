package com.bankapp.service;

import java.util.List;

import com.bankapp.repo.Account;
import com.bankapp.repo.AccountRepo;
import com.bankapp.repo.AccountRepoJdbcImpl;
import com.bankapp.repo.AccountRepoMapImpl;

public class AccountServiceImpl implements AccountService{

	private AccountRepo accountRepo;
	
	public AccountServiceImpl() {
		accountRepo=new AccountRepoJdbcImpl();// :(
	}
	
	@Override
	public List<Account> getAll() {
		//extra logic in service layer
		return accountRepo.getAll();
	}

}
