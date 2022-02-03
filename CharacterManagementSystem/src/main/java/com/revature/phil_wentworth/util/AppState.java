package com.revature.phil_wentworth.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.phil_wentworth.daos.MyCharacterDAO;
import com.revature.phil_wentworth.daos.UserDAO;
import com.revature.phil_wentworth.menus.WelcomeMenu;
import com.revature.phil_wentworth.services.MyCharacterService;
import com.revature.phil_wentworth.services.UserService;

public class AppState {

	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		UserDAO userDAO = new UserDAO();
		UserService userService = new UserService(userDAO);
		
		MyCharacterDAO myCharacterDAO = new MyCharacterDAO();
		MyCharacterService myCharacterService = new MyCharacterService(myCharacterDAO, userService);
		
		router.addMenu(new WelcomeMenu(consoleReader, router));
	}
	
	public void startup() {
		try {
			while(isRunning) {
				router.transfer("/welcome");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void shutdown() {
		isRunning = false;
	}
	
}
