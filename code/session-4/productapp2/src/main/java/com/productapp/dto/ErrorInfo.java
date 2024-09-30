package com.productapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
	private LocalDateTime timestamp;
	private String toContact;
	private String statusCode;
	private String errorMessage;
}
