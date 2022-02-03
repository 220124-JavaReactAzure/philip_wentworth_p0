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
		System.out.println("Username: ");
		String username = consoleReader.readLine();
		System.out.println("Password: ");
		String password = consoleReader.readLine();
		if ( userService.authenticateUser(username, password) != null ) {
			System.out.println("Welcome, "+username);
		}
		else {
			System.out.println("Login Failed.");
		}
	}

}
