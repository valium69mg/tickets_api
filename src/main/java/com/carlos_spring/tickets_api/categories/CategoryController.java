package com.carlos_spring.tickets_api.categories;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	private CategoryRepository categoryRepository;
	
	public CategoryController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	@PostMapping("/categories") 
	public Categories createCategory(@RequestBody Categories category) {
		return categoryRepository.save(category);
	}

	@GetMapping("/categories")
	public List<Categories> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Object> getCategoryById(@PathVariable Integer id) {
		if (categoryRepository.findById(id).isPresent()) {
			return new ResponseEntity<>(categoryRepository.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Category not found. ",HttpStatus.BAD_REQUEST);
	}
	
	@PatchMapping("/categories/{id}")
	public ResponseEntity<Object> updateCategoryById(@PathVariable Integer id, @RequestBody Map<String,String> json) {
		String name = json.get("name");
		if (name == null) {
			return new ResponseEntity<>("Parameter not present: name",HttpStatus.BAD_REQUEST);
		}
		if (categoryRepository.findById(id).isPresent()) {
			categoryRepository.findById(id).get().setName(name);
			return new ResponseEntity<>(categoryRepository.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Category not found. ",HttpStatus.BAD_REQUEST);

	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Object> deleteCategoryById(@PathVariable Integer id) {
		if (categoryRepository.findById(id).isPresent()) {
			categoryRepository.delete(categoryRepository.findById(id).get());
			return new ResponseEntity<>(categoryRepository.findById(id).get(),HttpStatus.OK);
		}
		return new ResponseEntity<>("Category not found. ",HttpStatus.BAD_REQUEST);

	}
	
	
	
}
