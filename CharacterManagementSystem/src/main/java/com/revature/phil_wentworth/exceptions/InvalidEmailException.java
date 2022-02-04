package com.revature.phil_wentworth.exceptions;

import com.revature.phil_wentworth.util.logging.Logger;

@SuppressWarnings("serial")
public class InvalidEmailException extends RuntimeException {
	public InvalidEmailException(String message) {
		super (message);
		Logger.getLogger(false).log("InvalidEmailException created with message " + message);
	}
}
