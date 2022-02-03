package com.revature.phil_wentworth.menus.my_character_menus;

import java.io.BufferedReader;

import com.revature.phil_wentworth.menus.Menu;
import com.revature.phil_wentworth.services.MyCharacterService;
import com.revature.phil_wentworth.util.MenuRouter;

public class CharacterGenerateMenu extends Menu {
	MyCharacterService myCharacterService;
	
	public CharacterGenerateMenu(BufferedReader consoleReader, MenuRouter router, MyCharacterService myCharacterService) {
		super("Character Generate","/character_generate", consoleReader, router);
	}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
