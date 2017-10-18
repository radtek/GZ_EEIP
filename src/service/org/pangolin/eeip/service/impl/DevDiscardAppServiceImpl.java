package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevDiscardAppDao;
import org.pangolin.eeip.dao.DeviceDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.DevDiscardApp;
import org.pangolin.eeip.entity.DevDiscardApp;
import org.pangolin.eeip.entity.Device;
import org.pangolin.eeip.service.DevDiscardAppService;
import org.springframework.stereotype.Service;

@Service("devDiscardAppService")
@SuppressWarnings("all")
public class DevDiscardAppServiceImpl implements DevDiscardAppService{

	@Resource
	private DevDiscardAppDao devDiscardAppDao;
	@Resource
	private DeviceDao deviceDao;
	
	 //根据ID查询
	@Override
	public DevDiscardApp getDevDiscardAppById(String id) {
		return devDiscardAppDao.get(DevDiscardApp.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevDiscardAppQty() {
		return devDiscardAppDao.count("select count(id) from DevDiscardApp where delFlag="+DevDiscardApp.NORMAL);
	} 
	
	//获取总集合
	@Override
	public List<DevDiscardApp> getDevDiscardApps() {
		return devDiscardAppDao.find("from DevDiscardApp where delFlag="+DevDiscardApp.NORMAL+" order by createdDate desc");
	}
	
	//获取总集合
	@Override
	public List<DevDiscardApp> getDevDiscardAppByStatus() {
		return devDiscardAppDao.find("from DevDiscardApp where delFlag="+DevDiscardApp.NORMAL+"and status = "+DevDiscardApp.PENDING+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<DevDiscardApp> getDevDiscardApps(int startIndex, int rows, String sorter, String sortingAttribute) {
		return devDiscardAppDao.search("from DevDiscardApp where delFlag="+DevDiscardApp.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevDiscardApp(String id) {
		devDiscardAppDao.executeHql("delete from DevDiscardApp where id = ?", new Object[] { id });
		Long qty = devDiscardAppDao.count("select count(id) from DevDiscardApp where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevDiscardAppFalse(String id) {
			Integer qty = devDiscardAppDao.executeHql("update DevDiscardApp set delFlag= ? where id = ?", new Object[] { DevDiscardApp.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevDiscardApp(DevDiscardApp devDiscardApp) {
		String method = "";
		if ( devDiscardApp.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		devDiscardAppDao.saveOrUpdate(devDiscardApp);
		if ( method.equals("add") ) {
			if ( devDiscardApp.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}

	@Override
	public DevDiscardApp getDevDiscardAppByDeviceId(String deviceId) {
		List<DevDiscardApp> list = devDiscardAppDao.find("from DevDiscardApp where deviceId = ? and delFlag="+DevDiscardApp.NORMAL + "and status in ( '0', '1', '2' )",new Object[]{deviceId});
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<DevDiscardApp> getDevDiscardAppByQueryParam(String extraParam) {
		List<DevDiscardApp> list = new ArrayList<DevDiscardApp>();
		List<DevDiscardApp> adjList = devDiscardAppDao.find("from DevDiscardApp where delFlag=" + DevDiscardApp.NORMAL);
		if(null != extraParam && !"".equals(extraParam) ){
			for (DevDiscardApp devDiscardApp : adjList) {
				Device device = deviceDao.get(Device.class, devDiscardApp.getDeviceId());
				if(device != null){
					if(device.getIdentifier().contains(extraParam)){
						list.add(devDiscardApp);
						continue;
					}else if(device.getName().contains(extraParam)){
						list.add(devDiscardApp);
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
