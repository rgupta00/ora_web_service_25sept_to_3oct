package com.bankapp.service;

import java.util.List;
import com.bankapp.repo.Account;

//SL=Business logic
public interface AccountService {
	public List<Account> getAll();
}
