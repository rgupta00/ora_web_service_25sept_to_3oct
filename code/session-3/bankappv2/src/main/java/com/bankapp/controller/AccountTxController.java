package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;

@RestController
public class AccountTxController {
	
	private AccountService accountService;

	@Autowired
	public AccountTxController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//transfer
	@PostMapping(path="transfer")
	public String trasfer(@RequestBody TransferDto transferDto) {
		
		accountService.transfer(transferDto.getFromAccId(), transferDto.getToAccId(),
				transferDto.getAmount());
		
		return "fund is transfered successfully";
	}
	
	//deposit
	@PostMapping(path="deposit")
	public String deposit(@RequestBody DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());
		return "fund is deposit successfully";
	}
	
	//withdraw
	@PostMapping(path="withdraw")
	public String withdraw(@RequestBody WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());
		return "fund is withdraw successfully";
	}
	
	
}
