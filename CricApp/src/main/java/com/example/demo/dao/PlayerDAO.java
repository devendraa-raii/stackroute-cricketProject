package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Player;

public interface PlayerDAO {

	public boolean addPlayer(Player player);
	public boolean deletePlayer(int pid,String userName);
	public Player getPlayerById(int pid,String userName);
	public List<Player> getPlayersByUser(String userName);

}
