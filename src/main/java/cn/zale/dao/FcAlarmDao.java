package cn.zale.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.zale.Interface.DaoInterface;
import cn.zale.model.FcAlarm;
import cn.zale.model.FcArea;

@Repository("fcAlarmDao")
public class FcAlarmDao implements DaoInterface<FcAlarm> {

	@Autowired
	SessionFactory sessionFactory;

	public void saveClass(FcAlarm t) {
		getSession().merge(t);
	}

	@SuppressWarnings("unchecked")
	public List<FcAlarm> listClass() {
		return getSession().createCriteria(FcAlarm.class).list();
	}

	public FcAlarm getclass(String id) {
		return (FcAlarm) getSession().get(FcAlarm.class, Integer.valueOf(id));
	}

	public void deleteClass(String id) {
		FcAlarm alarm = getclass(id);
		if (alarm != null) {
			getSession().delete(alarm);
		}
	}

	@SuppressWarnings("unchecked")
	public List<FcAlarm> listPartData() {
		String hql = "select new FcAlarm(alarmFont,alarmX,alarmY) from FcAlarm";
		Query query = getSession().createQuery(hql);

		List<FcAlarm> alarms = query.list();
		return alarms;
	}

	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	public List<FcAlarm> listPartDataById(String id) {
		String hql = "select new FcAlarm(alarm.alarmId,alarm.alarmFont,alarm.alarmX,alarm.alarmY,alarm.buildingId) "
				+ "from FcAlarm alarm where alarm.buildingId = "+ id;
		Query query = getSession().createQuery(hql);
		List<FcAlarm> arrays = query.list();
		return arrays;
	}

}
