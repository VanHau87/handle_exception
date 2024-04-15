package com.hnguyen387.handle_exception.exceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6880890788575752858L;

	public NotFoundException(String message) {
		super(message);
	}
	
}
