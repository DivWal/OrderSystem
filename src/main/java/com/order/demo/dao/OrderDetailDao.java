package com.order.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
import com.order.demo.entities.OrderDetails;


@Repository
public interface OrderDetailDao extends MongoRepository<OrderDetails,Long>{
	
	
}

