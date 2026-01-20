package com.ecommerce.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ecommerce.api.dao.ProductDao;
import com.ecommerce.api.entity.Product;
import com.ecommerce.api.mapper.MyMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final MyMapper mapper;
	private final ProductDao productDao;

	@Override
	public Map<String, Object> getProducts(int page, int size, String sort, boolean desc, String name, String category,
			double lower, double higher) {
		List<Product> products = productDao.getProducts(page, size, sort, desc, name, category, lower, higher);
		return Map.of("message", "Products Found", "products", mapper.toProductDtoList(products));
	}

}