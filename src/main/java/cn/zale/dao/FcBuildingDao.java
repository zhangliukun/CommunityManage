package cn.zale.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.zale.Interface.DaoInterface;
import cn.zale.model.FcBuilding;

@Repository("fcBuildingDao")
public class FcBuildingDao implements DaoInterface<FcBuilding> {

	@Autowired
	SessionFactory sessionFactory;

	public void saveClass(FcBuilding t) {
		getSession().merge(t);
	}

	@SuppressWarnings("unchecked")
	public List<FcBuilding> listClass() {
		return getSession().createCriteria(FcBuilding.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<FcBuilding> listPartData() {
		String hql = "select new FcBuilding(building.buildingId,building.areaId,building.buildingNumber) "
				+ "from FcBuilding building"
				+ "where building.areaId = ";
		Query query = getSession().createQuery(hql);
		List<FcBuilding> arrays = query.list();
		return arrays;
	}
	
	@SuppressWarnings("unchecked")
	public List<FcBuilding> listPartDataById(String id) {
		String hql = "select new FcBuilding(building.buildingId,building.areaId,building.buildingNumber,"
				+ " building.buildingX,building.buildingY) "
				+ " from FcBuilding building "
				+ " where building.areaId = " + id;
		Query query = getSession().createQuery(hql);
		List<FcBuilding> arrays = query.list();
		return arrays;
	}

	public FcBuilding getclass(String id) {
		return (FcBuilding)getSession().get(FcBuilding.class, Integer.valueOf(id));
	}

	public void deleteClass(String id) {
		FcBuilding building = getclass(id);
		if (building != null) {
			getSession().delete(building);
		}
	}

	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}


}
