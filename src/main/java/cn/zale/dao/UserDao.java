package cn.zale.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
	
	//以字节流通过hibernate存入数据库
	public void saveImage(String Id,InputStream f)
	{
		long id = Long.parseLong(Id);
		User user = getUser(id);
		try {
			byte[]	b = new byte[f.available()];
			f.read(b);
			f.close();
			//user.setPicture(b);
		} catch (Exception e) {
			e.printStackTrace();
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
