package com.example.demo.model;

import java.util.Date;

public class Laptop {

	private int id;
	private String brand;
	private double price;
	private Date created_at = new Date();
	
	public Laptop(int id, String brand, double price) {
		this.id = id;
		this.brand = brand;
		this.price = price;
	}

	public Laptop() {}

	public String getBrand() {
		return brand;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Laptop [brand=" + brand + ", created_at=" + created_at + ", id=" + id + ", price=" + price + "]";
	}

}
