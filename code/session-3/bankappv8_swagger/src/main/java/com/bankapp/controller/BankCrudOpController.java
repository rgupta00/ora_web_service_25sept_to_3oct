package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
public class BankCrudOpController {
	
	private AccountService accountService;

	@Autowired
	public BankCrudOpController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//ResponseEntity= data + status code
	
	//get All the accounts
//	@GetMapping(path="accounts")
//	public List<Account> getAll(){
//		return accountService.getAll();
//	}
	
	@GetMapping(path="accounts")
	public ResponseEntity<List<Account>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(accountService.getAll());
	}
	
	//get account by id
//	 @Operation(
//		      summary = "Retrieve a Account by Id",
//		      description = "Get a Account object by specifying its id. The response is Account object with id, title, description and published status.",
//		      tags = { "Account", "get" })
//		  @ApiResponses({
//		      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Account.class), mediaType = "application/json") }),
//		      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
//		      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping(path="accounts/{id}")
	public ResponseEntity<Account> getAnAccountById(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.OK).body(accountService.getById(id));
	}
	
	//update
	@PutMapping(path="accounts/{id}")
	public ResponseEntity<String> update(@PathVariable  int id, @RequestBody UpdateDto updateDto) {
		accountService.update(id, updateDto);
	
		return ResponseEntity.status(HttpStatus.OK).body("update successfully");
	}
	
	//add new account
	@PostMapping(path = "accounts")
	public ResponseEntity<String> addAccount( @Valid @RequestBody  Account account) {
		accountService.addAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body("new account added successfully");
	}
	
	//delete the account
	@DeleteMapping(path="accounts/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable int id) {
		accountService.deleteAccount(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
