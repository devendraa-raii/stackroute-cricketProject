package com.example.demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	public SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean registerUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			
			sessionFactory.getCurrentSession().flush();
		}
		catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return true ;
	}

	public User getUserById(String UserId) {
		return (User)this.sessionFactory.getCurrentSession().find(User.class, UserId);
	}
	public boolean validateUser(String userName, String password) {
		Query<User> query=this.sessionFactory.getCurrentSession().createQuery("from User where userName=:userName and password=:password",User.class);
		query.setParameter("userName",userName);
		query.setParameter("password", password);
		List<User> userList=query.list();
		if(userList!=null && userList.size()>0 ) {
			return true;
		}
		return false;
	}

}
