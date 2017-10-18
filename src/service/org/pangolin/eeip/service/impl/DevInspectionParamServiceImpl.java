package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevInspectionParamDao;
import org.pangolin.eeip.entity.DevInspectionParam;
import org.pangolin.eeip.service.DevInspectionParamService;
import org.springframework.stereotype.Service;

@Service("devInspectionParamService")
@SuppressWarnings("all")
public class DevInspectionParamServiceImpl implements DevInspectionParamService{

	@Resource
	private DevInspectionParamDao devInspectionParamDao;
	
	 //根据ID查询
	@Override
	public DevInspectionParam getDevInspectionParamById(String id) {
		return devInspectionParamDao.get(DevInspectionParam.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevInspectionParamQty(String devId,String devInspectionId) {
		return devInspectionParamDao.count("select count(id) from DevInspectionParam where delFlag="+DevInspectionParam.NORMAL+"and deviceId = ? and devInspectionId = ? ",new Object[]{ devId,devInspectionId });
	} 
	
	//获取总集合
	@Override
	public List<DevInspectionParam> getDevInspectionParams() {
		return devInspectionParamDao.find("from DevInspectionParam where delFlag="+DevInspectionParam.NORMAL+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<DevInspectionParam> getDevInspectionParams(int startIndex, int rows, String sorter, String sortingAttribute,String devId,String devInspectionId) {
		return devInspectionParamDao.search("from DevInspectionParam where delFlag="+DevInspectionParam.NORMAL+"and deviceId = ? and devInspectionId = ? order by " + sorter + " " + sortingAttribute, new Object[] { devId,devInspectionId }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevInspectionParam(String id) {
		devInspectionParamDao.executeHql("delete from DevInspectionParam where id = ?", new Object[] { id });
		Long qty = devInspectionParamDao.count("select count(id) from DevInspectionParam where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevInspectionParamFalse(String id) {
			Integer qty = devInspectionParamDao.executeHql("update DevInspectionParam set delFlag= ? where id = ?", new Object[] { DevInspectionParam.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevInspectionParam(DevInspectionParam devInspectionParam) {
		String method = "";
		if ( devInspectionParam.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		devInspectionParamDao.saveOrUpdate(devInspectionParam);
		if ( method.equals("add") ) {
			if ( devInspectionParam.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}
	 
}
