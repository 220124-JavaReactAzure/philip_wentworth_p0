package com.revature.phil_wentworth.services;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import com.revature.phil_wentworth.daos.MyCharacterDAO;
import com.revature.phil_wentworth.daos.UserDAO;

public class CharacterServiceTestSuite {
	MyCharacterService sut;
	MyCharacterDAO mockCharacterDAO;
	UserService userService;
	UserDAO mockUserDAO;
	
	@Before
	public void testPrep() {
		mockCharacterDAO = mock(MyCharacterDAO.class);
		mockUserDAO = mock(UserDAO.class);
		
		userService = new UserService(mockUserDAO);
		sut = new MyCharacterService(mockCharacterDAO, userService);
	}
}
