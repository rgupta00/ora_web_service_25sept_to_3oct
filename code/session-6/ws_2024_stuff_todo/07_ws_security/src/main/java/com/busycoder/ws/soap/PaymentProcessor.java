package com.busycoder.ws.soap;

import com.busycoder.ws.soap.dto.PaymentProcessorRequest;
import com.busycoder.ws.soap.dto.PaymentProcessorResponse;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(name = "PaymentProcessor")
public interface PaymentProcessor {

	@WebMethod
	public @WebResult(name = "response") PaymentProcessorResponse processPayment(
			@WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);
}
