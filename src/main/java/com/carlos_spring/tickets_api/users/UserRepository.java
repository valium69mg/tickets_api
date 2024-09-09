package com.carlos_spring.tickets_api.users;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	public Optional<User> findById(Integer id);
	
	public User findByEmailAndUsername(String email, String username);
	
	public User deleteByEmailAndUsername(String email, String username);
}
