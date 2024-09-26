package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ora")
//@Controller //jsp based application
//@ResponseBody
public class HelloController {

	
	//http://localhost:8090/bankapp/ora/hello/foo/ravi/delhi
	@GetMapping(path = "/hello/foo/{uname}/{city}")
	public String hello(@PathVariable(name="uname") String name,  @PathVariable(name="city") String town) {
		return "hello to spring boot "+ name+" "+town;
	}
	//RequestParam
	//http://localhost:8090/bankapp/ora?name=raja&city=kochi
	@GetMapping
	public String hello2(@RequestParam(name="name")String name, 
			@RequestParam(name="city", required = false, defaultValue = "Kochi") String city) {
		return "hi "+ name+" "+ city;
	}
}
