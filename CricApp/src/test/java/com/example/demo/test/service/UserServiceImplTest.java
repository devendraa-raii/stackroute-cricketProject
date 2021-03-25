package com.example.demo.test.service;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.dao.UserDAO;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;

public class UserServiceImplTest {
	@Mock private UserDAO userDAO;
	@InjectMocks UserServiceImpl userServiceImpl;
	private User user;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		user = new User("afafa","12334","adsh asjdh","as@adf.com","male","eeww");
	}
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testRegisterUserSuccess() throws UserAlreadyExistException {
		when(userDAO.getUserById(user.getUserName())).thenReturn(null);
		when(userDAO.registerUser(user)).thenReturn(true);
		boolean status = userServiceImpl.registerUser(user);
		assertEquals(true, status);
		verify(userDAO, times(1)).registerUser(user);
	}
	@Test(expected = UserAlreadyExistException.class)
	public void testRegisterUserFailure() throws UserAlreadyExistException {
		when(userDAO.getUserById(user.getUserName())).thenReturn(user);
		when(userDAO.registerUser(user)).thenReturn(false);
		boolean status = userServiceImpl.registerUser(user);
		assertEquals(false, status);
		verify(userDAO, times(1)).getUserById(user.getUserName());
	}
	
	
	@Test
	public void testGetUserByIdSuccess()  {
		when(userDAO.getUserById("afafa")).thenReturn(user);
		User userDetail = userServiceImpl.getUserById("afafa");
		assertEquals(user, userDetail);
		assertEquals(user.getUserName(), userDetail.getUserName());
		verify(userDAO, times(1)).getUserById("afafa");
	}
	@Test
	public void testGetUserByIdFailure(){
		when(userDAO.getUserById("afaf")).thenReturn(null);
		User userDetail = userServiceImpl.getUserById("afaf");
		assertEquals(null, userDetail);
		
		verify(userDAO, times(1)).getUserById("afaf");
	}
//	@Test
//	public void testValidateUserSuccess() throws UserNotFoundException {
//		when(userDAO.validateUser("afafa", "12334")).thenReturn(true);
//		boolean status = userServiceImpl.validateUser("afafa", "12334");
//		assertEquals(true, status);
//		verify(userDAO, times(1)).validateUser("afafa", "12334");
//	}
	@Test(expected = UserNotFoundException.class)
	public void testValidateUserFailure() throws UserNotFoundException {
		when(userDAO.validateUser("afafa", "12334")).thenReturn(false);
		@SuppressWarnings("unused")
		boolean status = userServiceImpl.validateUser("afafa", "12334");
	}
	
}
