package com.revature.phil_wentworth.menus.user_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.services.UserService;
import com.revature.phil_wentworth.util.MenuRouter;

public class UserLoginMenu extends Menu {
	
UserService userService;
	
	public UserLoginMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("User Login","/user_login", consoleReader, router);
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		logger.log("Rendering UserLoginMenu");
		System.out.println("Username: ");
		String username = consoleReader.readLine();
		System.out.println("Password: ");
		String password = consoleReader.readLine();
		if ( userService.authenticateUser(username, password) != null ) {
			System.out.println("Welcome, "+username);
			logger.log("userService.authenticateUser returned true when called within UserLoginMenu, routing to user dashboard");
			router.transfer("/user_dashboard");
		}
		else {
			System.out.println("Login Failed.");
			logger.log("userService.authenticateUser returned false when called within UserLoginMenu");
		}
	}

}
