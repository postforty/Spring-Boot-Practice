package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PutRequestDto;

@RestController
@RequestMapping("/api")
public class PutApiController {
	
	@PutMapping("/put/{userId}")
	public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable(name="userId") Long id) {
		
		System.out.println(id);
		return requestDto;
		
	}

}
