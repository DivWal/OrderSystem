package com.order.demo.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.order.demo.entities.Product;

@Repository
public interface ProductDao extends MongoRepository<Product,Long>{
	
	
}
