package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.repo.UserEntity;
import com.bankapp.service.UserEntityService;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserEntityService userEntityService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=userEntityService.findByUsername(username);
		if(userEntity==null)
			throw new UsernameNotFoundException("user not found");
		
		return new SecUser(userEntity);
	}

}
