//package cn.zale.service;
//
//import java.io.File;
//import java.io.InputStream;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import cn.zale.dao.UserDao;
//import cn.zale.model.User;
//
//@Service
//public class UserService {
//
//	@Autowired
//	private UserDao userDao;
//	
//	@Transactional
//	public void saveBook(User user)
//	{
//		userDao.saveUser(user);
//	}
//	
//	@Transactional(readOnly= true)
//	public List<User> listUsers()
//	{
//		return userDao.listUsers();
//	}
//	
//	@Transactional(readOnly = true)
//	public User getUser(long id)
//	{
//		return userDao.getUser(id);
//	}
//	
//	@Transactional
//	public void deleteUser(long id)
//	{
//		userDao.deleteUser(id);
//	}
//	
//	@Transactional
//	public void saveImage(String id,InputStream f)
//	{
//		userDao.saveImage(id,f);
//	}
//}
