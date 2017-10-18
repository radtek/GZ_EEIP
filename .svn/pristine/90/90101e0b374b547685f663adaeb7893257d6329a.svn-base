package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevBorrowAppDao;
import org.pangolin.eeip.dao.DeviceDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.DevBorrowApp;
import org.pangolin.eeip.entity.DevBorrowApp;
import org.pangolin.eeip.entity.Device;
import org.pangolin.eeip.entity.Visitor;
import org.pangolin.eeip.service.DevBorrowAppService;
import org.springframework.stereotype.Service;

@Service("devBorrowAppService")
@SuppressWarnings("all")
public class DevBorrowAppServiceImpl implements DevBorrowAppService{

	@Resource
	private DevBorrowAppDao devBorrowAppDao;
	@Resource
	private DeviceDao deviceDao;
	
	 //根据ID查询
	@Override
	public DevBorrowApp getDevBorrowAppById(String id) {
		return devBorrowAppDao.get(DevBorrowApp.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevBorrowAppQty() {
		return devBorrowAppDao.count("select count(id) from DevBorrowApp where delFlag="+DevBorrowApp.NORMAL);
	} 
	
	//获取总集合
	@Override
	public List<DevBorrowApp> getDevBorrowApps() {
		return devBorrowAppDao.find("from DevBorrowApp where delFlag="+DevBorrowApp.NORMAL+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<DevBorrowApp> getDevBorrowApps(int startIndex, int rows, String sorter, String sortingAttribute,String extraParam) {
		List<DevBorrowApp> list = new ArrayList<DevBorrowApp>();
		List<DevBorrowApp> adjList = devBorrowAppDao.find("from DevBorrowApp where delFlag=" + DevBorrowApp.NORMAL);
		if(null != extraParam && !"".equals(extraParam) ){
			for (DevBorrowApp devBorrowApp : adjList) {
				if(devBorrowApp.getName().contains(extraParam)){
					list.add(devBorrowApp);
					continue;
				}
				Device device = deviceDao.get(Device.class, devBorrowApp.getDeviceId());
				if(device != null){
					if(device.getIdentifier().contains(extraParam)){
						list.add(devBorrowApp);
						continue;
					}
				}
			}
		}else{
			list.addAll(adjList);
		}
		return list;
//		devBorrowAppDao.search("from DevBorrowApp where delFlag="+DevBorrowApp.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevBorrowApp(String id) {
		devBorrowAppDao.executeHql("delete from DevBorrowApp where id = ?", new Object[] { id });
		Long qty = devBorrowAppDao.count("select count(id) from DevBorrowApp where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevBorrowAppFalse(String id) {
			Integer qty = devBorrowAppDao.executeHql("update DevBorrowApp set delFlag= ? where id = ?", new Object[] { DevBorrowApp.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevBorrowApp(DevBorrowApp devBorrowApp) {
		String method = "";
		if ( devBorrowApp.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		devBorrowAppDao.saveOrUpdate(devBorrowApp);
		if ( method.equals("add") ) {
			if ( devBorrowApp.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}
	 
}
