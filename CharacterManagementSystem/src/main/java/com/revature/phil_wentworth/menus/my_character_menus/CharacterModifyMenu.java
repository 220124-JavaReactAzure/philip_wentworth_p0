package com.revature.phil_wentworth.menus.my_character_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.services.MyCharacterService;
import com.revature.phil_wentworth.util.MenuRouter;

public class CharacterModifyMenu extends Menu {
	MyCharacterService myCharacterService;
	
	public CharacterModifyMenu(BufferedReader consoleReader, MenuRouter router, MyCharacterService myCharacterService) {
		super("Character Modify","/character_modify", consoleReader, router);
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
