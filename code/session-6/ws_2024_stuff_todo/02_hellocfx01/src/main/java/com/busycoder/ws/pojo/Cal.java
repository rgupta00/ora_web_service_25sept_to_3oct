package com.busycoder.ws.pojo;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class Cal {
	
	@WebMethod
	public int add(int a, int b) {
		return a+b;
	}
}
