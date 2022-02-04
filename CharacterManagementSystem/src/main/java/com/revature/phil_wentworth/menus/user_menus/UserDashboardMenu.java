package com.revature.phil_wentworth.menus.user_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.services.UserService;
import com.revature.phil_wentworth.util.MenuRouter;

public class UserDashboardMenu extends Menu {
	UserService userService;

	public UserDashboardMenu(BufferedReader consoleReader, MenuRouter router, UserService userService) {
		super("User Dashboard", "/user_dashboard", consoleReader, router);
		this.userService = userService;
	}

	@Override
	public void render() throws Exception {
		logger.log("Rendering UserDashboardMenu");
		
		StringBuilder menuChoices = new StringBuilder(
				userService.getSessionUser().getUsername() + " Dashboard: \n");

		menuChoices.append("1. Generate Character\n");
		menuChoices.append("2. View My Characters\n");
		menuChoices.append("3. Logout\n");
		
		boolean tryAgain = false;

		do {
			System.out.print(menuChoices);

			String userSelection = consoleReader.readLine();
			
			logger.log("User chose " + userSelection + " within UserDashboard");

			switch (userSelection) {
			case "1":
				router.transfer("/character_generate");
				break;
			case "2":
				router.transfer("/character_list");
				break;
			case "3":
				userService.logout();
				break;
			default:
				System.out.println("Invalid option, please enter a single digit for your menu choice.");
				tryAgain = true;
				break;
			}
		} while (tryAgain);
	}
}
