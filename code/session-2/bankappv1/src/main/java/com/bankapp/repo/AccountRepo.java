package com.bankapp.repo;
import java.util.*;
//SOLID

public interface AccountRepo {
	public List<Account> getAll();
	public void update(Account account);
	public Account getById(int id);
}
