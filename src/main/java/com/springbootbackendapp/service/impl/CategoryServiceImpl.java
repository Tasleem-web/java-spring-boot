package com.springbootbackendapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.springbootbackendapp.exception.ResourceNotFoundException;
import com.springbootbackendapp.model.Category;
import com.springbootbackendapp.model.Employee;
import com.springbootbackendapp.repository.CategoryRepository;
import com.springbootbackendapp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category, Integer id) {
		Category existingCategory = categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", id));

		existingCategory.setCategoryDescription(category.getCategoryDescription());
		existingCategory.setCategoryTitle(category.getCategoryTitle());
		categoryRepository.save(existingCategory);
		return existingCategory;
	}

	@Override
	public void deleteCategory(Integer id) {
		categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", id));
		categoryRepository.deleteById(id);

	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", id));
	}

}
