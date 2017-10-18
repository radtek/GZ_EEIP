package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevUsingSitnDao;
import org.pangolin.eeip.entity.DevUsingSitn;
import org.pangolin.eeip.service.DevUsingSitnService;
import org.springframework.stereotype.Service;

@Service("devUsingSitnService")
@SuppressWarnings("all")
public class DevUsingSitnServiceImpl implements DevUsingSitnService{

	@Resource
	private DevUsingSitnDao devUsingSitnDao;
	
	 //根据ID查询
	@Override
	public DevUsingSitn getDevUsingSitnById(String id) {
		return devUsingSitnDao.get(DevUsingSitn.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevUsingSitnQty(String devId) {
		return devUsingSitnDao.count("select count(id) from DevUsingSitn where delFlag="+DevUsingSitn.NORMAL+"and deviceId = ?",new Object[]{ devId });
	} 
	
	//获取总集合
	@Override
	public List<DevUsingSitn> getDevUsingSitns(String id) {
		return devUsingSitnDao.find("from DevUsingSitn where deviceId = ? and delFlag="+DevUsingSitn.NORMAL+" order by createdDate desc",new Object[]{id});
	}
	
	//分页查询
	@Override
	public List<DevUsingSitn> getDevUsingSitns(int startIndex, int rows, String sorter, String sortingAttribute,String devId) {
		return devUsingSitnDao.search("from DevUsingSitn where delFlag="+DevUsingSitn.NORMAL+"and deviceId = ? order by " + sorter + " " + sortingAttribute, new Object[] { devId }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevUsingSitn(String id) {
		devUsingSitnDao.executeHql("delete from DevUsingSitn where id = ?", new Object[] { id });
		Long qty = devUsingSitnDao.count("select count(id) from DevUsingSitn where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevUsingSitnFalse(String id) {
			Integer qty = devUsingSitnDao.executeHql("update DevUsingSitn set delFlag= ? where id = ?", new Object[] { DevUsingSitn.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevUsingSitn(DevUsingSitn devUsingSitn) {
		String method = "";
		if ( devUsingSitn.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		devUsingSitnDao.saveOrUpdate(devUsingSitn);
		if ( method.equals("add") ) {
			if ( devUsingSitn.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}
	 
}
