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
		// TODO Auto-generated method stub
		
	}

}
