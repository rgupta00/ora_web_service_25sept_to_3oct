package com.demo;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

//how to expose this app as web service?
@SOAPBinding(style = Style.RPC)
@WebService(name="myCalPort",serviceName = "myCalService", targetNamespace = "https://www.oracle.com/")
public class Calculator {
	
	@WebMethod(operationName = "sumOperation")
	@WebResult(name="addResult")
	public int sum(@WebParam(name="x")  int param1, @WebParam(name="y") int param2) {
		return param1 + param2;
	}
}