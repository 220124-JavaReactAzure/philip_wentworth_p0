package com.revature.phil_wentworth.exceptions;

@SuppressWarnings("serial")
public class UsernameAlreadyExistsException extends RuntimeException{
	public UsernameAlreadyExistsException (String message) {
		super(message);
	}
}
