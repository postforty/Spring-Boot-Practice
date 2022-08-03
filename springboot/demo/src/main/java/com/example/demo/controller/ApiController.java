package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // �ش� Class�� REST API ó���ϴ� Controller
@RequestMapping("/api") // URI�� �������ִ� Annotation
public class ApiController {
	
	@GetMapping("/hello") // http://localhost:9090/api/hello
	public String hello() {
		return "hello spring boot!";
	}
	
	
}
