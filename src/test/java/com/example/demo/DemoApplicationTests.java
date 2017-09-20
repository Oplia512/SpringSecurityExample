package com.example.demo;

import com.example.demo.service.TokenHandler;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;


public class DemoApplicationTests {

	@Test
	public void generateToken() {

		TokenHandler tokenHandler = new TokenHandler();
		String token = tokenHandler.generateAccessToken(new ObjectId("59c234ccbf1a5520a438a61d"), LocalDateTime.now().plusDays(14));
		System.out.println(token);
	}

}
