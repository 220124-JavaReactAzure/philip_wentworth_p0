package com.revature.phil_wentworth.exceptions;

@SuppressWarnings("serial")
public class InvalidUsernameException extends RuntimeException {
	public InvalidUsernameException(String message) {
		super(message);
	}
}
