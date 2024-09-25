package com.bankapp.controller;

import java.util.List;

import com.bankapp.repo.Account;
import com.bankapp.service.AccountService;
import com.bankapp.service.AccountServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		AccountService accountService=new AccountServiceImpl();
		List<Account> accounts=accountService.getAll();
		for(Account a:accounts) {
			System.out.println(a);
		}
	}
}
