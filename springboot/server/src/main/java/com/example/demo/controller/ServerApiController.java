package com.example.demo.controller;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.Req;
import com.example.demo.dto.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {
	
	@GetMapping("/naver")
	public String naver() {
		
		URI uri = UriComponentsBuilder
				.fromUriString("https://openapi.naver.com")
				.path("/v1/search/blog.json")
				.queryParam("query", "°¥ºñÁý")
				.queryParam("display", 10)
				.queryParam("start", 1)
				.encode(Charset.forName("UTF-8"))
				.build()
				.toUri();
		
		log.info("uri : {}", uri);
		
		RestTemplate restTemplate = new RestTemplate();
		
		RequestEntity<Void> req = RequestEntity
				.get(uri)
				.header("X-Naver-Client-Id","EitF_WdGGp8oMpYq1D8N")
				.header("X-Naver-Client-Secret","vfb1ckAOGn")
				.build();
				
		ResponseEntity<String> result = restTemplate.exchange(req, String.class);
		
		return result.getBody();
	}
	
	@GetMapping("/hello")
	public User hello(@RequestParam String name, @RequestParam int age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return user;
	}
	
	@PostMapping("/user/{userId}/name/{userName}")
	public Req<User> post(
//			HttpEntity<String> entity,
			 @RequestBody Req<User> user,
			@PathVariable int userId,
			@PathVariable String userName,
			@RequestHeader("x-authorization") String authorization,
			@RequestHeader("custom-header") String customHeader
	){
//		log.info("req : {}", entity.getBody());
		log.info("userId : {}, userName : {}", userId, userName);
		log.info("authorization : {}, custom : {}", authorization, customHeader);
		 log.info("client req : {}", user);
		
		Req<User> response = new Req<>();
		response.setHeader(
				new Req.Header()
		);
		response.setResBody(user.getResBody());
//		response.setBody(null);
		return response;
	}
}
