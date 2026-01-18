
package com.ecommerce.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain chain(HttpSecurity httpSecurity) {
		return httpSecurity
		.csrf(x->x.disable())
		.authorizeHttpRequests(x->x.anyRequest().authenticated())
		.formLogin(x->x.disable())
		.httpBasic(Customizer.withDefaults())
		.build();
	}
}
