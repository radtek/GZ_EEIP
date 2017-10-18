package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevAdjPlanDao;
import org.pangolin.eeip.dao.DeviceDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.DevAdjPlan;
import org.pangolin.eeip.entity.Device;
import org.pangolin.eeip.entity.Visitor;
import org.pangolin.eeip.service.DevAdjPlanService;
import org.springframework.stereotype.Service;

@Service("devAdjPlanService")
@SuppressWarnings("all")
public class DevAdjPlanServiceImpl implements DevAdjPlanService{

	@Resource
	private DevAdjPlanDao devAdjPlanDao;
	@Resource
	private DeviceDao deviceDao;
	
	 //根据ID查询
	@Override
	public DevAdjPlan getDevAdjPlanById(String id) {
		return devAdjPlanDao.get(DevAdjPlan.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevAdjPlanQty(String devId) {
		return devAdjPlanDao.count("select count(id) from DevAdjPlan where delFlag="+DevAdjPlan.NORMAL+"and deviceId=?", new Object[] { devId });
	} 
	
	//获取总集合
	@Override
	public List<DevAdjPlan> getDevAdjPlans() {
		return devAdjPlanDao.find("from DevAdjPlan where delFlag="+DevAdjPlan.NORMAL+"order by createdDate desc");
	}
	
	//获取总集合
	@Override
	public List<DevAdjPlan> getDevAdjPlansByStatus() {
		return devAdjPlanDao.find("from DevAdjPlan where delFlag="+DevAdjPlan.NORMAL+"and status = "+DevAdjPlan.PENDING+"order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<DevAdjPlan> getDevAdjPlans(int startIndex, int rows, String sorter, String sortingAttribute,String devId) {
		return devAdjPlanDao.search("from DevAdjPlan where delFlag="+DevAdjPlan.NORMAL+"and deviceId = ? order by " + sorter + " " + sortingAttribute, new Object[] { devId }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevAdjPlan(String id) {
		devAdjPlanDao.executeHql("delete from DevAdjPlan where id = ?", new Object[] { id });
		Long qty = devAdjPlanDao.count("select count(id) from DevAdjPlan where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevAdjPlanFalse(String id) {
			Integer qty = devAdjPlanDao.executeHql("update DevAdjPlan set delFlag= ? where id = ?", new Object[] { DevAdjPlan.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevAdjPlan(DevAdjPlan devAdjPlan) {
		try {
			String id = devAdjPlan.getId();
 			Long qty = devAdjPlanDao.count("select count(id) from DevAdjPlan where id=?", new Object[] {id});
 			//device.setAssetIds(convertToJSON(device.getAssetIds()));
 			//event.setAssetIds(convertToJSON(event.getAssetIds()));
 			if (qty > 0) {    
 				devAdjPlanDao.update(devAdjPlan);
			} else {  
				devAdjPlanDao.save(devAdjPlan);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public List<DevAdjPlan> getDevAdjPlanByQueryParam(String extraParam) {
		List<DevAdjPlan> list = new ArrayList<DevAdjPlan>();
		List<DevAdjPlan> adjList = devAdjPlanDao.find("from DevAdjPlan where delFlag=" + DevAdjPlan.NORMAL);
		if(null != extraParam && !"".equals(extraParam) ){
			for (DevAdjPlan devAdjPlan : adjList) {
				Device device = deviceDao.get(Device.class, devAdjPlan.getDeviceId());
				if(device != null){
					if(device.getIdentifier().contains(extraParam)){
						list.add(devAdjPlan);
						continue;
					}else if(device.getName().contains(extraParam)){
						list.add(devAdjPlan);
						continue;
					}
				}
			}
		}else{
			list.addAll(adjList);
		}
		return list;
	}
	 
}
