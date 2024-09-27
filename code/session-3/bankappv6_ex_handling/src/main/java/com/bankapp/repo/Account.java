package com.bankapp.repo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//JPA is based on annotation

@Entity
@Table(name = "account_table")
public class Account {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private BigDecimal balance;
	private String contactNumber;
	private String email;
	
	public Account(String name, BigDecimal balance, String contactNumber, String email) {
		super();
		this.name = name;
		this.balance = balance;
		this.contactNumber = contactNumber;
		this.email = email;
	}
	
	
}












