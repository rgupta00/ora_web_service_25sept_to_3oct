package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.repo.Account;
import com.bankapp.service.AccountService;

@RestController
public class AccountCrudController {

	private AccountService accountService;

	@Autowired
	public AccountCrudController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping(path="accounts")
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
}
