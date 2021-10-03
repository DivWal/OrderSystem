package com.order.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.order.demo.dao.CustomerDao;
import com.order.demo.dao.OrderDao;
import com.order.demo.entities.Customer;
import com.order.demo.entities.Order;

@Service
@EnableMongoRepositories("com.order.demo.dao.CustomerDao")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerdao;

	@Autowired
	private OrderDao orderdao;

	@Override
	public Order addOrder(Order order, String userId) { // updating customer table and order table
		Customer customerDetails = customerdao.getCustomerDetail(userId);
		customerDetails.getOrders().add(order);
		Order orderToSave = new Order();
		orderToSave.setId(order.getId());
		orderToSave.setCustomer(customerDetails);
		orderToSave.setOrder_Status("booked");
		orderToSave.setPrice(order.getPrice());
		orderToSave.setCreateDate(new Date());
		customerdao.save(customerDetails);
		orderdao.save(orderToSave);
		return order;
	}

	@Override
	public List<Order> getOrders(String userId) {
		Customer customerDetails = customerdao.getCustomerDetail(userId);
		return customerDetails.getOrders();
	}

	@Override
	public String exchangeOrder(String userId, Double askedPrice) {         // verifying if exchnage is possible and updating the table accordingly
		List<Order> Allorder = orderdao.getAllOrders();
		String res = "";
		Order exchangeOrder = new Order();
		Double exchangeOrderPrice = 0.0;
		for (Order order : Allorder) {
			Customer customerDetails = order.getCustomer();
			String cid = customerDetails.getId();
			if (cid.equals(userId)) {
				exchangeOrderPrice = order.getPrice();
				exchangeOrder.setCustomer(customerDetails);
				exchangeOrder.setPrice(order.getPrice());
			}

		}    

		if (askedPrice > exchangeOrderPrice && exchangeOrderPrice != 0.0) {
			res = "Payment Success";
			exchangeOrder.setPaymentStatus("succeded");
			exchangeOrder.setExchangeDate(new Date());
			exchangeOrder.setOrder_Status("exchanged");
		} else {
			res = "Payment failed";
			exchangeOrder.setPaymentStatus("failed");
		}
		orderdao.save(exchangeOrder);
		return res;
	}

	@Override
	public List<Order> getOrderExhanged(String userId, Date exchangedate) {
		return orderdao.getOrderExchangedondate(userId, exchangedate);
	}

}