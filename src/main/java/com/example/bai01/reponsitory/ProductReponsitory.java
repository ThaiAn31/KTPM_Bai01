package com.example.bai01.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bai01.entity.Product;

public interface ProductReponsitory extends JpaRepository<Product, Integer> {

}