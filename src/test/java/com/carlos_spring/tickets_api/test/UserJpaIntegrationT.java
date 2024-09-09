package com.carlos_spring.tickets_api.test;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import com.carlos_spring.tickets_api.users.User;
import com.carlos_spring.tickets_api.users.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserJpaIntegrationT {

	private String username = "test";
	private String email = "test@gmail.com";
	private String password = "testpassword";
	
	@Autowired private UserRepository userTestRepository;
	
	@Test
	public void createUserTest() {
		// save user
		User testUser = userTestRepository.save(new User(email,username,password));
		// RETRIEVE USER IF IT IS SAVED 
		User databaseUser = userTestRepository.findByEmailAndUsername(email,username);
		// CHECK IF THE USER IS IN THE DATABASE
		Assertions.assertTrue(databaseUser.equals(testUser));
		
	}
	
}
