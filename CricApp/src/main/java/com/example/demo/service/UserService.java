package com.example.demo.service;

import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;

public  interface UserService {

	public boolean registerUser(User user) throws UserAlreadyExistException;
//	public User updateUser(User user, String id) throws Exception;
//	public boolean deleteUser(String UserId);
	public boolean validateUser(String userName, String password) throws UserNotFoundException;
	public User getUserById(String userId);


}
