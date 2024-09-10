package com.carlos_spring.tickets_api.categories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Categories,Integer> {

	public List<Categories> findAll();
	
}
