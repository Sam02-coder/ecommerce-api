package com.ecommerce.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.api.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsByMobileOrEmail(Long mobile, String email);

	Optional<User> findByEmail(String email);

}