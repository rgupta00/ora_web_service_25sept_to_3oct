package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;

@RestController
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//get all
	@GetMapping(path = "products")
	public List<Product> getAll(){
		return productService.getAll();
	}
	
	//get by id
	@GetMapping(path = "products/{id}")
	public Product getById(@PathVariable int id) {
		return productService.getById(id);
	}
	
	//@RequestBody annotation trigger parser to convert json to java object
	//add 
	@PostMapping(path = "products")
	public Product addProduct(@RequestBody  Product product) {
		return productService.addProduct(product);
	}
	
	//update
	@PutMapping(path = "products/{id}")
	public Product updateProduct( @PathVariable int id, @RequestBody  Product product) {
		return productService.updateProduct(id, product);
	}
	
	//delete
	@DeleteMapping(path = "products/{id}")
	public void deletetById(@PathVariable int id) {
		 productService.deleteProduct(id);
	}
	

}
