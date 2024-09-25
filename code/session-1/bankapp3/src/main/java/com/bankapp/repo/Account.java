package com.bankapp.repo;

import java.math.BigDecimal;
import java.util.Objects;
//DTO?
public class Account {
	private int id;
	private String name;
	private BigDecimal balance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Account(int id, String name, BigDecimal balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public Account() {}
	@Override
	public int hashCode() {
		return Objects.hash(balance, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(balance, other.balance) && id == other.id && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
	
	
}
