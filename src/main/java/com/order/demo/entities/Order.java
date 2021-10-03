package com.order.demo.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order") // Db (order) -> containing orders (userid -> foreign key)[Customer Table]
public class Order {

	@Id
	private String id;

	private String order_status;    // staus of the order ->  ,exchanged, ordered, pending
	
	private String payment_status;   // status  of the payment

	private Date createDate;
	
	private Double price;

	private Date exchangeDate;

	@DBRef(lazy = true)
	private Customer customer;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String id, String status,String paymentStatus, Date createDate, Date exchangeDate, Double price,Customer customer) {
		super();
		this.id = id;
		this.order_status = status;
		this.payment_status=paymentStatus;
		this.createDate = createDate;
		this.exchangeDate = exchangeDate;
		this.price=price;
		this.customer = customer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrder_Status() {
		return order_status;
	}

	public void setOrder_Status(String status) {
		this.order_status = status;
	}
	
	public String getPaymentStatus() {
		return payment_status;
	}

	public void setPaymentStatus(String status) {
		this.payment_status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", order_status=" + order_status + ", payment_status=" + payment_status
				+ ", createDate=" + createDate + ", exchangeDate=" + exchangeDate + ", customer=" + customer + "]";
	}

	
}
