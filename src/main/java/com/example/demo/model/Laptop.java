package com.example.demo.model;

import java.util.Date;

public class Laptop {

	private String brand;
	private double price;
	private Date created_at = new Date();
	
	public String getBrand() {
		return brand;
	}
	
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

}
