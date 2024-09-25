package com.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*
 * @Configuration
@ComponentScan(basePackages = {"com.bankapp"})
 */
@SpringBootApplication
public class BankappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

}
