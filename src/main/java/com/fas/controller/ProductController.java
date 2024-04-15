package com.fas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fas.entity.Product;
import com.fas.service.ProductService;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

	public ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@GetMapping
	public ResponseEntity<List<Product>> fetchAllProducts() {
		return productService.fetchAllProducts();
	}

	@GetMapping(value = "/code")
	public ResponseEntity<Product> fetchProductByCode(@RequestParam(name = "code") int code) {
		return productService.fetchProductByCode(code);
	}

	@PutMapping(value = "/code/price")
	public ResponseEntity<String> updatePrice(@RequestParam(name = "productPrice") double orderPrice,
			@RequestParam(name = "code") int code) {
		return productService.updatePrice(orderPrice, code);
	}

	@DeleteMapping(value = "/code")
	public ResponseEntity<String> deleteProductByCode(@RequestParam(name = "code") int code) {
		return productService.deleteProductByCode(code);
	}

	@GetMapping(value = "/price")
	public ResponseEntity<List<Product>> fetchByPriceRange(@RequestParam(name = "lprice") double lprice,
			@RequestParam(name = "uprice") double uprice) {
		return productService.fetchByPriceRange(lprice, uprice);
	}

	@GetMapping(value = "/category")
	public ResponseEntity<List<Product>> fetchByCategory(@RequestParam(name = "category") String category) {
		return productService.fetchByCategory(category);
	}
}