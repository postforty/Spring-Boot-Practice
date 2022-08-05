package com.example.demo.service;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.UserRequest;
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
	
	public UserResponse post() {
		// http://localhost:9090/api/server/user/{userId}/{userName}
		
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/server/user/{userId}/name/{userName}")
				.encode()
				.build()
				.expand("100", "steve")
				.toUri();
		System.out.println(uri);
		
		// http body -> object -> object mapper -> json -> rest template -> http body json
		UserRequest req = new UserRequest();
		req.setName("steve");
		req.setAge(40);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		System.out.println(response.getBody());
		
		return response.getBody();
		
	}

}
