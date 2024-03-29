package com.example.bai01.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.bai01.entity.Product;
import com.example.bai01.entity.User;
import com.example.bai01.reponsitory.OrderReponsitory;
import com.example.bai01.reponsitory.ProductReponsitory;
import com.example.bai01.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ProductReponsitory productReponsitory;

	@GetMapping("/product")
	public List<Product> findAllProduct() {
		List<Product> listProducts = new ArrayList<>();
		listProducts = productService.findAllProducts();
		return listProducts;
	}

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		productService.addProducts(product);
		return product;
	}

	@GetMapping("/orderproduct/{id}/{productId}")
	public ResponseEntity<OrderReponsitory> orderProductByUser(@PathVariable Integer id,
			@PathVariable Integer productId) {
		OrderReponsitory orderReponsitory = new OrderReponsitory();
		String url = "http://localhost:8087/api/v1/user/" + id;
		ResponseEntity<User> reponse = restTemplate.getForEntity(url, User.class);
		Optional<Product> optional = productReponsitory.findById(productId);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			new RuntimeException("User didn't has this ID");
		}
		User user = reponse.getBody();
		orderReponsitory.setUser(user);
		orderReponsitory.setProduct(product);
		return new ResponseEntity<OrderReponsitory>(orderReponsitory, HttpStatus.OK);
	}
}
