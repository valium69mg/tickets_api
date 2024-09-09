package com.carlos_spring.tickets_api.users;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	private UserRepository userRepository;
	//private Logger logger = LoggerFactory.getLogger(getClass());

	
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	// SIGN UP A USER
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		// NEED VALIDATIONS FOR EMAIL, PASSWORD, AND USERNAME
		// SEE IF EMAIL OR USERNAME IS NOT TAKEN
		// SEE IF PASSWORD HAS A MINIMUM LENGTH
		userRepository.save(user);
		return user;
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable Integer id) {
		return userRepository.findById(id);
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

		
}
