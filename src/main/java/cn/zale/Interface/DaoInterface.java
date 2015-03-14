package cn.zale.Interface;

import java.io.InputStream;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


public interface DaoInterface<T> {
	
	public void saveClass(T t);
	
	

	@SuppressWarnings("unchecked")
	public List<T> listClass();
	
	
	public List<T> listPartData();

	public List<T> listPartDataById(String id);
	
	
	public T getclass(String id);
	

	public void deleteClass(String id);

	
}
