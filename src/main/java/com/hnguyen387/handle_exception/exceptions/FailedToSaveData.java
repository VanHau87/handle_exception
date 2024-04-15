package com.hnguyen387.handle_exception.exceptions;

public class FailedToSaveData extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public FailedToSaveData(String message) {
		super(message);
	}
	
}
