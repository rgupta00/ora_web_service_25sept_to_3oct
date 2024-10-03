package com.busycoder.ws.soap.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busycoder.ws.soap.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
