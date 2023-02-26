package com.springbootbackendapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springbootbackendapp.exception.ResourceNotFoundException;
import com.springbootbackendapp.model.Product;
import com.springbootbackendapp.repository.ProductRepository;
import com.springbootbackendapp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductRepository productRepository;

	@Value("${project.image}")
	private String path;

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product, Integer id) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Proudct", "product id", id));

		existingProduct.setTitle(product.getTitle());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCreateDate(product.getCreateDate());
		existingProduct.setModifyDate(product.getModifyDate());
		productRepository.save(existingProduct);
		return existingProduct;
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proudct", "product id", id));
		productRepository.deleteById(id);
	}

	@Override
	public Product getProductById(Integer id) {
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Proudct", "product id", id));

		return existingProduct;
	}

}
