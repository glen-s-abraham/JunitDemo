package com.glen.JunitDemo;

import org.springframework.stereotype.Component;

@Component
public class Product {
	Long id;
	String name;
	Double qty;
	Double price;
	public Product(Long id, String name, Double qty, Double price) {
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	public Product() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}
	
}
