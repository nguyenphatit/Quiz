package com.spring.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.service.AccountS;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {
	@Autowired AccountS s;
	
	/**
	 * testCheckEmail
	 */
	@Test
	public void testCheckEmail(){
		assertEquals(true, s.checkEmail("ttlang162@gmail.com"));
		assertEquals(false, s.checkEmail("ttlang16@gmail.com"));
	}
	
	/**
	 * test checkEmailAndPassword()
	 * 
	 */
	@Test
	public void testCheckEmailAndPassword(){
		assertEquals(true, s.checkEmailAndPassword("ttlang162@gmail.com", "1234"));
		assertEquals(false, s.checkEmailAndPassword("ttlang162@gmail.com", "12345"));
		
	}
	
	/**
	 * Test getAccountByEmail
	 */
	@Test
	public void testGetAccountByEmail(){
		System.out.println(s.getAccountByEmail("ttlang162@gmail.com"));
	}
}
