package com.revature.phil_wentworth.menus.my_character_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.models.MyCharacter;
import com.revature.phil_wentworth.services.MyCharacterService;
import com.revature.phil_wentworth.util.MenuRouter;

public class CharacterGenerateMenu extends Menu {
	MyCharacterService myCharacterService;

	public CharacterGenerateMenu(BufferedReader consoleReader, MenuRouter router,
			MyCharacterService myCharacterService) {
		super("Character Generate", "/character_generate", consoleReader, router);
		this.myCharacterService = myCharacterService;
	}

	@Override
	public void render() throws Exception {
		System.out.println("Enter a name for your character: ");
		String characterName = consoleReader.readLine();

		if (myCharacterService.isCharacterNameValid(characterName)) {
			MyCharacter c = myCharacterService.generateMyCharacter(characterName);

			if (c != null) {
				System.out.println(c);
				router.transfer("user_dashboard");
			} else {
				System.out.println("Character generation failed.");
				router.transfer("user_dashboard");
			}
		}
		else {
			System.out.println(characterName + " is not a valid character name. A-Z, a-z, and spaces only.");
		}
	}
}
