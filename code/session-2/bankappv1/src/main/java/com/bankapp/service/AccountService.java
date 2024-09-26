package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.repo.Account;

public interface AccountService {
	public List<Account> getAll();
	
	public Account getById(int id);
	
	public void transfer(int fromAcc, int toAcc, BigDecimal amount);
	
	public void deposit(int accId, BigDecimal amount);
	
	public void withdraw(int accId, BigDecimal amount);
	
}
