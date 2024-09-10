package com.carlos_spring.tickets_api.artists;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
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
