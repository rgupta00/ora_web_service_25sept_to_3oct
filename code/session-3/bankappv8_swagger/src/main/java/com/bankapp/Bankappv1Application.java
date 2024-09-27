package com.bankapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.repo.Account;
import com.bankapp.repo.AccountRepo;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
@OpenAPIDefinition(
		info = @Info(
				title = "Oracle Internal Bank App",
				description = "Oracle Internal Bank App",
				version = "v1.5",
				contact = @Contact(
						name = "anil",
						email = "anil@ora.com",
						url = "https://www.oracle.com"
				),
				license = @License(
						name = "XYZ 4.0",
						url = "https://www.oracle.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "Link to external doc",
				url = "https://www.oracle.com/swagger-ui.html"
		)
)
@SpringBootApplication
public class Bankappv1Application implements CommandLineRunner{

	
	@Autowired
	private AccountRepo accountRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Bankappv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("SB give u gurantee to run this method asap it started..");
		accountRepo.save(new Account("ekta", BigDecimal.valueOf(1000), "7895645654", "ekta@gmail.com"));
		accountRepo.save(new Account("raj", BigDecimal.valueOf(1000), "7895645654", "raj@gmail.com"));
		
	}

}
