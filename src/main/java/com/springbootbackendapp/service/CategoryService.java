package com.springbootbackendapp.service;

import java.util.List;

import com.springbootbackendapp.model.Category;

public interface CategoryService {

//	create
	Category createCategory(Category category);

// update
	Category updateCategory(Category category, Integer id);

//	delete
	void deleteCategory(Integer id);

//	get all
	List<Category> getAllCategories();

//	get
	Category getCategoryById(Integer id);

}
