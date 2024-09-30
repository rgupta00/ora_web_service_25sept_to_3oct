package com.demo;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class Calculator {
	@WebMethod
	public int sum(int param1, int param2) {
		return param1 + param2;
	}
}