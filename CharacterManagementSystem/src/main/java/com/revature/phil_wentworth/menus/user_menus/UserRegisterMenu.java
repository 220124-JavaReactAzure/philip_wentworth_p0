package com.revature.phil_wentworth.menus.user_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.services.UserService;
import com.revature.phil_wentworth.util.MenuRouter;

public class UserRegisterMenu extends Menu {

	UserService userService;

	public UserRegisterMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("User Register", "/user_register", consoleReader, router);
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		logger.log("Rendering UserRegisterMenu");
		
		String email = null;
		String username = null;
		String password = null;
		String userSelection;

		do {
			System.out.println("Enter your Email: ");
			userSelection = consoleReader.readLine();
			
			logger.log("User entered " + userSelection + " as their email.");
			
			if (userService.isEmailValid(userSelection)) {
				if (userService.doesEmailExist(userSelection)) {
					System.out.println(userSelection + " is already registered.");
					logger.log(userSelection + " was aleady registered.");
				}
				else {
					email = userSelection;
				}
			} else {
				System.out.println(userSelection + " is not a valid email.");
				logger.log(userSelection + "is not a valid email.");
			}
		} while (email == null);
		
		do {
			System.out.println("Choose your Username: ");
			userSelection = consoleReader.readLine();
			if (userService.isUsernameValid(userSelection)) {
				if (userService.doesUsernameExist(userSelection)) {
					System.out.println(userSelection + " is already registered.");
					logger.log(userSelection + " was aleady registered.");
				}
				else {
					username = userSelection;
				}
			}
			else {
				System.out.println(userSelection + " is not a valid username. A-Z, a-z, and _ only. Maximum length is 40.");
				logger.log(userSelection + " was not a valid username.");
			}
		} while (username == null);
		
		System.out.println("Choose your Password: ");
		password = consoleReader.readLine();
		
		if (userService.registerNewUser(email, username, password) != null) {
			System.out.println("Successfully registered " + email + " as " + username + ". You can now login with the password you chose.");
			logger.log("Successfully registered " + email + " as " + username);
		}
		else {
			System.out.println("Registration failed.");
			logger.log("Registration failed.");
		}
	}

}
