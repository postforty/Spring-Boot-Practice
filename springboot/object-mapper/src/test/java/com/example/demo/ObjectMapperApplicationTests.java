package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class ObjectMapperApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("------------");
		
		// Text JSON -> Object
		// Object -> Text JSON
		
		// controller req json(text) -> object
		// response object -> json(text)
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		// object -> text
		// object mapper get method를 활용한다.
		User user = new User("steve", 40);
		String text = objectMapper.writeValueAsString(user);
		System.out.println(text);
		
		// text -> object
		// object mapper는 default 생성자를 필요로 한다.
		Object objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser);
	}

}
