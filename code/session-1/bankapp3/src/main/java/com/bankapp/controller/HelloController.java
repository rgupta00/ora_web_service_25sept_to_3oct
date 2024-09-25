package com.bankapp.controller;

//ctrl + shift + o

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(path = "hello/{name}")
	public String hello(@PathVariable String name) {
		return "hello champ! "+  name;
	}
	//http://localhost:8090/hello2?name=raja
	@GetMapping(path = "hello2")
	public String hello2(@RequestParam String name) {
		return "hello champ! "+  name;
	}

}