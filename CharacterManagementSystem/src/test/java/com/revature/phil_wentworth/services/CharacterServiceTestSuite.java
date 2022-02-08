package com.revature.phil_wentworth.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.phil_wentworth.daos.MyCharacterDAO;
import com.revature.phil_wentworth.models.MyCharacter;
import com.revature.phil_wentworth.models.User;

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
		User u = new User("valid@valid", "valid", "valid");
		when(mockUserService.getSessionUser()).thenReturn(u);
		try {
			sut.generateMyCharacter("!@?");
		}
		catch (Exception e) {
			
		}
		finally {
			verify(mockCharacterDAO, times(0)).create(any());
		}
	}
	
	@Test
	public void test_generateMyCharacter_returnsMyCharacterIfNameValid() {
		User u = new User("valid@valid", "valid", "valid");
		MyCharacter c;
		when(mockUserService.getSessionUser()).thenReturn(u);
		try {
			c = sut.generateMyCharacter("valid");
			Assert.assertTrue( c.getCharacterName().equals("valid") );
			int[] stats = c.getStatistics();
			for (int i=0; i<stats.length; i++) {
				Assert.assertTrue( stats[i]>=3 && stats[i]<=18 );
			}
		}
		catch (Exception e) {
			
		}
		finally {
			verify(mockCharacterDAO, times(1)).create(any());
		}
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
