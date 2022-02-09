package com.revature.phil_wentworth.menus.my_character_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.models.MyCharacter;
import com.revature.phil_wentworth.services.MyCharacterService;
import com.revature.phil_wentworth.util.MenuRouter;
import com.revature.phil_wentworth.util.MyArrayList;

public class CharacterDeleteMenu extends Menu {
	MyCharacterService myCharacterService;

	public CharacterDeleteMenu(BufferedReader consoleReader, MenuRouter router, MyCharacterService myCharacterService) {
		super("Character Delete", "/character_delete", consoleReader, router);
		this.myCharacterService = myCharacterService;
	}

	public void render() throws Exception {
		MyArrayList<MyCharacter> characters = myCharacterService.getCharactersForUser();
		System.out.println("Enter a Character Number from above: ");
		String userSelection = consoleReader.readLine();
		logger.log("User chose " + " character number " + userSelection + " from CharacterModifyMenu ");

		int choice = -1;

		try {
			choice = Integer.valueOf(userSelection);
		} catch (Exception e) {

		} finally {

		}

		if (choice < 0 || choice >= characters.size()) {
			System.out.println("Invalid Character Number. Must be between 0 and " + (characters.size() - 1));
			router.transfer("/user_dashboard");
			return;
		} else {
			MyCharacter c = characters.get(choice);
			System.out.println("Deleting " + c.getCharacterName());
			
			if (myCharacterService.delete(c)) {
				System.out.println("Success.");
			}
			else {
				System.out.println("Failed to delete " + c.getCharacterName());
			}
			router.transfer("/user_dashboard");
		}
	}
}
