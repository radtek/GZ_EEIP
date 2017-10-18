package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevInspectionDao;
import org.pangolin.eeip.entity.DevInspection;
import org.pangolin.eeip.service.DevInspectionService;
import org.springframework.stereotype.Service;

@Service("devInspectionService")
@SuppressWarnings("all")
public class DevInspectionServiceImpl implements DevInspectionService{

	@Resource
	private DevInspectionDao devInspectionDao;
	
	 //根据ID查询
	@Override
	public DevInspection getDevInspectionById(String id) {
		return devInspectionDao.get(DevInspection.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevInspectionQty(String devId) {
		return devInspectionDao.count("select count(id) from DevInspection where delFlag="+DevInspection.NORMAL+"and deviceId=?" , new Object[] { devId });
	} 
	
	//获取总集合
	@Override
	public List<DevInspection> getDevInspections(String id) {
		return devInspectionDao.find("from DevInspection where deviceId=? and delFlag="+DevInspection.NORMAL+" order by createdDate desc", new Object[] { id });
	}
	
	//分页查询
	@Override
	public List<DevInspection> getDevInspections(int startIndex, int rows, String sorter, String sortingAttribute,String devId) {
		return devInspectionDao.search("from DevInspection where delFlag="+DevInspection.NORMAL+"and deviceId = ? order by " + sorter + " " + sortingAttribute, new Object[] { devId  }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevInspection(String id) {
		devInspectionDao.executeHql("delete from DevInspection where id = ?", new Object[] { id });
		Long qty = devInspectionDao.count("select count(id) from DevInspection where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevInspectionFalse(String id) {
			Integer qty = devInspectionDao.executeHql("update DevInspection set delFlag= ? where id = ?", new Object[] { DevInspection.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevInspection(DevInspection devInspection) {
		try {
			String id = devInspection.getId();
 			Long qty = devInspectionDao.count("select count(id) from DevInspection where id=?", new Object[] {id});
 			if (qty > 0) {    
 				devInspectionDao.update(devInspection);
			} else {  
				devInspectionDao.save(devInspection);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}
	 
}
