package com.springbootbackendapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackendapp.dto.ApiResponse;
import com.springbootbackendapp.model.Category;
import com.springbootbackendapp.service.CategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/category")
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.createCategory(category), HttpStatus.CREATED);
	}

	@PutMapping("/category/{id}")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable("id") Integer id) {
		return new ResponseEntity<Category>(categoryService.updateCategory(category, id), HttpStatus.OK);
	}

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);
	}

	@DeleteMapping("/category/{id}")
	public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable("id") Integer id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, (id + " Category is deleted")), HttpStatus.OK);
	}

}
