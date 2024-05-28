package com.product.crudDemo;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.product.crudDemo.db1.entity.Product;
import com.product.crudDemo.db1.repository.ProductRepository;
import com.product.crudDemo.service.ProductService;
@RunWith(SpringRunner.class)
@SpringBootTest
class CrudDemoApplicationTests {
@Autowired
	private ProductService service;
@MockBean
private ProductRepository repository;
@Test
public void getAllProductsTest() {
	when(repository.findAll()).thenReturn(Stream.of(new Product(10,"Realme","Mobile",100),new Product(12,"Redme","Mobile",200)).collect(Collectors.toList()));
	assertEquals(2,service.getProductList().size());
}
@Test
public void getProductByIdTest() {
	Product expectedProduct = new Product(1, "Sample Product", "Sample Type", 100);
    
    // Mock the behavior of the productRepository.findById method to return the sample product when called with any integer argument
    when(repository.findById(anyInt())).thenReturn(Optional.of(expectedProduct));
    
    // Call the getProductById method with any integer argument
    Optional<Product> actualProduct = service.getProductById(1);
    
    // Assert that the returned optional contains the expected product
    assertTrue(actualProduct.isPresent()); // Check if optional is not empty
    assertEquals(expectedProduct, actualProduct.get()); // Check if the product inside the optional is as expected
	
}
@Test
public void saveProductTest() {
	Product product=new Product(1, "Realme", "Mobile", 100);
	when(repository.save(product)).thenReturn(product);
	assertEquals(product, service.saveProduct(product));
}
@Test
public void deleteProductTest() {
	int id=1;
	service.deleteProductById(1);
	 verify(repository, times(1)).deleteById(id);
	
}
	@Test
	void contextLoads() {
	}

}
