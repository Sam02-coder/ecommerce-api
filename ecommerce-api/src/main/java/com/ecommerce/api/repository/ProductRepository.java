package com.ecommerce.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.api.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	boolean existsByNameAndCategory(String name, String category);

	Page<Product> findByNameContainingAndCategoryContainingAndPriceBetween(String name, String category, double lower,
			double higher, PageRequest of);

}