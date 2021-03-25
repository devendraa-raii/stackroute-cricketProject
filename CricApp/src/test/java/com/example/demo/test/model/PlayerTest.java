package com.example.demo.test.model;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import com.example.demo.model.Player;
import com.example.demo.model.User;
public class PlayerTest {
	private Player player;
	@Before
	public void setUp() throws Exception {
		player=new Player(1,1231,"sachin","ahfjaf","ajasd");
		
	}
	
	@Test
	public void test() {
		new BeanTester().testBean(Player.class);
	}
}
