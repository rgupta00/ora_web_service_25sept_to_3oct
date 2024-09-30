package com.productappclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients("com.productappclient.feignproxy")
@SpringBootApplication
public class ProductappclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappclientApplication.class, args);
	}

	@Bean //what is resttemplate : abs on how to invoke a remote rest api in spring boot
	 RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
