package com.example.bai01.reponsitory;

import com.example.bai01.entity.Product;
import com.example.bai01.entity.User;

public class OrderReponsitory {
	private Product product;
	private User user;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}