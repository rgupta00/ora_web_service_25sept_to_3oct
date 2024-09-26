package com.bankapp.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepoMapImpl implements AccountRepo{

	private Map<Integer, Account> map=new HashMap<>();
	
	public AccountRepoMapImpl() {
		map.put(1, new Account(1,"raj",
				BigDecimal.valueOf(1000),"5465454540","raj@gmail.com"));
		map.put(2, new Account(1,"ekta",
				BigDecimal.valueOf(1000),"5465054540","ekta@gmail.com"));
	}
	@Override
	public List<Account> getAll() {
		return new ArrayList<>(map.values());
	}

	@Override
	public void update(Account account) {
		map.put(account.getId(), account);
	}

	@Override
	public Account getById(int id) {
		return map.get(id);
	}

}
