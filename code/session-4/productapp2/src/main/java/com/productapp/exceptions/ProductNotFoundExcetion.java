package com.productapp.exceptions;

public class ProductNotFoundExcetion extends RuntimeException {
	private static final long serialVersionUID = -4975869701033797710L;

	public ProductNotFoundExcetion(String message) {
		super(message);
	}

}
