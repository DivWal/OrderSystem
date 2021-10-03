package com.order.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.order.demo.entities.Order;


@Repository
public interface OrderDao extends MongoRepository<Order,String>{
	
	@Query("select * from Order order")
	public List<Order> getAllOrders();
	
	@Query("select order from Order order where order.exchangeDate=:exchangeDate and order.order_status==\"exchanged\"")
	public List<Order> getOrderExchangedondate(@Param("userId") String userId,Date exchangeDate);
}