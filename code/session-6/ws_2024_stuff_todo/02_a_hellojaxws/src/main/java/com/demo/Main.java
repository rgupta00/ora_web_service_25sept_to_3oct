package com.demo;

import jakarta.xml.ws.Endpoint;

public class Main {

	public static void main(String[] args) {
			//http://localhost:8080/hello-ws/CalculatorService
		Endpoint.publish("http://localhost:8080/hello-ws/CalculatorService",
				new Calculator());
		
		 System.out.println("published");
	}
}
