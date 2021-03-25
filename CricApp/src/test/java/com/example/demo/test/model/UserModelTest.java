package com.example.demo.test.model;


import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import com.example.demo.model.User;



public class UserModelTest {

	private User user;

	@Before
	public void setUp() throws Exception {

		user = new User();
		user.setUserName("Jhon123");
        user.setFullName("Jhon Simon");
        user.setEmail("sa@gmail.com");
        user.setPassword("123456");
        user.setAddress("mumbai");

	}

	@Test
	public void test() {
		new BeanTester().testBean(User.class);
	}

}
