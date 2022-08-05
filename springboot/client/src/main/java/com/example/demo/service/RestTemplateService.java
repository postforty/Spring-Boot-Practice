package com.example.demo.service;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.Req;
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
	
	public void post() {
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
		ResponseEntity<String> response = restTemplate.postForEntity(uri, req, String.class);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		System.out.println(response.getBody());
		
//		return response.getBody();
		
	}
	
	public UserResponse exchange() {
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
		
		RequestEntity<UserRequest> requestEntity = RequestEntity
				.post(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.header("x-authorization", "abcd")
				.header("custom-header", "fffff")
				.body(req);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);
		return response.getBody();
	}
	
	public Req<UserResponse> genericExchange() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:9090")
				.path("/api/server/user/{userId}/name/{userName}")
				.encode()
				.build()
				.expand("100", "steve")
				.toUri();
		System.out.println(uri);
		
		// http body -> object -> object mapper -> json -> rest template -> http body json
		
		UserRequest userRequset = new UserRequest();
		userRequset.setName("steve");
		userRequset.setAge(40);
		
		Req<UserRequest> req = new Req<>();
		req.setHeader(
				new Req.Header()
		);
		
		req.setResBody(
				userRequset
		);
		
		RequestEntity<Req<UserRequest>> requestEntity = RequestEntity
				.post(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.header("x-authorization", "abcd")
				.header("custom-header", "fffff")
				.body(req);
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Req<UserResponse>> response = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Req<UserResponse>>() {});
		
		return response.getBody();
	}
	

}
