package com.revature.phil_wentworth.exceptions;

import com.revature.phil_wentworth.util.logging.Logger;

@SuppressWarnings("serial")
public class InvalidUsernameException extends RuntimeException {
	public InvalidUsernameException(String message) {
		super(message);
		Logger.getLogger(false).log("InvalidUsernameException created with message " + message);
	}
}
