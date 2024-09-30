package com.productappclient.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
	
	private int id;
	@NotNull(message = "product name must not be null")
	private String name;
	
	@NotNull(message = "product price must not be null")
	@Range(min = 100, max = 150000, message = "price must be in range of 100 to 150000")
	private BigDecimal price;
	public Product(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	
}
