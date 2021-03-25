package com.example.demo.dao;

import com.example.demo.model.User;

public interface UserDAO {

	public boolean registerUser(User user);
//	public boolean updateUser(User user);
	public User getUserById(String UserId);
	public boolean validateUser(String userName, String password);
//	public boolean deleteUser(String UserId);
}
