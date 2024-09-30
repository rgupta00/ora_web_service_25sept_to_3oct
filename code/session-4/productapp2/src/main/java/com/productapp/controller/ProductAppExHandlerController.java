package com.productapp.controller;
//it will handle all ex of my application

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.dto.ErrorInfo;
import com.productapp.exceptions.ProductNotFoundExcetion;

@RestControllerAdvice
public class ProductAppExHandlerController {

	@Value("${person.contact}")
	private String contactEmail;
	
	//ProductNotFoundExcetion
	@ExceptionHandler(ProductNotFoundExcetion.class)
	public ResponseEntity<ErrorInfo> handle404(ProductNotFoundExcetion ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setTimestamp(LocalDateTime.now());
		errorInfo.setStatusCode(HttpStatus.NOT_FOUND.toString());
		errorInfo.setToContact(contactEmail);
		errorInfo.setErrorMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}
	//MethodArgumentNotValidException
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> handle400(MethodArgumentNotValidException ex){
		//i need to extract out the error information
		String errorInfoValue=ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(e->e.getDefaultMessage())
				.collect(Collectors.joining(" ,"));
		
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setTimestamp(LocalDateTime.now());
		errorInfo.setStatusCode(HttpStatus.BAD_REQUEST.toString());
		errorInfo.setToContact(contactEmail);
		errorInfo.setErrorMessage(errorInfoValue);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
	}
}
