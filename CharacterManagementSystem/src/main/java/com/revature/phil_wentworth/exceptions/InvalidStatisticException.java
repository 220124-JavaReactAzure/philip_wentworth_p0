package com.revature.phil_wentworth.exceptions;

import com.revature.phil_wentworth.util.logging.Logger;

@SuppressWarnings("serial")
public class InvalidStatisticException extends RuntimeException {

	public InvalidStatisticException(String message) {
		super(message);
		Logger.getLogger(false).log("InvalidStatisticException created with message " + message);
	}
		
}
