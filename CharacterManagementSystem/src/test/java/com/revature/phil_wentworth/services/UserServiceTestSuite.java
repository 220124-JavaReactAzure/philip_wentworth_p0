package com.revature.phil_wentworth.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.phil_wentworth.daos.UserDAO;
import com.revature.phil_wentworth.models.User;

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
		User valid = new User("valid@valid", "valid", "valid");
		when(mockUserDAO.findById( any() )).thenReturn(null);
		when(mockUserDAO.findByUsername( any() )).thenReturn(null);
		when(mockUserDAO.create( any() )).thenReturn(valid);
		
		User u = sut.registerNewUser("valid@valid", "valid", "valid");
		
		Assert.assertTrue( u.getEmail().equals("valid@valid") );
		Assert.assertTrue( u.getUsername().equals("valid") );
		Assert.assertTrue( u.getPassword().equals("valid") );
	}
	
	@Test
	public void test_registerNewUser_returnsNullIfFailure() {
		User valid = new User("valid@valid", "valid", "valid");
		when(mockUserDAO.findById( any() )).thenReturn(null);
		when(mockUserDAO.findByUsername( any() )).thenReturn(null);
		when(mockUserDAO.create( any() )).thenReturn(valid);
		
		User u = sut.registerNewUser("invalid email", "valid", "no rules for password");
		
		Assert.assertNull(u);
		
		u = sut.registerNewUser("valid@valid", "inv4l!d user", "no rules for password");
		
		Assert.assertNull(u);
		
		u = sut.registerNewUser("invalid email", "inv4l!d user", "no rules for password");
		
		Assert.assertNull(u);
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
