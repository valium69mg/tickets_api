package com.carlos_spring.tickets_api.users;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	public Integer id;
	@Email(message = "Must an be email type")
	@NotNull(message = "Must not be null")
	public String email;
	@NotNull(message = "Must not be null")
	@Min(value = 5, message = "Username must contain at least 5 characters")
	@Max(value = 30, message = "Username must not exceed 30 characters")
	public String username;
	@NotNull(message = "Must not be null")
	@Min(value = 5, message = "Password must contain at least 5 characters")
	@Max(value = 30, message = "Password must not exceed 30 characters")
	public String password;
	public LocalDate dateSignUp = LocalDate.now();
	
	
	public User() {
		super();
	}

	public User(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getDateSignUp() {
		return dateSignUp;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDateSignUp(LocalDate dateSignUp) {
		this.dateSignUp = dateSignUp;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", dateSignUp=" + dateSignUp + "]";
	}
	
	
	
}
