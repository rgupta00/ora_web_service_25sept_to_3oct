package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.repo.Account;
import com.bankapp.repo.AccountRepo;
//BL the brain of ur project
//BL=FR+ NFR
@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepo accountRepo;
	
	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public List<Account> getAll() {
		return accountRepo.getAll();
	}

	@Override
	public Account getById(int id) {
		return null;
	}

	@Override
	public void transfer(int fromAcc, int toAcc, BigDecimal amount) {

	}

	@Override
	public void deposit(int accId, BigDecimal amount) {

	}

	@Override
	public void withdraw(int accId, BigDecimal amount) {

	}

}
