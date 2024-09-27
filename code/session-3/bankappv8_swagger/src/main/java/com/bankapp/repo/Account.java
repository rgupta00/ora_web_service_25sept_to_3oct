package com.bankapp.repo;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@NotNull(message = "{account.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{account.name.invalid}")
	private String name;
	
	@NotNull(message = "{account.balance.absent}")
	@Range(min = 100, max = 100000, message = "{account.balance.invalid}")
	private BigDecimal balance;
	
	@NotNull(message = "{account.phone.absent}")
	@Pattern(regexp = "[789][0-9]{9}", message = "{account.phone.invalid}")
	private String contactNumber;
	
	@Email(message = "{account.email.invalid}")
	@NotNull(message = "{account.email.absent}")
	private String email;
	
	public Account(String name, BigDecimal balance, String contactNumber, String email) {
		super();
		this.name = name;
		this.balance = balance;
		this.contactNumber = contactNumber;
		this.email = email;
	}
	
	
}












