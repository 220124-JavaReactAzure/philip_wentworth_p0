package com.revature.phil_wentworth.services;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import com.revature.phil_wentworth.daos.UserDAO;

public class UserServiceTestSuite {
	UserService sut;
	UserDAO mockUserDAO;
	
	@Before
	public void testPrep() {
		mockUserDAO = mock(UserDAO.class);
		sut = new UserService(mockUserDAO);
	}
	
	@Test
	public void test_registerNewUser_returnsUserIfSuccessful() {
		
	}
	
	@Test
	public void test_registerNewUser_returnsNullIfFailure() {
		
	}
	
	@Test
	public void test_authenticateUser_returnsUserIfSuccessful() {
		
	}
	
	@Test
	public void test_authenticateUser_returnsNullIfFailure() {
		
	}
	
	@Test
	public void test_isUserValid_throwsExceptionIfUsernameInvalid() {
		
	}
	
	@Test
	public void test_isUserValid_throwsExceptionIfEmailInvalid() {
		
	}
	
	@Test
	public void test_isUserValid_throwsExceptionIfUsernameExists() {
		
	}
	
	@Test
	public void test_isUserValid_throwsExceptionIfEmailExists() {
		
	}
	
	@Test
	public void test_isUserValid_returnsTrueIfUsernameAndEmailValid() {
		
	}
}
