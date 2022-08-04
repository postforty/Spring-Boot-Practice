package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.User;

@Controller
public class PageController {
	
	@RequestMapping("/main")
	public String main() {
		return "main.html";
	}

	// ResponseEntity
	
	@ResponseBody
	@GetMapping("/user")
	public User user() {
		User user=new User();
		user.setName("steve");
		user.setAddress("패스트 캠퍼스");
		return user;
	}
}
