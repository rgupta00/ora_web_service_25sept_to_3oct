package com.busycoder.ws.soap;


import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.xml.ws.Endpoint;


@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	
	@Autowired
	private ProductWs productService;

	@Bean
	Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, productService);
		endpoint.publish("/products");
		return endpoint;

	}

}
