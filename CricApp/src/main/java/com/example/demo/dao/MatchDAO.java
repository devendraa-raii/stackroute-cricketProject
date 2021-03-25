package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Match;

public interface MatchDAO {

	public boolean addMatch(Match match);
	public boolean deleteMatch(int unique_id,String userName);
	public Match getMatchById(int unique_id,String userName);
	public List<Match> getAllMatches(String userName);

}
