package com.ecommerce.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ecommerce.api.dao.ProductDao;
import com.ecommerce.api.dto.ProductDto;
import com.ecommerce.api.entity.Product;
import com.ecommerce.api.exception.AlreadyExistsException;
import com.ecommerce.api.mapper.MyMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

	private final ProductDao productDao;
	private final MyMapper mapper;

	@Override
	public Map<String, Object> saveProduct(ProductDto productDto) {
		if (productDao.checkIfDuplicate(productDto.getName(), productDto.getCategory()))
			throw new AlreadyExistsException(
					productDto.getName() + " in " + productDto.getCategory() + " Already Exists");
		Product product = mapper.toProductEntity(productDto);
		productDao.saveProduct(product);
		return Map.of("message", product.getName() + " Added Success", "product", mapper.toProductDto(product));
	}

	@Override
	public Map<String, Object> fetchAllProducts() {
		List<Product> products=productDao.getProducts();
		return Map.of("message","Products Found","products",mapper.toProductDtoList(products));
	}

	@Override
	public Map<String, Object> deleteProduct(Long id) {
		Product product=productDao.findById(id);
		productDao.deleteById(id);
		return Map.of("message","Product Deleted Success","product",mapper.toProductDto(product));
	}

	@Override
	public Map<String, Object> updateProduct(Long id, ProductDto productDto) {
		productDao.findById(id);
		Product product=mapper.toProductEntity(productDto);
		product.setId(id);
		return Map.of("message","Product Updated Success","product",mapper.toProductDto(product));
	}

}