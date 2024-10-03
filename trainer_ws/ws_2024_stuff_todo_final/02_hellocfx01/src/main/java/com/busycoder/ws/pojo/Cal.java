package com.busycoder.ws.pojo;

import org.apache.cxf.feature.Features;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@Features(features = "org.apache.cxf.feature.LoggingFeature")
@WebService
public class Cal {
	@WebMethod
	public int add(int a, int b) {
		return a+b;
	}
}
