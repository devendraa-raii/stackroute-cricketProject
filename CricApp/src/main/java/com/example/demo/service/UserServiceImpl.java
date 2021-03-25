package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserDAO udao;
	public UserServiceImpl(UserDAO udao) {
		super();
		this.udao = udao;
	}
	
	public boolean registerUser(User user) throws UserAlreadyExistException {
			if(udao.getUserById(user.getUserName())==null)
			{
				String hashpw =
						BCrypt.hashpw(user.getPassword(),
								BCrypt.gensalt());
//				System.out.println(hashpw);
				user.setPassword(hashpw);
				return udao.registerUser(user);
			}
			throw new UserAlreadyExistException("User already exists");
		
		
		}
	
	public User getUserById(String UserId){
		User user = udao.getUserById(UserId);
		if (user!=null) {
			return user;
		}
		return user;
	}
	
	public boolean validateUser(String userId, String password) throws UserNotFoundException {
				User user=udao.getUserById(userId);
				if(user!=null) {
				boolean matched = BCrypt.checkpw(password, user.getPassword());
				if(matched)
					return true;
				else return false;
				}
				else {
					throw new UserNotFoundException("user does not exists");
				}
	}

}
