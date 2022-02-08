package com.revature.phil_wentworth.menus.my_character_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.models.MyCharacter;
import com.revature.phil_wentworth.services.MyCharacterService;
import com.revature.phil_wentworth.services.UserService;
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
		logger.log("Rendering CharacterModifyMenu");
		
		MyArrayList<MyCharacter> characters = myCharacterService.getCharactersForUser();
		
		System.out.println("Enter a Character Number from above: ");
		String userSelection = consoleReader.readLine();
		logger.log("User chose " + " character number " + userSelection + " from CharacterModifyMenu " );
		
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
		logger.log("User chose " + " character number " + userSelection + " for dump from stat " );
		fromStat = Integer.valueOf(userSelection);
		
		if ( fromStat < 0 || fromStat >= statNames.length ) {
			System.out.println(fromStat + " is an invalid Stat Number. Must be between 0 and " + (statNames.length - 1) );
			router.transfer("/user_dashboard");
			return;
		}
		
		System.out.println("Which stat would you like to pump points to?");
		userSelection = consoleReader.readLine();
		logger.log("User chose " + " character number " + userSelection + " for pump to stat " );
		toStat = Integer.valueOf(userSelection);
		
		if ( toStat < 0 || toStat >= statNames.length ) {
			System.out.println(toStat +" is an invalid Stat Number. Must be between 0 and " + (statNames.length - 1) );
			router.transfer("/user_dashboard");
			return;
		}
		
		System.out.println("How many points would you like to move from " + statNames[fromStat] + " to " + statNames[toStat] + "?");
		userSelection = consoleReader.readLine();
		logger.log("User chose " + " character number " + userSelection + " as dump value to pump " );
		value = Integer.valueOf(userSelection);
		
		try {
			myCharacterService.dumpStatistic(c, fromStat, toStat, value);
			System.out.println(c);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		router.transfer("/user_dashboard");
	}
}
