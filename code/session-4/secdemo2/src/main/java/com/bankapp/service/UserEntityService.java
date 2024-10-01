package com.bankapp.service;

import com.bankapp.repo.UserEntity;

public interface UserEntityService {
    public UserEntity findByUsername(String username);
    public void addUserEntity(UserEntity userEntity);
}
