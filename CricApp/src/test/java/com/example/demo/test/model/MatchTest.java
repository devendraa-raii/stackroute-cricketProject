package com.example.demo.test.model;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import com.example.demo.model.Match;
import com.example.demo.model.User;

public class MatchTest {


	private Match match;

	@Before
	public void setUp() throws Exception {

		match = new Match();
		match.setId(1);
		match.setDate("2021-12-12");
		match.setTeam1("India");
		match.setTeam2("england");
		match.setType("ODI");
		match.setUnique_id(123123);
		match.setUserName("asasd");
	}

	@Test
	public void test() {
		new BeanTester().testBean(Match.class);
	}

}
