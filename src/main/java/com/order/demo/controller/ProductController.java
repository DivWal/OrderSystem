package com.order.demo.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.demo.entities.Product;
import com.order.demo.services.ProductService;

@RestController
@RequestMapping("/admin/products")                       // Basic CRUD operations restricted to only Admin
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("")
	public List<Product> getProducts() {
		return this.productService.getProduct();
	}

	@GetMapping("/{productId}")                           //get Product 
	public Optional<Product> getProduct(@PathVariable String productId) {
		return this.productService.getProduct(Long.parseLong(productId));
	}

	@PostMapping("")                                       //add new Product 
	public ResponseEntity addProduct(@RequestBody Product product) {
		try {
			this.productService.addProduct(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("")                                          //update new Product 
	public ResponseEntity updateProduct(@RequestBody Product product) {
		try {
			this.productService.updateProduct(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{productId}")                             //delte new Product 
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId) {
		try {
			this.productService.deleteProduct(Long.parseLong(productId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
