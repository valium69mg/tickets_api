package com.carlos_spring.tickets_api.artists;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Integer id;
	@NotNull(message = "Artist's name must not be null")
	@Size(min=3,max=30, message = "Artist's name length must be between 3 and 30 characters")
	private String name;
	@NotNull(message = "Image's path name must not be null")
	private String image;
	
	public Artist() {
		super();
	}
	public Artist(String name, String image) {
		super();
		this.name = name;
		this.image = image;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", image=" + image + "]";
	}	
	
}
