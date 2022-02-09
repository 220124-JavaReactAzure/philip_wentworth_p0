package com.revature.phil_wentworth.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.phil_wentworth.util.logging.Logger;
import com.revature.phil_wentworth.daos.MyCharacterDAO;
import com.revature.phil_wentworth.daos.UserDAO;
import com.revature.phil_wentworth.menus.WelcomeMenu;
import com.revature.phil_wentworth.menus.my_character_menus.CharacterCompareMenu;
import com.revature.phil_wentworth.menus.my_character_menus.CharacterDeleteMenu;
import com.revature.phil_wentworth.menus.my_character_menus.CharacterGenerateMenu;
import com.revature.phil_wentworth.menus.my_character_menus.CharacterListMenu;
import com.revature.phil_wentworth.menus.my_character_menus.CharacterModifyMenu;
import com.revature.phil_wentworth.menus.user_menus.UserDashboardMenu;
import com.revature.phil_wentworth.menus.user_menus.UserLoginMenu;
import com.revature.phil_wentworth.menus.user_menus.UserRegisterMenu;
import com.revature.phil_wentworth.services.MyCharacterService;
import com.revature.phil_wentworth.services.UserService;

public class AppState {
	private final Logger logger;
	private static boolean isRunning;
	private final MenuRouter router;
	
	
	public AppState() {
		logger = Logger.getLogger(false);
		logger.log("Logger initialized");
		
		isRunning = true;
		router = new MenuRouter();
		
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		UserDAO userDAO = new UserDAO();
		UserService userService = new UserService(userDAO);
		
		MyCharacterDAO myCharacterDAO = new MyCharacterDAO();
		MyCharacterService myCharacterService = new MyCharacterService(myCharacterDAO, userService);
		
		router.addMenu(new WelcomeMenu(consoleReader, router));
		router.addMenu(new UserRegisterMenu(consoleReader, router, userService));
		router.addMenu(new UserLoginMenu(consoleReader, router, userService));
		router.addMenu(new UserDashboardMenu(consoleReader, router, userService));
		router.addMenu(new CharacterGenerateMenu(consoleReader, router, myCharacterService));
		router.addMenu(new CharacterListMenu(consoleReader, router, myCharacterService));
		router.addMenu(new CharacterModifyMenu(consoleReader, router, myCharacterService));
		router.addMenu(new CharacterCompareMenu(consoleReader, router, myCharacterService));
		router.addMenu(new CharacterDeleteMenu(consoleReader, router, myCharacterService));
		
		logger.log("AppState initialized");
	}
	
	public void startup() {
		logger.log("AppState.startup() called");
		try {
			while(isRunning) {
				router.transfer("/welcome");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		logger.log("AppState.startup() finished");
	}
	
	public static void shutdown() {;
		isRunning = false;
	}
	
}
