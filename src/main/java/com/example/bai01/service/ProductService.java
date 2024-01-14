package com.example.bai01.service;

import java.util.List;

import com.example.bai01.entity.Product;

public interface ProductService {
	public List<Product> findAllProducts();

	public void addProducts(Product product);
}
