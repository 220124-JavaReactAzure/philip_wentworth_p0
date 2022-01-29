package com.revature.phil_wentworth.menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.util.MenuRouter;
import static com.revature.phil_wentworth.util.AppState.shutdown;

public class WelcomeMenu extends Menu{

	public WelcomeMenu(BufferedReader consoleReader, MenuRouter router) {
		super("Welcome", "/welcome", consoleReader, router);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render() throws Exception {
		
		StringBuilder menuChoices = new StringBuilder("Welcome to the Character Management System!\n");
		
		menuChoices.append("1. Login\n");
		menuChoices.append("2. Register\n");
		menuChoices.append("3. Exit\n");
		
		System.out.print(menuChoices);
		
		String userSelection = consoleReader.readLine();

		switch (userSelection) {
		case "1":
			router.transfer("/login");
			break;
		case "2":
			router.transfer("/register");
			break;
		case "3":
			shutdown();
			break;
		default:
			System.out.println("Invalid option, please enter a single digit for your menu choice.");
			break;
		}
		
	}

}
