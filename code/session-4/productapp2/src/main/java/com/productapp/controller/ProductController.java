package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//get all
	@GetMapping(path = "products")
	public ResponseEntity<List<Product>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
	}
	
	//get by id
	@GetMapping(path = "products/{id}")
	public ResponseEntity<Product> getById(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
	}
	
	//@RequestBody annotation trigger parser to convert json to java object
	//add 
	@PostMapping(path = "products")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody  Product product) {
		 Product productAdded = productService.addProduct(product);
		 return ResponseEntity.status(HttpStatus.CREATED).body(productAdded);
	}
	
	//update
	@PutMapping(path = "products/{id}")
	public ResponseEntity<Product> updateProduct( @PathVariable int id,@Valid  @RequestBody  Product product) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(productService.updateProduct(id, product));
	}
	
	//delete
	@DeleteMapping(path = "products/{id}")
	public ResponseEntity<Void> deletetById(@PathVariable int id) {
		 productService.deleteProduct(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
