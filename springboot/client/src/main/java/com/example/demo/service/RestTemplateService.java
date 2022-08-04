package com.example.demo.service;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.UserResponse;

@Service
public class RestTemplateService {
	
	// http://localhost/api/server/hello
	// response
	public UserResponse hello() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/server/hello")
				.queryParam("name",	"steve")
				.queryParam("age",	10)
				.encode()
				.build()
				.toUri();
		System.out.println(uri.toString());
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);
		
		System.out.println(result.getStatusCode());
		System.out.println(result.getBody());
		
		return result.getBody();
		
	}

}
