package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
	
	@GetMapping(path = "/hello") // http://localhost:9090/api/get/hello
	public String hello() {
		return "get Hello";
	}
	
	@RequestMapping(path = "/hi", method = RequestMethod.GET) // get, http://localhost:9090/api/get/hi
	public String hi() {
		return "get Hi";
	}
	
	// http://localhost:9090/api/get/path-variable/{name}
	@GetMapping("/path-variable/{id}")
	public String pathVariable(@PathVariable(name = "id") String pathName) {
		
		System.out.println("PathVariable : "+pathName);
		
		return pathName;
	}
	
	// ?key=value&key2=value2
	// http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=40
	
}
