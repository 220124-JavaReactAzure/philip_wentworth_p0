package com.revature.phil_wentworth.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.phil_wentworth.exceptions.EmailAlreadyExistsException;
import com.revature.phil_wentworth.exceptions.InvalidEmailException;
import com.revature.phil_wentworth.exceptions.InvalidUsernameException;
import com.revature.phil_wentworth.exceptions.UsernameAlreadyExistsException;
import com.revature.phil_wentworth.models.User;

public class UserService {
	//TODO
	public User registerNewUser(String username, String email) {
		return null;
	}

	//TODO
	public User authenticateUser() {
		return null;
	}

	public boolean isUserValid(String username, String email) throws EmailAlreadyExistsException, InvalidEmailException, InvalidUsernameException, UsernameAlreadyExistsException {
		if (!isUsernameValid(username)) {
			throw new InvalidUsernameException("Usernames can only contain letters and the underscore character.");
		}
		if (!isEmailValid(email)) {
			throw new InvalidEmailException("Email address must follow format user@domain.");
		}
		if (doesUsernameExist(username) ) {
			throw new EmailAlreadyExistsException("Username "+username+" is already in use.");
		}
		if (doesEmailExist(email) ) {
			throw new EmailAlreadyExistsException(email + " is already registered.");
		}
		return true;
	}
	
	//TODO
	public boolean doesUsernameExist(String username) {
		return false;
	}

	public boolean isUsernameValid(String username) {
		char[] letters = username.toCharArray();

		for (int i = 0; i < letters.length; i++) {
			if (!((letters[i] >= 'A' && letters[i] <= 'Z') || (letters[i] >= 'a' && letters[i] <= 'z')
					|| letters[i] == '_')) {
				return false;
			}
		}

		return true;
	}
	
	//TODO
	public boolean doesEmailExist(String email) {
		return false;
	}

	public boolean isEmailValid(String userEmail) {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
	    Matcher matcher = pattern.matcher(userEmail);
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	      return true;
	    } else {
	      return false;
	    }
	}
}
