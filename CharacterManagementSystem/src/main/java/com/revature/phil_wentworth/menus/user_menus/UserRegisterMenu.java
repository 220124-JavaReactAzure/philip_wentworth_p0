package com.revature.phil_wentworth.menus.user_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.services.UserService;
import com.revature.phil_wentworth.util.MenuRouter;

public class UserRegisterMenu extends Menu {
	
	UserService userService;
	
	public UserRegisterMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("User Register","/user_register", consoleReader, router);
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
