package cn.zale.Interface;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ServiceInterface <T>{

	
	
	public void saveClass(T t);

	public List<T> listClass();

	public List<T> listPartData();
	
	public List<T> listPartDataById(String id);
	
	
	public T getClass(String id);

	public void deleteClass(String id);

}
