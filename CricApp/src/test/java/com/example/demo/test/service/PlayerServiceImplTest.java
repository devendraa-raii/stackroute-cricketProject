package com.example.demo.test.service;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.dao.PlayerDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.model.Player;
import com.example.demo.model.User;
import com.example.demo.service.PlayerServiceImpl;
import com.example.demo.service.UserServiceImpl;

public class PlayerServiceImplTest {
	@Mock private PlayerDAO playerDao;
	@InjectMocks PlayerServiceImpl playerService;
	private Player player;
	List<Player> plist;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		player=new Player();
		player.setId(1);
		player.setPid(132);
		player.setName("sachin");
		player.setFullName("sachin tendulkar");
		player.setUserName("ameyaB");
		
		plist=new ArrayList<Player>();
		plist.add(player);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testAddPlayerSuccess() {
		when(playerDao.getPlayerById(132, "ameyaB")).thenReturn(null);
		when(playerDao.addPlayer(player)).thenReturn(true);
		boolean status = playerService.addPlayer(player);
		assertEquals(true, status);
		verify(playerDao, times(1)).addPlayer(player);
	}
	
	@Test
	public void testAddPlayerFailure() {
		when(playerDao.getPlayerById(132, "ameyaB")).thenReturn(player);
		when(playerDao.addPlayer(player)).thenReturn(false);
		boolean status = playerService.addPlayer(player);
		assertEquals(false, status);
		verify(playerDao, times(1)).addPlayer(player);
	}
	
	
	@Test
	public void testDeletePlayerSuccess() {
		when(playerDao.deletePlayer(132, "ameyaB")).thenReturn(true);
		boolean status = playerService.deletePlayer(132, "ameyaB");
		assertEquals(true, status);
		verify(playerDao, times(1)).deletePlayer(132, "ameyaB");
	}
	@Test
	public void testDeletePlayerFailure() {
		when(playerDao.deletePlayer(132, "ameyaB")).thenReturn(false);
		boolean status = playerService.deletePlayer(132, "ameyaB");
		assertEquals(false, status);
		verify(playerDao, times(1)).deletePlayer(132, "ameyaB");
	}
	
	@Test
	public void testGetPlayersByUserNameSuccess() {
		when(playerDao.getPlayersByUser("ameyaB")).thenReturn(plist);
		List<Player> list=playerService.getPlayersByUser("ameyaB");
		assertEquals(plist,list);
		
	}
}
