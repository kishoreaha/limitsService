package com.product.crudDemo.db1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.crudDemo.db1.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
