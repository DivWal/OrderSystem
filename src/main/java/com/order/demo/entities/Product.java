package com.order.demo.entities;

import java.util.List;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

	@Id
	private String id;

	private String product_name;
	private double retail_price;
	private double discounted_price;
	private List<String> image;
	
	

	@Size(min = 10, message = "description should be minumum 10 character")
	private String description;

	private String product_rating;
	private String overall_rating;

	@NotBlank(message = "brandname cannot be empty")
	private String brand;

	public Product(String id, String product_name, double retail_price, double discounted_price, List<String> image,
			@Size(min = 10, message = "description should be minumum 10 character") String description,
			String product_rating, String overall_rating,
			@NotBlank(message = "brandname cannot be empty") String brand) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.retail_price = retail_price;
		this.discounted_price = discounted_price;
		this.image = image;
		this.description = description;
		this.product_rating = product_rating != null ? product_rating : "No rating available";
		this.overall_rating = overall_rating != null ? overall_rating : "No rating available";
		this.brand = brand;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getRetail_price() {
		return retail_price;
	}

	public void setRetail_price(double retail_price) {
		this.retail_price = retail_price;
	}

	public double getDiscounted_price() {
		return discounted_price;
	}

	public void setDiscounted_price(double discounted_price) {
		this.discounted_price = discounted_price;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProduct_rating() {
		return product_rating;
	}

	public void setProduct_rating(String product_rating) {
		this.product_rating = product_rating;
	}

	public String getOverall_rating() {
		return overall_rating;
	}

	public void setOverall_rating(String overall_rating) {
		this.overall_rating = overall_rating;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", retail_price=" + retail_price
				+ ", discounted_price=" + discounted_price + ", image=" + image + ", description=" + description
				+ ", product_rating=" + product_rating + ", overall_rating=" + overall_rating + ", brand=" + brand
				+ "]";
	}


}
