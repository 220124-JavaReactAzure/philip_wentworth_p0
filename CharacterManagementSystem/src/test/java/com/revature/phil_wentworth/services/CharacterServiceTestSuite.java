package com.revature.phil_wentworth.services;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import com.revature.phil_wentworth.daos.MyCharacterDAO;

public class CharacterServiceTestSuite {
	MyCharacterService sut;
	MyCharacterDAO mockCharacterDAO;
	UserService mockUserService;
	
	@Before
	public void testPrep() {
		mockCharacterDAO = mock(MyCharacterDAO.class);
		mockUserService = mock(UserService.class);
		sut = new MyCharacterService(mockCharacterDAO, mockUserService);
	}
	
	//generateMyCharacter(String)
	//getCharactersForUser()
	//dumpStatistic(MyCharacter, int, int, int)
	//compareMyCharacters(MyCharacter, MyCharacter)
	//isCharacterNameValid(String)
	//isStatisticValid(int)
	//printCharacterStatisticLine(MyCharacter)
	//logout()
}
