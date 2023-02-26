package com.springbootbackendapp.service;

import java.util.List;

import com.springbootbackendapp.model.Product;

public interface ProductService {

	// Create Product
	Product createProduct(Product product);

	// Get all List products
	List<Product> getProducts();

	// Update product
	Product updateProduct(Product product, Integer id);

	// delete product
	void deleteProduct(Integer id);

	// Get product by id
	Product getProductById(Integer id);

}
