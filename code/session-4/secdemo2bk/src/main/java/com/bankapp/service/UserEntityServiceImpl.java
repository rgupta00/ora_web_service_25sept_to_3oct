package com.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.repo.UserEntity;
import com.bankapp.repo.UserRepo;

@Service
@Transactional
public class UserEntityServiceImpl implements UserEntityService{
    private UserRepo userRepo;
    
    @Autowired
    public UserEntityServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void addUserEntity(UserEntity userEntity) {
        userRepo.save(userEntity);
    }
}