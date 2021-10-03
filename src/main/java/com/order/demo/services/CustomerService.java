package com.order.demo.services;

import java.util.Date;
import java.util.List;

import com.order.demo.entities.Order;

public interface CustomerService {


	public Order addOrder(Order order,String userId);

	public List<Order> getOrders(String userId);

	public String exchangeOrder(String userId, Double askedPrice);

	public List<Order> getOrderExhanged(String userId, Date exchangedate);
}

