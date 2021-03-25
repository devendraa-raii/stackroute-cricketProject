package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Player;

public interface PlayerService {

	public boolean addPlayer(Player player);
	public boolean deletePlayer(int pid,String userName);
	public Player getPlayerById(int pid,String userName);
	public List<Player> getPlayersByUser(String userName);

}
