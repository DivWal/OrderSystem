package com.order.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class OrderDetails { // contains mapping of order to product (product id -> foreign key)

	@Id
	private String id;

	@DBRef(lazy = true)
	private Order order;

	@DBRef(lazy = true)
	private Product product;

	private double totalPrice;

	public OrderDetails(String id, Order order, Product product, double totalPrice) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.totalPrice = totalPrice;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", order=" + order + ", product=" + product + ", totalPrice=" + totalPrice
				+ "]";
	}

}
