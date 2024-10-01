package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.repo.UserEntity;
import com.bankapp.service.UserEntityService;
@Service
public class DetailsService implements UserDetailsService{

	@Autowired
	private UserEntityService entityService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=entityService.findByUsername(username);
		return new SecUser(userEntity);
	}

}
