package com.bankapp.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepoMapImpl implements AccountRepo{
	private Map<Integer, Account> map=new HashMap<>();
	
	public AccountRepoMapImpl() {
		map.put(1, new Account(1, "raj",BigDecimal.valueOf(1000.00)));
		map.put(2, new Account(2, "ekta",BigDecimal.valueOf(1000.00)));
	}
	
	@Override
	public List<Account> getAll() {
		System.out.println("it is a map implementaion");
		return new ArrayList<>(map.values());
	}

}
