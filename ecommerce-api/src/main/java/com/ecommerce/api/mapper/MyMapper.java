package com.ecommerce.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ecommerce.api.dto.UserDto;
import com.ecommerce.api.entity.User;





@Mapper(componentModel = "spring")
public interface MyMapper {
	
	@Mapping(target = "id",ignore = true)
	@Mapping(target = "role",ignore = true)
	@Mapping(target = "active",expression = "java(true)")
	User toUserEntity(UserDto dto);

}