package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.axis2.databinding.types.soapencoding.Array;
import org.pangolin.eeip.dao.DevAdjustmentSitnDao;
import org.pangolin.eeip.dao.DeviceDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.DevAdjustmentSitn;
import org.pangolin.eeip.entity.Device;
import org.pangolin.eeip.entity.Visitor;
import org.pangolin.eeip.service.DevAdjustmentSitnService;
import org.springframework.stereotype.Service;

@Service("devAdjustmentSitnService")
@SuppressWarnings("all")
public class DevAdjustmentSitnServiceImpl implements DevAdjustmentSitnService{

	@Resource
	private DevAdjustmentSitnDao devAdjustmentSitnDao;
	@Resource
	private DeviceDao deviceDao;
	
	 //根据ID查询
	@Override
	public DevAdjustmentSitn getDevAdjustmentSitnById(String id) {
		return devAdjustmentSitnDao.get(DevAdjustmentSitn.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevAdjustmentSitnQty() {
		return devAdjustmentSitnDao.count("select count(id) from DevAdjustmentSitn where delFlag="+DevAdjustmentSitn.NORMAL);
	} 
	
	//获取总集合
	@Override
	public List<DevAdjustmentSitn> getDevAdjustmentSitns() {
		return devAdjustmentSitnDao.find("from DevAdjustmentSitn where delFlag="+DevAdjustmentSitn.NORMAL+" order by createdDate desc");
	}
	
	//获取待审批的数量
	@Override
	public List<DevAdjustmentSitn> getDevAdjustmentSitnsByStatus() {
		return devAdjustmentSitnDao.find("from DevAdjustmentSitn where delFlag="+DevAdjustmentSitn.NORMAL+"and status = "+DevAdjustmentSitn.PENDING+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<DevAdjustmentSitn> getDevAdjustmentSitns(int startIndex, int rows, String sorter, String sortingAttribute,String devId) {
		return devAdjustmentSitnDao.search("from DevAdjustmentSitn where delFlag="+DevAdjustmentSitn.NORMAL+"and deviceId = ? order by " + sorter + " " + sortingAttribute, new Object[] { devId }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevAdjustmentSitn(String id) {
		devAdjustmentSitnDao.executeHql("delete from DevAdjustmentSitn where id = ?", new Object[] { id });
		Long qty = devAdjustmentSitnDao.count("select count(id) from DevAdjustmentSitn where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevAdjustmentSitnFalse(String id) {
			Integer qty = devAdjustmentSitnDao.executeHql("update DevAdjustmentSitn set delFlag= ? where id = ?", new Object[] { DevAdjustmentSitn.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevAdjustmentSitn(DevAdjustmentSitn devAdjustmentSitn) {
		String method = "";
		if ( devAdjustmentSitn.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		devAdjustmentSitnDao.saveOrUpdate(devAdjustmentSitn);
		if ( method.equals("add") ) {
			if ( devAdjustmentSitn.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}

	@Override
	public List<DevAdjustmentSitn> getDevAdjustmentSitnByQueryParam(String extraParam) {
		List<DevAdjustmentSitn> list = new ArrayList<DevAdjustmentSitn>();
		List<DevAdjustmentSitn> adjList = devAdjustmentSitnDao.find("from DevAdjustmentSitn where delFlag=" + DevAdjustmentSitn.NORMAL);
		if(null != extraParam && !"".equals(extraParam) ){
			for (DevAdjustmentSitn devAdjustmentSitn : adjList) {
				Device device = deviceDao.get(Device.class, devAdjustmentSitn.getDeviceId());
				if(device != null){
					if(device.getIdentifier().contains(extraParam)){
						list.add(devAdjustmentSitn);
						continue;
					}else if(device.getName().contains(extraParam)){
						list.add(devAdjustmentSitn);
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
