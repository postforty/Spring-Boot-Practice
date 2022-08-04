package com.example.demo.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PutRequestDto;

@RestController
@RequestMapping("/api")
public class PutApiController {
	
	@PutMapping("/put")
	public PutRequestDto put(@RequestBody PutRequestDto requestDto) {
		
		System.out.println(requestDto);
		return requestDto;
		
	}

}
