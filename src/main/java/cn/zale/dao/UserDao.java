package cn.zale.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.zale.model.User;

@Repository
public class UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	public void saveUser(User user)
	{
		getSession().merge(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listUsers()
	{
		return getSession().createCriteria(User.class).list();
	}
	
	public User getUser(long id)
	{
		return (User)getSession().get(User.class, id);
	}
	
	public void deleteUser(long id)
	{
		User user = getUser(id);
		if (user != null) {
			getSession().delete(user);
		}
	}

	private Session getSession()
	{
		Session session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	private SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
