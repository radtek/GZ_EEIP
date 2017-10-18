package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevAdjPlanItemDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.DevAdjPlanItem;
import org.pangolin.eeip.service.DevAdjPlanItemService;
import org.springframework.stereotype.Service;

@Service("devAdjPlanItemService")
@SuppressWarnings("all")
public class DevAdjPlanItemServiceImpl implements DevAdjPlanItemService{

	@Resource
	private DevAdjPlanItemDao devAdjPlanItemDao;
	
	 //根据ID查询
	@Override
	public DevAdjPlanItem getDevAdjPlanItemById(String id) {
		return devAdjPlanItemDao.get(DevAdjPlanItem.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevAdjPlanItemQty(String adjId,String devId) {
		return devAdjPlanItemDao.count("select count(id) from DevAdjPlanItem where delFlag="+DevAdjPlanItem.NORMAL+"and devAdjPlanId = ?  and deviceId = ?", new Object[] { adjId,devId });
	} 
	
	//获取总集合
	@Override
	public List<DevAdjPlanItem> getDevAdjPlanItems() {
		return devAdjPlanItemDao.find("from DevAdjPlanItem where delFlag="+DevAdjPlanItem.NORMAL+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<DevAdjPlanItem> getDevAdjPlanItems(int startIndex, int rows, String sorter, String sortingAttribute,String adjId,String devId) {
		return devAdjPlanItemDao.search("from DevAdjPlanItem where delFlag="+DevAdjPlanItem.NORMAL+"and devAdjPlanId = ?  and deviceId = ? order by " + sorter + " " + sortingAttribute, new Object[] { adjId,devId }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevAdjPlanItem(String id) {
		devAdjPlanItemDao.executeHql("delete from DevAdjPlanItem where id = ?", new Object[] { id });
		Long qty = devAdjPlanItemDao.count("select count(id) from DevAdjPlanItem where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevAdjPlanItemFalse(String id) {
			Integer qty = devAdjPlanItemDao.executeHql("update DevAdjPlanItem set delFlag= ? where id = ?", new Object[] { DevAdjPlanItem.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevAdjPlanItem(DevAdjPlanItem devAdjPlanItem) {
		String method = "";
		if ( devAdjPlanItem.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		devAdjPlanItemDao.saveOrUpdate(devAdjPlanItem);
		if ( method.equals("add") ) {
			if ( devAdjPlanItem.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}

	@Override
	public DevAdjPlanItem getDevAdjPlanByDevPlanId(String devicePlanId) {
		List<DevAdjPlanItem> list = devAdjPlanItemDao.find("from DevAdjPlanItem where devAdjPlanId = ?", new Object[] { devicePlanId });
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	 
}
