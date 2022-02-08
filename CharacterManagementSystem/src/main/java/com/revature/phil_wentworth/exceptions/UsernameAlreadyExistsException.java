package com.revature.phil_wentworth.exceptions;

import com.revature.phil_wentworth.util.logging.Logger;

@SuppressWarnings("serial")
public class UsernameAlreadyExistsException extends RuntimeException{
	public UsernameAlreadyExistsException (String message) {
		super(message);
		Logger.getLogger(false).log("UsernameAlreadyExistsException created with message " + message);
	}
}
