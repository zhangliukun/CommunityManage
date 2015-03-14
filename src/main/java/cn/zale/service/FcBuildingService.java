package cn.zale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zale.Interface.DaoInterface;
import cn.zale.Interface.ServiceInterface;
import cn.zale.model.FcBuilding;

@Service("fcBuildingService")
public class FcBuildingService implements ServiceInterface<FcBuilding>{

	@Autowired
	@Qualifier("fcBuildingDao")
	DaoInterface<FcBuilding> fcBuildingDao;
	
	@Transactional
	public void saveClass(FcBuilding t) {
		fcBuildingDao.saveClass(t);
	}
	@Transactional(readOnly = true)
	public List<FcBuilding> listClass() {
		return fcBuildingDao.listClass();
	}
	@Transactional(readOnly = true)
	public List<FcBuilding> listPartData() {
		return fcBuildingDao.listPartData();
	}
	
	@Transactional(readOnly = true)
	public List<FcBuilding> listPartDataById(String id) {
		return fcBuildingDao.listPartDataById(id);
	}
	
	@Transactional(readOnly = true)
	public FcBuilding getClass(String id) {
		return fcBuildingDao.getclass(id);
	}
	@Transactional
	public void deleteClass(String id) {
		fcBuildingDao.deleteClass(id);
	}

}
