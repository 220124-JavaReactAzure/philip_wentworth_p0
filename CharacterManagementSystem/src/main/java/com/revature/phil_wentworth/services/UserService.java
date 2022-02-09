package com.revature.phil_wentworth.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.phil_wentworth.daos.UserDAO;
import com.revature.phil_wentworth.exceptions.EmailAlreadyExistsException;
import com.revature.phil_wentworth.exceptions.InvalidEmailException;
import com.revature.phil_wentworth.exceptions.InvalidUsernameException;
import com.revature.phil_wentworth.exceptions.UsernameAlreadyExistsException;
import com.revature.phil_wentworth.models.User;

public class UserService {
	
	private UserDAO userDao = new UserDAO();
	private User sessionUser;
	
	public UserService(UserDAO userDao) {
		this.userDao = userDao;
		sessionUser = null;
	}

	public User registerNewUser(String email, String username, String password) {
		try {
			isUserValid(email,username);
			User newUser = new User(email, username, password);
			return userDao.create(newUser);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public User authenticateUser(String username, String password) {
		sessionUser = userDao.findByUsernameAndPassword(username, password);
		return sessionUser;
	}
	
	public User getSessionUser() {
		return sessionUser;
	}

	public boolean isUserValid(String email, String username) throws EmailAlreadyExistsException, InvalidEmailException, InvalidUsernameException, UsernameAlreadyExistsException {
		if (!isUsernameValid(username)) {
			throw new InvalidUsernameException("Usernames can only contain letters and the underscore character, maximum length is 40.");
		}
		if (!isEmailValid(email)) {
			throw new InvalidEmailException("Email address must follow format user@domain, maximum length is 254.");
		}
		if (doesUsernameExist(username) ) {
			throw new EmailAlreadyExistsException("Username "+username+" is already in use.");
		}
		if (doesEmailExist(email) ) {
			throw new EmailAlreadyExistsException(email + " is already registered.");
		}
		return true;
	}
	
	public boolean doesUsernameExist(String username) {
		if (userDao.findByUsername(username)==null) {
			return false;
		}
		return true;
	}

	public boolean isUsernameValid(String username) {
		if (username.length() > 40) {
			return false;
		}
		
		char[] letters = username.toCharArray();

		for (int i = 0; i < letters.length; i++) {
			if (!((letters[i] >= 'A' && letters[i] <= 'Z') || (letters[i] >= 'a' && letters[i] <= 'z')
					|| letters[i] == '_')) {
				return false;
			}
		}

		return true;
	}
	
	public boolean doesEmailExist(String email) {
		if (userDao.findById(email)==null) {
			return false;
		}
		return true;
	}

	public boolean isEmailValid(String userEmail) {
		if (userEmail.length()>254) {
			return false;
		}
		
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
	    Matcher matcher = pattern.matcher(userEmail);
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	      return true;
	    } else {
	      return false;
	    }
	}
	
	public void logout() {
		sessionUser = null;
	}
}
