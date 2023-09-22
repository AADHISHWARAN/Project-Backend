package com.example.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.project.model.Products;
import com.example.project.service.ProductService;


@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	ProductService userv;

	// post
	@PostMapping
	public Products postProducts(@RequestBody Products u) {
		return userv.saveProducts(u);
	}

	// get
	@GetMapping
	public List<Products> displayProducts() {
		return userv.getProducts();
	}

	//Get by ID
	@GetMapping("/{id}")

	public Products getProductID(@PathVariable Long id) {
		return userv.getProductId(id);
	}

	// update
	@PutMapping("/{id}")
	public Products putProducts(@RequestBody Products u,@PathVariable Long id) {
		return userv.updateProducts(u,id);
	}

	// delete
	@DeleteMapping("{id}")
	public void removeProducts(@PathVariable long id) {
		userv.deleteProducts(id);

	}

}

