package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PlayerDAO;
import com.example.demo.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	PlayerDAO pdao;
	public PlayerServiceImpl(PlayerDAO pdao) {
		// TODO Auto-generated constructor stub
		this.pdao=pdao;
	}
	
	public boolean addPlayer(Player player) {
		return this.pdao.addPlayer(player);
	}
	public boolean deletePlayer(int pid,String userName) {
		return this.pdao.deletePlayer(pid, userName);
	}
	public Player getPlayerById(int pid,String userName) {
		return this.pdao.getPlayerById(pid, userName);
	}
	public List<Player> getPlayersByUser(String userName){
		return this.pdao.getPlayersByUser(userName);
	}

}
