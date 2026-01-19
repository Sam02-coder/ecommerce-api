package com.ecommerce.api.exception;

@SuppressWarnings("serial")
public class AlreadyExistsException extends RuntimeException {
	public AlreadyExistsException(String message) {
		super(message);
	}
}