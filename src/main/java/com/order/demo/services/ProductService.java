package com.order.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.order.demo.dao.ProductDao;
import com.order.demo.entities.Product;

public interface ProductService {
	
	public List<Product> getProduct();

	public Optional<Product> getProduct(long productId);

	public Product addProduct(Product product);

	public void deleteProduct(long productId);

	public void updateProduct(Product product);

	public void saveAll(List<Product> products);

}
