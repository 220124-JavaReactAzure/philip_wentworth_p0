//package com.revature.phil_wentworth.services;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.revature.phil_wentworth.daos.MyCharacterDAO;
//import com.revature.phil_wentworth.models.MyCharacter;
//import com.revature.phil_wentworth.models.User;
//
//public class CharacterServiceTestSuite {
//	MyCharacterService sut;
//	MyCharacterDAO mockCharacterDAO;
//	UserService mockUserService;
//	
//	@Before
//	public void testPrep() {
//		mockCharacterDAO = mock(MyCharacterDAO.class);
//		mockUserService = mock(UserService.class);
//		sut = new MyCharacterService(mockCharacterDAO, mockUserService);
//	}
//	
//	@Test
//	public void test_generateMyCharacter_throwsExceptionIfNameInvalid() {
//		User u = new User("valid@valid", "valid", "valid");
//		when(mockUserService.getSessionUser()).thenReturn(u);
//		try {
//			sut.generateMyCharacter("!@?");
//		}
//		catch (Exception e) {
//			
//		}
//		finally {
//			verify(mockCharacterDAO, times(0)).create(any());
//		}
//	}
//	
//	@Test
//	public void test_generateMyCharacter_returnsMyCharacterIfNameValid() {
//		User u = new User("valid@valid", "valid", "valid");
//		MyCharacter c;
//		when(mockUserService.getSessionUser()).thenReturn(u);
//		try {
//			c = sut.generateMyCharacter("valid");
//			Assert.assertTrue( c.getCharacterName().equals("valid") );
//			int[] stats = c.getStatistics();
//			for (int i=0; i<stats.length; i++) {
//				Assert.assertTrue( stats[i]>=3 && stats[i]<=18 );
//			}
//		}
//		catch (Exception e) {
//			
//		}
//		finally {
//			verify(mockCharacterDAO, times(1)).create(any());
//		}
//	}
//	
//	@Test
//	public void test_getCharactersForUser_returnsCharacterListIfUserValid() {
//		ArrayList<MyCharacter> mcs = new ArrayList<>();
//		ArrayList<MyCharacter> testResult = new ArrayList<>();
//		User u = new User("valid@valid", "valid", "valid");
//		when(mockUserService.getSessionUser()).thenReturn(u);
//		when(mockCharacterDAO.getMyCharactersByEmail(any())).thenReturn(mcs);
//		mcs.add(sut.generateMyCharacter("valid"));
//		mcs.add(sut.generateMyCharacter("valid"));
//		mcs.add(sut.generateMyCharacter("valid"));
//		
//		testResult = sut.getCharactersForUser();
//		
//		Assert.assertTrue( testResult.size() == 3 );
//	}
//	
//	@Test
//	public void test_getCharactersForUser_returnsNullIfDAO_returnsNull() {
//		ArrayList<MyCharacter> mcs = new ArrayList<>();
//		ArrayList<MyCharacter> testResult = new ArrayList<>();
//		User u = new User("valid@valid", "valid", "valid");
//		when(mockUserService.getSessionUser()).thenReturn(u);
//		when(mockCharacterDAO.getMyCharactersByEmail(any())).thenReturn(null);
//		mcs.add(sut.generateMyCharacter("valid"));
//		mcs.add(sut.generateMyCharacter("valid"));
//		mcs.add(sut.generateMyCharacter("valid"));
//		
//		testResult = sut.getCharactersForUser();
//		
//		Assert.assertNull( testResult );
//	}
//	
//	@Test
//	public void test_getCharactersForUser_returnsNullIfUserNotSet() {
//		ArrayList<MyCharacter> mcs = new ArrayList<>();
//		ArrayList<MyCharacter> testResult = new ArrayList<>();
//		when(mockUserService.getSessionUser()).thenReturn(null);
//		when(mockCharacterDAO.getMyCharactersByEmail(any())).thenReturn(null);
//		mcs.add(sut.generateMyCharacter("valid"));
//		mcs.add(sut.generateMyCharacter("valid"));
//		mcs.add(sut.generateMyCharacter("valid"));
//		
//		testResult = sut.getCharactersForUser();
//		
//		Assert.assertNull( testResult );
//	}
//	
//	@Test
//	public void test_dumpStatistic_throwsExceptionWhenIllegalDumpAttempted() {
//		int[] stats = {12,12,12,12,12,12};
//		MyCharacter c = new MyCharacter(0, "valid@valid", "valid", stats);
//		
//		try {
//			sut.dumpStatistic(c, 0, 1, 12);
//		}
//		catch (Exception e) {
//			
//		}
//		finally {
//			for (int i=0; i<c.getStatistics().length; i++) {
//				Assert.assertTrue( c.getStatistic(i) == 12 );
//			}
//		}
//		
//		try {
//			sut.dumpStatistic(c, -10, 1, 12);
//		}
//		catch (Exception e) {
//			
//		}
//		finally {
//			for (int i=0; i<c.getStatistics().length; i++) {
//				Assert.assertTrue( c.getStatistic(i) == 12 );
//			}
//		}
//		
//		try {
//			sut.dumpStatistic(c, 0, -1, 12);
//		}
//		catch (Exception e) {
//			
//		}
//		finally {
//			for (int i=0; i<c.getStatistics().length; i++) {
//				Assert.assertTrue( c.getStatistic(i) == 12 );
//			}
//		}
//		
//		try {
//			sut.dumpStatistic(c, 0, -1, -1);
//		}
//		catch (Exception e) {
//			
//		}
//		finally {
//			for (int i=0; i<c.getStatistics().length; i++) {
//				Assert.assertTrue( c.getStatistic(i) == 12 );
//			}
//		}
//	}
//	
//	@Test
//	public void test_dumpStatistic_changesMyCharacterIfDumpIsLegal() {
//		int[] stats = {12,12,12,12,12,12};
//		MyCharacter c = new MyCharacter(0, "valid@valid", "valid", stats);
//		
//		try {
//			sut.dumpStatistic(c, 0, 1, 3);
//			sut.dumpStatistic(c, 2, 3, 3);
//			sut.dumpStatistic(c, 4, 5, 3);
//		}
//		catch (Exception e) {
//			
//		}
//		finally {
//			Assert.assertTrue( c.getStatistic(0) == 9 );
//			Assert.assertTrue( c.getStatistic(1) == 15 );
//			Assert.assertTrue( c.getStatistic(2) == 9 );
//			Assert.assertTrue( c.getStatistic(3) == 15 );
//			Assert.assertTrue( c.getStatistic(4) == 9 );
//			Assert.assertTrue( c.getStatistic(5) == 15 );
//		}
//	}
//}
