package com.product.crudDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.crudDemo.db1.entity.Product;
import com.product.crudDemo.db1.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	public List<Product> getProductList(){
		//here we r calling method of repository(jpa repo)has inbuilt methods to fetch the productlist
		//for that we have inject the repository 
		List<Product> products=productRepository.findAll();
		//System.out.println("get data from db:"+products); for testing
		return products;
	}
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	public Optional<Product> getProductById(int no) {
		return productRepository.findById(no);
	}
	public String deleteProductById(int no) {
		String result;
		try {
			productRepository.deleteById(no);
			result="Product deleted successfully";
		}
		catch(Exception e) {
			result="product with id is not deleted";
		}
		return result; 
	}

}
