package com.order.demo.entities;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {

	
	@Id
	private String id;

	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;

	@NotBlank(message = "name cannot be empty")
	private String name;

	private List<Order> orders;
	
	private String role;                           //admin  or user
	
	public Customer(String id, @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") String email,
			@NotBlank(message = "name cannot be empty") String name, List<Order> orders,String role) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.role=role;
		
		this.orders = orders;
	}

	public Customer() {
		super();
	}

	public String getId() {
		return id;
	}

	public String getrole() {
		return role;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", name=" + name + ", orders=" + orders + "]";
	}

}
