package com.revature.phil_wentworth.exceptions;

@SuppressWarnings("serial")
public class EmailAlreadyExistsException extends RuntimeException{
	public EmailAlreadyExistsException(String message) {
		super(message);
	}
}
