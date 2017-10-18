package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevAdjAppDao;
import org.pangolin.eeip.dao.DeviceDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.DevAdjApp;
import org.pangolin.eeip.entity.DevAdjApp;
import org.pangolin.eeip.entity.Device;
import org.pangolin.eeip.service.DevAdjAppService;
import org.springframework.stereotype.Service;

@Service("devAdjAppService")
@SuppressWarnings("all")
public class DevAdjAppServiceImpl implements DevAdjAppService{

	@Resource
	private DevAdjAppDao devAdjAppDao;
	@Resource
	private DeviceDao deviceDao;
	
	 //根据ID查询
	@Override
	public DevAdjApp getDevAdjAppById(String id) {
		return devAdjAppDao.get(DevAdjApp.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevAdjAppQty(String devId) {
		return devAdjAppDao.count("select count(id) from DevAdjApp where delFlag="+DevAdjApp.NORMAL+"and deviceId = ?",new Object[]{ devId });
	} 
	
	//获取总集合
	@Override
	public List<DevAdjApp> getDevAdjApps() {
		return devAdjAppDao.find("from DevAdjApp where delFlag="+DevAdjApp.NORMAL+" order by createdDate desc");
	}
	
	//获取总集合
	@Override
	public List<DevAdjApp> getDevAdjAppByStatus() {
		return devAdjAppDao.find("from DevAdjApp where delFlag="+DevAdjApp.NORMAL+"and status = "+DevAdjApp.PENDING+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<DevAdjApp> getDevAdjApps(int startIndex, int rows, String sorter, String sortingAttribute,String devId) {
		return devAdjAppDao.search("from DevAdjApp where delFlag="+DevAdjApp.NORMAL+"and deviceId = ? order by " + sorter + " " + sortingAttribute, new Object[] { devId }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevAdjApp(String id) {
		devAdjAppDao.executeHql("delete from DevAdjApp where id = ?", new Object[] { id });
		Long qty = devAdjAppDao.count("select count(id) from DevAdjApp where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevAdjAppFalse(String id) {
			Integer qty = devAdjAppDao.executeHql("update DevAdjApp set delFlag= ? where id = ?", new Object[] { DevAdjApp.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevAdjApp(DevAdjApp devAdjApp) {
		String method = "";
		if ( devAdjApp.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		devAdjAppDao.saveOrUpdate(devAdjApp);
		if ( method.equals("add") ) {
			if ( devAdjApp.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}

	@Override
	public List<DevAdjApp> getDevAdjAppByQueryParam(String extraParam) {
		List<DevAdjApp> list = new ArrayList<DevAdjApp>();
		List<DevAdjApp> adjList = devAdjAppDao.find("from DevAdjApp where delFlag=" + DevAdjApp.NORMAL);
		if(null != extraParam && !"".equals(extraParam) ){
			for (DevAdjApp devAdjApp : adjList) {
				Device device = deviceDao.get(Device.class, devAdjApp.getDeviceId());
				if(device != null){
					if(device.getIdentifier().contains(extraParam)){
						list.add(devAdjApp);
						continue;
					}else if(device.getName().contains(extraParam)){
						list.add(devAdjApp);
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
