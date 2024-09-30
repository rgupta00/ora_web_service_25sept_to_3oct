package com.productapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//all methods that are declared into this is avaible tom me ..without doing any code

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	public List<Product> findByName(String name);
	
}
