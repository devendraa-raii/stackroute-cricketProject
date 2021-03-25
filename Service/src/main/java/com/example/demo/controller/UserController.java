package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){
		Map<String, String> map=new HashMap<String,String>();
		try {
			userService.registerUser(user);
			map.put("message", "Registration Successful");
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.CREATED);
		}catch(UserAlreadyExistException e) {
			map.put("message", "Unsuccessful");
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user){
		Map<String, String> map=new HashMap<String,String>();
		try {
			boolean validate=this.userService.validateUser(user.getUserName(), user.getPassword());
			if(validate) {
				String token =
						Jwts.builder().
						setId(user.getUserName())
						.setIssuedAt(new Date()).
						signWith(SignatureAlgorithm.HS256,
								"usersecretkey").
						compact();
				map.put("token", token);
				map.put("message", "Login Successful");
				return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
			}
			else {
				map.put("message", "password is incorrect");
				return new ResponseEntity<Map<String,String>>(map,HttpStatus.OK);
			}
		}catch(UserNotFoundException e) {
			map.put("message", "Login failed");
			return new ResponseEntity<Map<String,String>>(map,HttpStatus.CONFLICT);
		}
		
	}
	
}
