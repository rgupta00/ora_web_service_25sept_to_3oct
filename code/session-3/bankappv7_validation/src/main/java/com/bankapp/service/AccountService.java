package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.dto.UpdateDto;
import com.bankapp.repo.Account;

public interface AccountService {
	public List<Account> getAll();
	
	public Account getById(Integer id);
	
	public void transfer(int fromAccId, int toAccId, BigDecimal amount);
	
	public void deposit(int accId, BigDecimal amount);
	
	public void withdraw(int accId, BigDecimal amount);
	
	//add new account
	public void addAccount(Account account);
	
	//update
	public void update(int accId, UpdateDto updateDto);
	//delete
	public void deleteAccount(int id);
	
}
