package com.bankapp.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.repo.Account;
import com.bankapp.service.AccountService;
import com.bankapp.service.AccountServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		
		AccountService accountService=(AccountService) applicationContext.getBean("as");
		
		List<Account> accounts=accountService.getAll();
		for(Account a:accounts) {
			System.out.println(a);
		}
	}
}
