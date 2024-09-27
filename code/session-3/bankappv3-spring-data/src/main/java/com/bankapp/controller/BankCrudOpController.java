package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.repo.Account;
import com.bankapp.service.AccountService;

@RestController
public class BankCrudOpController {
	
	private AccountService accountService;

	@Autowired
	public BankCrudOpController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//get All the accounts
	@GetMapping(path="accounts")
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	//get account by id
	@GetMapping(path="accounts/{id}")
	public Account getAnAccountById(@PathVariable int id){
		return accountService.getById(id);
	}
	
	//update
	
	//add new account
	
	//delete the account
	

}
