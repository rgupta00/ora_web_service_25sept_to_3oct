package com.demo;
import jakarta.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigWs {

	@Autowired
	private Bus bus;
	
	@Bean
	 Endpoint endPoint() {
		EndpointImpl ePImpl= new EndpointImpl(bus, new Calculator());
		ePImpl.publish("/cal");
		return ePImpl;

	}
}