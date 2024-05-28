package com.product.crudDemo.db1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	private int no;
	private String name;
	private String description;
	private int price;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int no, String name, String description, int price) {
		super();
		this.no = no;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	

}
