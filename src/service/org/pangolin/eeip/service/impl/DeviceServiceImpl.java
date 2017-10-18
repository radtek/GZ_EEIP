package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DeviceDao;
import org.pangolin.eeip.entity.Device;
import org.pangolin.eeip.service.DeviceService;
import org.springframework.stereotype.Service;

@Service("deviceService")
@SuppressWarnings("all")
public class DeviceServiceImpl implements DeviceService{

	@Resource
	private DeviceDao deviceDao;
	
	 //根据ID查询
	@Override
	public Device getDeviceById(String id) {
		return deviceDao.get(Device.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDeviceQty(String extraParam) {
		StringBuffer hql=new StringBuffer();
		hql.append("select count(id) from Device where 1=1  ");
		if(null != extraParam && !"".equals(extraParam) ){
			extraParam = "%" + extraParam + "%";
			hql.append(" and (identifier  like '" + extraParam +"' or name like '"+ extraParam + "' or status like '"+ extraParam +"')");
		}
		return deviceDao.count(hql.toString()+" and delFlag=" + Device.NORMAL);
//		return deviceDao.count("select count(id) from Device where delFlag="+Device.NORMAL);
	} 
	
	//获取总集合
	@Override
	public List<Device> getDevices() {
		return deviceDao.find("from Device where delFlag="+Device.NORMAL+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<Device> getDevices(int startIndex, int rows, String sorter, String sortingAttribute,String extraParam) {
		StringBuffer hql=new StringBuffer();
		hql.append("  from Device where 1=1  ");
		if(null != extraParam && !"".equals(extraParam) ){
			extraParam = "%" + extraParam + "%";
			hql.append(" and (identifier  like '" + extraParam +"' or name like '"+ extraParam + "' or status like '"+ extraParam +"')");
		}
		return deviceDao.search(hql.toString()+" and delFlag=" + Device.NORMAL + " order by " + sorter
				+ " " + sortingAttribute, new Object[] {}, startIndex, rows);
	}
	
	//数据删除
	@Override
	public boolean removeDevice(String id) {
		deviceDao.executeHql("delete from Device where id = ?", new Object[] { id });
		Long qty = deviceDao.count("select count(id) from Device where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDeviceFalse(String id) {
			Integer qty = deviceDao.executeHql("update  Device set delFlag= ? where id = ?", new Object[] { Device.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevice(Device device) {
		try {
			String id = device.getId();
 			Long qty = deviceDao.count("select count(id) from Device where id=?", new Object[] {id});
 			if (qty > 0) {    
				deviceDao.update(device);
			} else {  
				deviceDao.save(device);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public List<Device> getNormalDevices() {
		return deviceDao.find("from Device where delFlag="+Device.NORMAL+" and status != 2 and status != 3 order by createdDate desc");
	}

	@Override
	public List<Device> getDeviceUseSituations() {
		return deviceDao.find("from Device where delFlag="+Device.NORMAL+"  group by name order by createdDate desc");
	}

	@Override
	public List<Device> getAppraisalDevices(String name) {
		return deviceDao.find("from Device where delFlag="+Device.NORMAL+" and name = '"+name+"'  and status != 2 and status != 3 order by createdDate desc");
	}
	 
}
