package com.productappclient.feignproxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.productappclient.dto.Product;
@FeignClient(name="productServiceProxy", 
    url="http://localhost:8090/productapp")
public interface ProductServiceProxy {
	@GetMapping(path = "products")
	public ResponseEntity<List<Product>> getAll();
	
	@GetMapping(path = "products/{id}")
	public ResponseEntity<Product> getById(@PathVariable int id);
}
