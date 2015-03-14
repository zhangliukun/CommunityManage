package cn.zale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zale.Interface.DaoInterface;
import cn.zale.Interface.ServiceInterface;
import cn.zale.model.FcArea;

@Service("fcAreaService")
public class FcAreaService implements ServiceInterface<FcArea> {

	@Autowired
	@Qualifier("fcAreaDao")
	private DaoInterface<FcArea> fcAreaDao;

	@Transactional
	public void saveClass(FcArea t) {
		fcAreaDao.saveClass(t);
	}

	@Transactional(readOnly = true)
	public List<FcArea> listClass() {
		return fcAreaDao.listClass();
	}

	@Transactional(readOnly = true)
	public List<FcArea> listPartData() {
		return fcAreaDao.listPartData();
	}

	@Transactional(readOnly = true)
	public FcArea getClass(String id) {
		return fcAreaDao.getclass(id);
	}

	@Transactional
	public void deleteClass(String id) {
		fcAreaDao.deleteClass(id);
	}

	@Transactional(readOnly = true)
	public List<FcArea> listPartDataById(String id) {
		return fcAreaDao.listPartDataById(id);
	}

}
