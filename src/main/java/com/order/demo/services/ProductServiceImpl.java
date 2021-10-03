package com.order.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.order.demo.dao.ProductDao;
import com.order.demo.entities.Product;

@Service
@EnableMongoRepositories("com.order.demo.dao.ProductDao")
public class ProductServiceImpl implements ProductService {


	@Autowired
	private ProductDao productdao;

	public ProductServiceImpl() {
	}
	
	
	@Override
	public List<Product> getProduct() {
		return productdao.findAll();
	}

	@Override
	public Optional<Product> getProduct(long productId) {
		return productdao.findById(productId);
	}

	@Override
	public Product addProduct(Product product) {
		productdao.save(product);
		return product;
	}

	@Override
	public void deleteProduct(long productId) {
		productdao.deleteById(productId);
	}

	@Override
	public void updateProduct(Product product) {
		productdao.save(product);
	}


	@Override
	public void saveAll(List<Product> products) {
		for(Product product:products)
		{
		  productdao.save(product);
		}
		
	}

}
