package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.exceptions.ProductNotFoundExcetion;
import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;

@Service
@Transactional //to support acid concept
public class ProductServiceImpl implements ProductService{

	private ProductRepo productRepo;
	
	@Autowired //in new version of spring boot we dont have to apply @Autowire if we have only one ctr
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	//spring boot : modern java (java 8 ie stream processing)
	//https://www.youtube.com/watch?v=5IJG483LIjk&t=2947s&ab_channel=BusyCoderAcademy
	//Optional 
	
	@Override
	public Product getById(int id) {
		return productRepo.findById(id).
		 orElseThrow(()-> new ProductNotFoundExcetion("product with id "+ id+" not found"));
	}

	@Override
	public List<Product> getByName(String name) {
		return productRepo.findByName(name);
	}

	@Override
	public Product addProduct(Product product) {
		productRepo.save(product);
		return product;
	}

	@Override
	public Product deleteProduct(int id) {
		Product productToDelete=getById(id);
		productRepo.delete(productToDelete);
		
		return productToDelete;
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product productToUpdated=getById(id);
		productToUpdated.setPrice(product.getPrice());
		productRepo.save(productToUpdated);
		return productToUpdated;
	}

}
