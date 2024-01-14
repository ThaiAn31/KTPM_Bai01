package com.example.bai01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bai01.entity.Product;
import com.example.bai01.reponsitory.ProductReponsitory;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductReponsitory productReponsitory;

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<>();
		products = productReponsitory.findAll();
		return products;
	}

	@Override
	public void addProducts(Product product) {
		productReponsitory.save(product);

	}
}
