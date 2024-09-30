package com.productapp.service;

import java.util.List;

import com.productapp.repo.Product;

public interface ProductService {
	public List<Product> getAll();
	public Product getById(int id);
	public List<Product> getByName(String name);
	public Product addProduct(Product product);
	public Product deleteProduct(int id);
	public Product updateProduct(int id, Product product);
}
