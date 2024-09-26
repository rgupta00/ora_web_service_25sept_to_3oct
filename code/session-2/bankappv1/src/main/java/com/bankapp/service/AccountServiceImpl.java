package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.exceptions.BankAccountNotFoundException;
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
		Account account=accountRepo.getById(id);
		if(account==null)
			throw new BankAccountNotFoundException("bank account with id "+ id +" is not found");
		return account;
	}

	@Override
	public void transfer(int fromAccId, int toAccId, BigDecimal amount) {

		Account fromAcc= getById(fromAccId);
		Account toAcc=getById(toAccId);
		
		fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
		
		toAcc.setBalance(toAcc.getBalance().add(amount));
		
		accountRepo.update(fromAcc);
		
		accountRepo.update(toAcc);
	}

	@Override
	public void deposit(int accId, BigDecimal amount) {
		Account acc= getById(accId);
		acc.setBalance(acc.getBalance().add(amount));
		accountRepo.update(acc);
	}

	@Override
	public void withdraw(int accId, BigDecimal amount) {
		Account acc= getById(accId);
		acc.setBalance(acc.getBalance().subtract(amount));
		accountRepo.update(acc);
	}

}
