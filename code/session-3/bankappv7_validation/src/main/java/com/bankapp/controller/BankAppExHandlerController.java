package com.bankapp.controller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankapp.dto.ErrorDetails;
import com.bankapp.exceptions.BankAccountNotFoundException;

@RestControllerAdvice //the class that will handle the ex
public class BankAppExHandlerController {

	@ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle404(BankAccountNotFoundException ex){
		ErrorDetails details=new ErrorDetails();
		details.setErrorMsg(ex.getMessage());
		details.setTimestamp(LocalDateTime.now());
		details.setStatus(HttpStatus.NOT_FOUND.toString());
		details.setToContact("raj@gmail.com");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}
	
	//MethodArgumentNotValidException
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){
		//i need to get all error message that occured due to failure of validation
		String errorInfo= ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(e-> e.getDefaultMessage())
				.collect(Collectors.joining(" ,"));
				
		ErrorDetails details=new ErrorDetails();
		details.setErrorMsg(errorInfo);
		details.setTimestamp(LocalDateTime.now());
		details.setStatus(HttpStatus.BAD_REQUEST.toString());
		details.setToContact("raj@gmail.com");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
	}
	
}
