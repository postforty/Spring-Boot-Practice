package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	// Map은 모든 것을 받을 수 있다.
	@GetMapping(path="query-param")
	public String queryParam(@RequestParam Map<String, String> queryParam) {
		
		StringBuilder sb = new StringBuilder();
		
		queryParam.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("\n");
			
			sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
		});
		
		return sb.toString();
	}
	
	// 명시적으로 받을 수 있다.
	@GetMapping(path="query-param02")
	public String queryParam02(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam int age
	) {

		System.out.println(name);
		System.out.println(email);
		System.out.println(age);
		
		return name+" "+email+" "+age;
	}
}