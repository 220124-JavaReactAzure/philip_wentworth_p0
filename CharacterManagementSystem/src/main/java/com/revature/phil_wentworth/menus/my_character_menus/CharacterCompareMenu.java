package com.revature.phil_wentworth.menus.my_character_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.models.MyCharacter;
import com.revature.phil_wentworth.services.MyCharacterService;
import com.revature.phil_wentworth.util.MenuRouter;
import com.revature.phil_wentworth.util.MyArrayList;

public class CharacterCompareMenu extends Menu {
	MyCharacterService myCharacterService;

	public CharacterCompareMenu(BufferedReader consoleReader, MenuRouter router,
			MyCharacterService myCharacterService) {
		super("Character Compare", "/character_compare", consoleReader, router);
		this.myCharacterService = myCharacterService;
	}

	@Override
	public void render() throws Exception {
		logger.log("Rendering CharacterCompareMenu");

		MyArrayList<MyCharacter> characters = myCharacterService.getCharactersForUser();

		System.out.println("Enter a Character Number from above: ");
		String userSelection = consoleReader.readLine();
		logger.log("User entered " + userSelection + " for choice a");

		int choice_a = -1;

		try {
			choice_a = Integer.valueOf(userSelection);
		} catch (Exception e) {

		} finally {

		}

		if (choice_a < 0 || choice_a >= characters.size()) {
			System.out.println("Invalid Character Number. Must be between 0 and " + (characters.size() - 1));
			router.transfer("/user_dashboard");
			return;
		}

		MyCharacter a = characters.get(choice_a);

		System.out.println("Enter a different Character Number from above: ");
		userSelection = consoleReader.readLine();
		logger.log("User entered " + userSelection + " for choice b");

		int choice_b = -1;
		;

		try {
			choice_b = Integer.valueOf(userSelection);
		} catch (Exception e) {

		} finally {

		}

		if (choice_b < 0 || choice_b >= characters.size()) {
			System.out.println("Invalid Character Number. Must be between 0 and " + (characters.size() - 1));
			router.transfer("/user_dashboard");
			return;
		} else if (choice_b == choice_a) {
			System.out.println("Cannot compare character to same character.");
			router.transfer("/user_dashboard");
			return;
		}

		MyCharacter b = characters.get(choice_b);

		myCharacterService.compareMyCharacters(a, b);
		router.transfer("/user_dashboard");
	}
}
