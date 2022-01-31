package com.revature.phil_wentworth.exceptions;

@SuppressWarnings("serial")
public class InvalidEmailException extends RuntimeException {
	public InvalidEmailException(String message) {
		super (message);
	}
}
