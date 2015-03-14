package cn.zale.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.zale.Interface.DaoInterface;
import cn.zale.model.FcArea;
import cn.zale.model.FcBuilding;

@Repository("fcAreaDao")
public class FcAreaDao implements DaoInterface<FcArea>{

	
	@Autowired
	SessionFactory sessionFactory;

	
	public void saveClass(FcArea t) {
		getSession().merge(t);
	}

	@SuppressWarnings("unchecked")
	public List<FcArea> listClass() {
		return getSession().createCriteria(FcArea.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<FcArea> listPartData()
	{
		String hql = "select new FcArea(areaId,areaName,areaChinese) from FcArea";
		Query query = getSession().createQuery(hql);
		
		List<FcArea> areas = query.list();
		return areas;
		
	}

	public FcArea getclass(String id) {
		return (FcArea) getSession().get(FcArea.class, Integer.valueOf(id));
	}

	public void deleteClass(String id) {
		FcArea area = getclass(id);
		if (area != null) {
			getSession().delete(area);
		}
	}

	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	public List<FcArea> listPartDataById(String id) {
		String hql = "select new FcArea(Area.areaId,Area.areaName,Area.areaChinese) "
				+ " from FcArea Area where Area.areaId = " + id;
		Query query = getSession().createQuery(hql);
		List<FcArea> arrays = query.list();
		return arrays; 
	}



}
