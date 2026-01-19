package com.ecommerce.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.Product;
import com.ecommerce.api.exception.DataNotFoundException;
import com.ecommerce.api.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductDao {
	private final ProductRepository productRepository;

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	public boolean checkIfDuplicate(String name, String category) {
		return productRepository.existsByNameAndCategory(name, category);
	}

	public List<Product> getProducts() {
		List<Product> products = productRepository.findAll();
		if (products.isEmpty())
			throw new DataNotFoundException("No Products Present");
		return products;
	}

	public Product findById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("No Product Found with Id :" + id));
	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
}