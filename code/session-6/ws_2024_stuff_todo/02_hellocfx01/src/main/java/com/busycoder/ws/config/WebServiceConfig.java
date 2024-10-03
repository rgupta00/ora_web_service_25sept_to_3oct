package com.busycoder.ws.config;

import jakarta.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.busycoder.ws.pojo.Cal;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	
	@Bean
	Endpoint endpoint() {
		Endpoint endpoint=new EndpointImpl(bus, new Cal());
		endpoint.publish("/cal");
		return endpoint;
	}
	
}
