package com.example.demo.dao;

import java.util.List;



import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Player;
@Repository
@Transactional
public class PlayerDAOImpl implements PlayerDAO{
	@Autowired
	public SessionFactory sessionFactory;
	public PlayerDAOImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory=sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean addPlayer(Player player) {
		if(this.getPlayerById(player.getPid(), player.getUserName())==null) {
			this.sessionFactory.getCurrentSession().save(player);
			return true;
		}
		return false;
	}
	public boolean deletePlayer(int pid,String userName) {
		if(this.getPlayerById(pid,userName)!=null) {
			javax.persistence.Query query=this.sessionFactory.getCurrentSession().createQuery("DELETE from Player where pid=:pid and userName=:name");
			query.setParameter("pid", pid);
			query.setParameter("name", userName);
			query.executeUpdate();
			return true;
		}
		return false;
	}
	public Player getPlayerById(int pid,String userName) {
		Query<Player> query=this.sessionFactory.getCurrentSession().createQuery("from Player where pid=:pid and userName=:name",Player.class);
		query.setParameter("pid", pid);
		query.setParameter("name", userName);
		List<Player> list=query.list();
		if(list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	public List<Player> getPlayersByUser(String userName){
		Query<Player> query=this.sessionFactory.getCurrentSession().createQuery("from Player where userName=:name",Player.class);
		query.setParameter("name",userName);
		return query.list();
	}

}
