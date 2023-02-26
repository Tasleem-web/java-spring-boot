package com.springbootbackendapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springbootbackendapp.dto.ApiResponse;
import com.springbootbackendapp.model.Product;
import com.springbootbackendapp.service.FileService;
import com.springbootbackendapp.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	public ProductService productService;

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

	@GetMapping("/getProducts")
	public List<Product> list() {
		return productService.getProducts();
	}

	@PostMapping("/addProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.CREATED);
	}

	@GetMapping("/getProductById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
		return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.CREATED);
	}

	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, Integer id) {
		return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer id) {
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been deleted!."), HttpStatus.OK);
	}

	@PostMapping("/upload/{productId}")
	public ResponseEntity<Product> uploadProductImage(@RequestParam("file") MultipartFile file,
			@PathVariable Integer productId) throws IOException {
		Product product = productService.getProductById(productId);
		System.out.println(product);
		String filename = this.fileService.uploadImage(path, file);
		product.setImageUrl(filename);
		Product updateProduct = this.productService.updateProduct(product, productId);

		return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);
	}

//	get files
	@GetMapping(value = "/file/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("fileName") String imageName, HttpServletResponse response)
			throws IOException {
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}

}
