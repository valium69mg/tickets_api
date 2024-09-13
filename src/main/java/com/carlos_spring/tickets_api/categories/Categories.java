package com.carlos_spring.tickets_api.categories;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Categories {
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull(message = "Name must not be null")
	@Size(min = 3,max = 30, message = "Categorie's name length must be between 3 and 30 characters")
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

	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
