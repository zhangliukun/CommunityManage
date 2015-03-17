package cn.zale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zale.Interface.DaoInterface;
import cn.zale.Interface.ServiceInterface;
import cn.zale.model.FcAlarm;

@Service("fcAlarmService")
public class FcAlarmService implements ServiceInterface<FcAlarm> {

	@Autowired
	@Qualifier("fcAlarmDao")
	private DaoInterface<FcAlarm> fcAlarmDao;

	@Transactional
	public void saveClass(FcAlarm t) {
		fcAlarmDao.saveClass(t);
	}

	@Transactional(readOnly = true)
	public List<FcAlarm> listClass() {
		return fcAlarmDao.listClass();
	}

	@Transactional(readOnly = true)
	public List<FcAlarm> listPartData() {
		return fcAlarmDao.listPartData();
	}

	@Transactional(readOnly = true)
	public FcAlarm getClass(String id) {
		return fcAlarmDao.getclass(id);
	}

	@Transactional
	public void deleteClass(String id) {
		fcAlarmDao.deleteClass(id);
	}
	@Transactional(readOnly = true)
	public List<FcAlarm> listPartDataById(String id) {
		return fcAlarmDao.listPartDataById(id);
	}

}
