package com.bankapp.repo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
	private int id;
	private String name;
	private BigDecimal balance;
	private String contactNumber;
	private String email;
}
