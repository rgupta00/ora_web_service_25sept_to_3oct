package com.calapp;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigWs {

    @Bean
    public Bus bus() {
        return new SpringBus();
    }

	
	@Bean
	public EndpointImpl endPoint() {
		EndpointImpl ePImpl= new EndpointImpl(bus(), new Calculator());
		ePImpl.publish("/cal");
		return ePImpl;

	}
}
