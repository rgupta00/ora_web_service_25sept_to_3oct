package com.demo;

import org.apache.cxf.feature.Features;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class Calculator {
	@WebMethod
	public int sum(int param1, int param2) {
		return param1 + param2;
	}
}