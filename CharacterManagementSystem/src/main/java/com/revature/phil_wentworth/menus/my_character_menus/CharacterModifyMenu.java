package com.revature.phil_wentworth.menus.my_character_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.models.MyCharacter;
import com.revature.phil_wentworth.services.MyCharacterService;
import com.revature.phil_wentworth.util.MenuRouter;
import com.revature.phil_wentworth.util.MyArrayList;

public class CharacterModifyMenu extends Menu {
	MyCharacterService myCharacterService;
	
	public CharacterModifyMenu(BufferedReader consoleReader, MenuRouter router, MyCharacterService myCharacterService) {
		super("Character Modify","/character_modify", consoleReader, router);
		this.myCharacterService = myCharacterService;
	}

	@Override
	public void render() throws Exception {
		MyArrayList<MyCharacter> characters = myCharacterService.getCharactersForUser();
		
		System.out.println("Enter a Character Number from above: ");
		String userSelection = consoleReader.readLine();
		int choice = Integer.valueOf(userSelection);
		
		if ( choice < 0 || choice >= characters.size() ) {
			System.out.println("Invalid Character Number. Must be between 0 and " + (characters.size() - 1) );
			router.transfer("/user_dashboard");
			return;
		}
		
		MyCharacter c = characters.get( choice );
		
		int fromStat;
		int toStat;
		int value;
		
		System.out.println(c);
		
		String[] statNames = MyCharacter.getStatisticAbbreviations();
		for (int i=0; i<statNames.length; i++) {
			System.out.println("Stat " + i + ": " + statNames[i]);
		}
		
		System.out.println("Which stat would you like to dump points from?");
		userSelection = consoleReader.readLine();
		fromStat = Integer.valueOf(userSelection);
		
		if ( fromStat < 0 || fromStat >= statNames.length ) {
			System.out.println(fromStat + " is an invalid Stat Number. Must be between 0 and " + (statNames.length - 1) );
			router.transfer("/user_dashboard");
			return;
		}
		
		System.out.println("Which stat would you like to pump points to?");
		userSelection = consoleReader.readLine();
		toStat = Integer.valueOf(userSelection);
		
		if ( toStat < 0 || toStat >= statNames.length ) {
			System.out.println(toStat +" is an invalid Stat Number. Must be between 0 and " + (statNames.length - 1) );
			router.transfer("/user_dashboard");
			return;
		}
		
		System.out.println("How many points?");
		userSelection = consoleReader.readLine();
		value = Integer.valueOf(userSelection);
		
		myCharacterService.dumpStatistic(c, fromStat, toStat, value);
		System.out.println(c);
		router.transfer("/user_dashboard");
	}
}
