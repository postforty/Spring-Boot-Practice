package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RestTemplateService;

@RestController
@RequestMapping("/api/client")
public class ApiController {
	
	@Autowired
	private RestTemplateService restTemplateService;

	@GetMapping("/hello")
	public String getHello() {
		return restTemplateService.hello();
	}
}
