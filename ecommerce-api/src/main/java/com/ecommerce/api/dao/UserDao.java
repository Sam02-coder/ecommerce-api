package com.ecommerce.api.dao;

import org.springframework.stereotype.Repository;

import com.ecommerce.api.entity.User;
import com.ecommerce.api.exception.DataNotFoundException;
import com.ecommerce.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserDao {

	private final UserRepository userRepository;

	public boolean checkIfExists(Long mobile, String email) {
		return userRepository.existsByMobileOrEmail(mobile, email);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(()->new DataNotFoundException("Invalid Email"));
	}

	public void saveAdmin(User admin) {
		admin.setRole("ADMIN");
		userRepository.save(admin);
	}
}