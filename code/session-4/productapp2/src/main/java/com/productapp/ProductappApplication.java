package com.productapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner{

	@Autowired
	private ProductRepo productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepo.save(new Product("Thinkpad laptop", BigDecimal.valueOf(120000)));
		productRepo.save(new Product("laptop mouse", BigDecimal.valueOf(300)));
		
	}

}
