package com.demo;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.Use;

@WebService(name="calapp", serviceName = "myCalService",
		portName = "myCalPort", targetNamespace = "http://localhost:8080/busycoder")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL, 
	parameterStyle=ParameterStyle.WRAPPED)
public class Calculator {
	
	@WebMethod(operationName = "addMethod")
	@WebResult(name="addResult")
	public int sum(@WebParam(name="x") int param1,@WebParam(name="y") int param2) {
		return param1 + param2;
	}
}