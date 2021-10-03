package com.order.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.demo.entities.Order;
import com.order.demo.services.CustomerService;



@RestController
@RequestMapping("/user")                      
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{userId}/orders")                              // get orders for the given user id 
	public List<Order> getOrders(@PathVariable String userId) {
		try {
		return this.customerService.getOrders(userId);
		}
		catch (Exception e) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	
	@PostMapping("/{userId}/add")                              // add order
	public ResponseEntity addOrder(@RequestBody Order order,@PathVariable String userId) {
		try {
			this.customerService.addOrder(order,userId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@PostMapping("/{userId}/exchange/{askedPrice}")                          // check exchange 
	public String exchangeOrder(@PathVariable String userId,@PathVariable Double askedPrice) {
		return this.customerService.exchangeOrder(userId,askedPrice);
	}
	
	@GetMapping("/{userId}/orders/{exchangedate}")    
	public List<Order> getOrderExhanged(String userId, Date exchangedate) {
		return this.customerService.getOrderExhanged(userId, exchangedate);
	}
	
	
}
