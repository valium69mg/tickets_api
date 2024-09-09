package com.carlos_spring.tickets_api.users;

import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	
	// ONLY WITH API AUTH KEY
	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable Integer id) {
		return userRepository.findById(id);
	}
	
	@PatchMapping(value = "/user/{id}")
	public ResponseEntity<Object> updateUsernameOrPassword(@PathVariable Integer id, @RequestBody Map<String, String> json) {
		// extract parameters from req
		String newUsername = json.get("username");
		String newPassword = json.get("password");
		
		// find user
		Optional<User> userToUpdate = userRepository.findById(id);
		
		// a user_id matches path variable id and username and password are present
		if (userToUpdate.isPresent() & newUsername != null) {
			User userWithNewUsername = userToUpdate.get();
			userWithNewUsername.setUsername(newUsername);
			userRepository.save(userWithNewUsername);
		}
		if (userToUpdate.isPresent() & newPassword != null) {
			User userWithNewPassword = userToUpdate.get();
			userWithNewPassword.setPassword(newPassword);
			userRepository.save(userWithNewPassword);
		}
		
		return new ResponseEntity<>(userRepository.findById(id),HttpStatus.ACCEPTED);
		
	}
	
	
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

		
}
