package com.order.demo.controller;

import java.io.InputStream;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.order.demo.entities.Product;
import com.order.demo.services.ProductService;

@RestController
public class HomeController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public List<Product> getProducts() {
		return this.productService.getProduct();
	}

}