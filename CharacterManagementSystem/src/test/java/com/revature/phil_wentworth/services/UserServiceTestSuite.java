package com.revature.phil_wentworth.services;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import com.revature.phil_wentworth.daos.UserDAO;

public class UserServiceTestSuite {
	UserService sut;
	UserDAO mockUserDAO;
	
	@Before
	public void testPrep() {
		mockUserDAO = mock(UserDAO.class);
		sut = new UserService(mockUserDAO);
	}
}
