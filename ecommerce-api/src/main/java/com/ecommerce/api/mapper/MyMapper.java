package com.ecommerce.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.api.dto.ProductDto;
import com.ecommerce.api.dto.UserDto;
import com.ecommerce.api.entity.Product;
import com.ecommerce.api.entity.User;

@Mapper(componentModel = "spring")
public interface MyMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "role", ignore = true)
	@Mapping(target = "active", expression = "java(true)")
	User toUserEntity(UserDto dto);

	@Mapping(target = "createdTime", ignore = true)
	Product toProductEntity(ProductDto productDto);

	ProductDto toProductDto(Product product);

	List<ProductDto> toProductDtoList(List<Product> products);

}