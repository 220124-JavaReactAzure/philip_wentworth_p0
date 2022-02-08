package com.revature.phil_wentworth.exceptions;

import com.revature.phil_wentworth.util.logging.Logger;

@SuppressWarnings("serial")
public class InvalidCharacterNameException extends RuntimeException {

	public InvalidCharacterNameException(String message) {
		super(message);
		Logger.getLogger(false).log("InvalidCharacterNameException created with message " + message);
	}
		
}
