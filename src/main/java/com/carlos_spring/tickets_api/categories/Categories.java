package com.carlos_spring.tickets_api.categories;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Categories {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	public Categories(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Categories() {
		super();
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
	
	
	
}
