package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.api.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

	boolean existsByNameAndCategory(String name, String category);

}