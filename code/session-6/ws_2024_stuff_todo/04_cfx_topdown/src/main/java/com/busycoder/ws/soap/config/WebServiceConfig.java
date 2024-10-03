package com.busycoder.ws.soap.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.busycoder.ws.soap.impl.CustomerOrdersPortTypeImpl;

import jakarta.xml.ws.Endpoint;


@Configuration
public class WebServiceConfig {
	@Autowired
	private Bus bus;
	
	@Bean
	Endpoint endpoint() {
		Endpoint endpoint=new EndpointImpl(bus, new CustomerOrdersPortTypeImpl());
		endpoint.publish("/customerorderservice");
		return endpoint;
	}
}
