package com.revature.phil_wentworth.services;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

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
	
	@Test
	public void test_generateMyCharacter_throwsExceptionIfNameInvalid() {
		
	}
	
	@Test
	public void test_generateMyCharacter_returnsMyCharacterIfNameValid() {
		
	}
	
	@Test
	public void test_getCharactersForUser_returnsCharacterListIfUserValid() {
		
	}
	
	@Test
	public void test_getCharactersForUser_returnsEmptyListIfUserInvalid() {
		
	}
	
	@Test
	public void test_getCharactersForUser_returnsEmptyListIfUserNotSet() {
		
	}
	
	@Test
	public void test_dumpStatistic_throwsExceptionWhenIllegalDumpAttempted() {
		
	}
	
	@Test
	public void test_dumpStatistic_changesMyCharacterIfDumpIsLegal() {
		
	}
}
