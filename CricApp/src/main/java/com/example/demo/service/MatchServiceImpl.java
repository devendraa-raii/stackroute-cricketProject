package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MatchDAO;
import com.example.demo.model.Match;

@Service
public class MatchServiceImpl implements MatchService{
	
	@Autowired
	MatchDAO mdao;
	public MatchServiceImpl(MatchDAO mdao) {
		this.mdao=mdao;
	}
	
	public boolean addMatch(Match match) {
		return this.mdao.addMatch(match);
	}
	public boolean deleteMatch(int unique_id,String userName) {
		return this.mdao.deleteMatch(unique_id, userName);
	}
	public Match getMatchById(int unique_id,String userName) {
		return this.mdao.getMatchById(unique_id, userName);
	}
	public List<Match> getAllMatches(String userName){
		return this.mdao.getAllMatches(userName);
	}

}
