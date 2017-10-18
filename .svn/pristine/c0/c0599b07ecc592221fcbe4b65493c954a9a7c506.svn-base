package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevSwUpgradeDao;
import org.pangolin.eeip.entity.DevSwUpgrade;
import org.pangolin.eeip.service.DevSwUpgradeService;
import org.springframework.stereotype.Service;

@Service("devSwUpgradeService")
@SuppressWarnings("all")
public class DevSwUpgradeServiceImpl implements DevSwUpgradeService{

	@Resource
	private DevSwUpgradeDao devSwUpgradeDao;
	
	 //根据ID查询
	@Override
	public DevSwUpgrade getDevSwUpgradeById(String id) {
		return devSwUpgradeDao.get(DevSwUpgrade.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevSwUpgradeQty(String devId) {
		return devSwUpgradeDao.count("select count(id) from DevSwUpgrade where delFlag="+DevSwUpgrade.NORMAL+"and deviceId = ?", new Object[]{ devId });
	} 
	
	//获取总集合
	@Override
	public List<DevSwUpgrade> getDevSwUpgrades(String id) {
		return devSwUpgradeDao.find("from DevSwUpgrade where deviceId = ? and delFlag="+DevSwUpgrade.NORMAL+" order by createdDate desc", new Object[]{ id });
	}
	
	//分页查询
	@Override
	public List<DevSwUpgrade> getDevSwUpgrades(int startIndex, int rows, String sorter, String sortingAttribute,String devId) {
		return devSwUpgradeDao.search("from DevSwUpgrade where delFlag="+DevSwUpgrade.NORMAL+"and deviceId = ? order by " + sorter + " " + sortingAttribute, new Object[] { devId }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevSwUpgrade(String id) {
		devSwUpgradeDao.executeHql("delete from DevSwUpgrade where id = ?", new Object[] { id });
		Long qty = devSwUpgradeDao.count("select count(id) from DevSwUpgrade where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevSwUpgradeFalse(String id) {
			Integer qty = devSwUpgradeDao.executeHql("update DevSwUpgrade set delFlag= ? where id = ?", new Object[] { DevSwUpgrade.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevSwUpgrade(DevSwUpgrade devSwUpgrade) {
		String method = "";
		if ( devSwUpgrade.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		devSwUpgradeDao.saveOrUpdate(devSwUpgrade);
		if ( method.equals("add") ) {
			if ( devSwUpgrade.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}
	 
}
