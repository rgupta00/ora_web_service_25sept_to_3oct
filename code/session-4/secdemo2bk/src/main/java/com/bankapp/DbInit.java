package com.bankapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bankapp.repo.UserEntity;
import com.bankapp.service.UserEntityService;

@Component
public class DbInit implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserEntityService entityService;
	

	@Override
	public void run(String... args) throws Exception {
		entityService.addUserEntity(new UserEntity("raj",
				passwordEncoder.encode("raj123"), List.of("ROLE_MGR","ROLE_ADMIN")));
		
		entityService.addUserEntity(new UserEntity("ekta",
				passwordEncoder.encode("ekta123"), List.of("ROLE_MGR")));
		
	}

}
