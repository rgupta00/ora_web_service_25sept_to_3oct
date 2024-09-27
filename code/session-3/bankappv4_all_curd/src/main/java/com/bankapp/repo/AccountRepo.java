package com.bankapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//using spring data u need to declare the dao layer
//ur job become easy
@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

}
