package com.product.crudDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.crudDemo.db1.entity.Product;
import com.product.crudDemo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/getProductList")
	public List<Product>getProductList(){
		List<Product> products=new ArrayList<Product>();
		//logic to fetch list from database  ---it goes here to service
		products=productService.getProductList();
		return products;
	}
	@PostMapping("/addProduct")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	@GetMapping("/getProductById/{no}")
	public Product getProductById(@PathVariable int no) {
		return productService.getProductById(no).get();
	}
	@DeleteMapping("/deleteProductById/{no}")
	public String deleteProductById(@PathVariable int no) {
		return productService.deleteProductById(no);
	}


}
