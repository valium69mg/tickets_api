package com.carlos_spring.tickets_api.artists;

import java.time.LocalDate;

public class ArtistErrorDetails {
	
	private LocalDate date;
	private String message;
	private String description;
	
	
	public ArtistErrorDetails(LocalDate date, String message, String description) {
		super();
		this.date = date;
		this.message = message;
		this.description = description;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
