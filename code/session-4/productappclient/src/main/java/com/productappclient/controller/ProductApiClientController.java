package com.productappclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productappclient.dto.Product;
import com.productappclient.feignproxy.ProductServiceProxy;

@RestController
@RequestMapping(path="client")
public class ProductApiClientController {

	@Autowired
	private ProductServiceProxy productServiceProxy;
	
	@GetMapping(path = "products/{id}")
	public ResponseEntity<Product> getById(@PathVariable int id) {
		return productServiceProxy.getById(id);
	}
	
	@GetMapping(path = "products")
	public ResponseEntity<List<Product>> getAll() {
		return productServiceProxy.getAll();
	}
	
	
}
