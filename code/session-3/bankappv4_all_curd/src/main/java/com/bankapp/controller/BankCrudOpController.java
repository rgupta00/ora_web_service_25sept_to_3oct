package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.UpdateDto;
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
	@PutMapping(path="accounts/{id}")
	public String update(@PathVariable  int id, @RequestBody UpdateDto updateDto) {
		accountService.update(id, updateDto);
	
		return "update successfully";
	}
	
	//add new account
	@PostMapping(path = "accounts")
	public String addAccount(@RequestBody  Account account) {
		accountService.addAccount(account);
		return "new account added successfully";
	}
	
	//delete the account
	@DeleteMapping(path="accounts/{id}")
	public void deleteAccount(@PathVariable int id) {
		accountService.deleteAccount(id);
	}

}
