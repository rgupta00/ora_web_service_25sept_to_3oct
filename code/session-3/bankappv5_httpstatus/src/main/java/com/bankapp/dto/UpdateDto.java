package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UpdateDto {
	private String contactNumber;
	private String email;
}
