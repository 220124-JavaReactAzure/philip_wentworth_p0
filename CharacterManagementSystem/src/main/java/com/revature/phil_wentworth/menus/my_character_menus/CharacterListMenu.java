package com.revature.phil_wentworth.menus.my_character_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.models.MyCharacter;
import com.revature.phil_wentworth.services.MyCharacterService;
import com.revature.phil_wentworth.util.MenuRouter;
import com.revature.phil_wentworth.util.MyArrayList;

public class CharacterListMenu extends Menu {
	MyCharacterService myCharacterService;

	public CharacterListMenu(BufferedReader consoleReader, MenuRouter router, MyCharacterService myCharacterService) {
		super("Character List","/character_list", consoleReader, router);
		this.myCharacterService = myCharacterService;
	}

	@Override
	public void render() throws Exception {
		logger.log("Rendering CharacterListMenu");
		
		MyArrayList<MyCharacter> characters = myCharacterService.getCharactersForUser();
		for (int i=0; i<characters.size(); i++) {
			System.out.print("\nCharacter " + i + ": " + characters.get(i) + "\n");
		}
		
		StringBuilder menuChoices = new StringBuilder("\n");
		
		menuChoices.append("1. Modify a Character\n");
		menuChoices.append("2. Compare my Characters\n");
		menuChoices.append("3. Return to my Dashboard\n");
		menuChoices.append("9. Delete a Character. This cannot be undone.\n");
		
		boolean tryAgain = true;

		while (tryAgain) {
			tryAgain = false;
			
			System.out.print(menuChoices);

			String userSelection = consoleReader.readLine();
			logger.log("User selected " + userSelection + " within CharacterListMenu ");

			switch (userSelection) {
			case "1":
				router.transfer("/character_modify");
				break;
			case "2":
				router.transfer("/character_compare");
				break;
			case "3":
				router.transfer("/user_dashboard");
				break;
			case "9":
				router.transfer("/character_delete");
				break;
			default:
				System.out.println(userSelection + "is an invalid option, please enter a single digit for your menu choice.");
				tryAgain = true;
				break;
			}
		} 
	}
}
