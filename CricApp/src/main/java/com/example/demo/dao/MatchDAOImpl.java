package com.example.demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Match;
import com.example.demo.model.Player;

@Repository
@Transactional
public class MatchDAOImpl implements MatchDAO{
	
	
	@Autowired
	public SessionFactory sessionFactory;
	public MatchDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean addMatch(Match match) {
		if(this.getMatchById(match.getUnique_id(), match.getUserName())==null) {
			this.sessionFactory.getCurrentSession().save(match);
			return true;
		}
		return false;
	}
	public boolean deleteMatch(int unique_id,String userName) {
		if(this.getMatchById(unique_id, userName)!=null) {
			javax.persistence.Query query=this.sessionFactory.getCurrentSession().createQuery("DELETE from Matches where unique_id=:pid and userName=:name");
			query.setParameter("pid", unique_id);
			query.setParameter("name", userName);
			query.executeUpdate();
			return true;
		}
		return false;
	}
	public Match getMatchById(int unique_id,String userName) {
		Query<Match> query=this.sessionFactory.getCurrentSession().createQuery("from Matches where unique_id=:pid and userName=:name",Match.class);
		query.setParameter("pid", unique_id);
		query.setParameter("name", userName);
		List<Match> list=query.list();
		if(list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	public List<Match> getAllMatches(String userName){
		Query<Match> query=this.sessionFactory.getCurrentSession().createQuery("from Matches where userName=:name",Match.class);
		query.setParameter("name",userName);
		return query.list();
	}

}
