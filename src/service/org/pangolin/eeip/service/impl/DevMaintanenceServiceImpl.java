package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevMaintanenceDao;
import org.pangolin.eeip.entity.DevMaintanence;
import org.pangolin.eeip.service.DevMaintanenceService;
import org.springframework.stereotype.Service;

@Service("devMaintanenceService")
@SuppressWarnings("all")
public class DevMaintanenceServiceImpl implements DevMaintanenceService{

	@Resource
	private DevMaintanenceDao devMaintanenceDao;
	
	 //根据ID查询
	@Override
	public DevMaintanence getDevMaintanenceById(String id) {
		return devMaintanenceDao.get(DevMaintanence.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevMaintanenceQty(String devId) {
		return devMaintanenceDao.count("select count(id) from DevMaintanence where delFlag="+DevMaintanence.NORMAL+"and deviceId = ?" , new Object[] { devId });
	} 
	
	//获取总集合
	@Override
	public List<DevMaintanence> getDevMaintanences(String id) {
		return devMaintanenceDao.find("from DevMaintanence where deviceId = ? and delFlag="+DevMaintanence.NORMAL+" order by createdDate desc", new Object[] { id });
	}
	
	//分页查询
	@Override
	public List<DevMaintanence> getDevMaintanences(int startIndex, int rows, String sorter, String sortingAttribute,String devId) {
		return devMaintanenceDao.search("from DevMaintanence where delFlag="+DevMaintanence.NORMAL+"and deviceId=? order by " + sorter + " " + sortingAttribute, new Object[] { devId }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevMaintanence(String id) {
		devMaintanenceDao.executeHql("delete from DevMaintanence where id = ?", new Object[] { id });
		Long qty = devMaintanenceDao.count("select count(id) from DevMaintanence where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevMaintanenceFalse(String id) {
			Integer qty = devMaintanenceDao.executeHql("update DevMaintanence set delFlag= ? where id = ?", new Object[] { DevMaintanence.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevMaintanence(DevMaintanence devMaintanence) {
		String method = "";
		if ( devMaintanence.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		devMaintanenceDao.saveOrUpdate(devMaintanence);
		if ( method.equals("add") ) {
			if ( devMaintanence.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}
	 
}
