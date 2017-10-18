package org.pangolin.eeip.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.DevAttachmentDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.DevAttachment;
import org.pangolin.eeip.service.DevAttachmentService;
import org.springframework.stereotype.Service;

@Service("devAttachmentService")
@SuppressWarnings("all")
public class DevAttachmentServiceImpl implements DevAttachmentService{

	@Resource
	private DevAttachmentDao devAttachmentDao;
	
	 //根据ID查询
	@Override
	public DevAttachment getDevAttachmentById(String id) {
		return devAttachmentDao.get(DevAttachment.class, id);
	}
	
	//获取总数量
	@Override
	public Long getDevAttachmentQty(String deviceId,Integer type) {
		return devAttachmentDao.count("select count(id) from DevAttachment where deviceId = ? and type = ? and delFlag="+DevAttachment.NORMAL,new Object[]{ deviceId,type });
	} 
	
	//获取总集合
	@Override
	public List<DevAttachment> getDevAttachments() {
		return devAttachmentDao.find("from DevAttachment where delFlag="+DevAttachment.NORMAL+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<DevAttachment> getDevAttachments(int startIndex, int rows, String sorter, String sortingAttribute,String deviceId,Integer type) {
		return devAttachmentDao.search("from DevAttachment where deviceId = ? and type = ? and delFlag="+DevAttachment.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] { deviceId,type }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeDevAttachment(String id) {
		devAttachmentDao.executeHql("delete from DevAttachment where id = ?", new Object[] { id });
		Long qty = devAttachmentDao.count("select count(id) from DevAttachment where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeDevAttachmentFalse(String id) {
		Integer qty = devAttachmentDao.executeHql("update DevAttachment set delFlag= ? where id = ?", new Object[] { DevAttachment.REMOVED,id });
		if ( qty == 0 ) return false;
		return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveDevAttachment(DevAttachment devAttachment) {
		Integer type = devAttachment.getType();
		String deviceId = devAttachment.getDeviceId();
		try {
			if(type.equals(0) || type.equals(1) || type.equals(8)){  //普通  //外观  //随机技术文件
				devAttachmentDao.save(devAttachment);
			}else{  //其他档案
				DevAttachment attachment = devAttachmentDao.get("from DevAttachment where type=? and deviceId=?", new Object[]{type,deviceId});
				if(attachment != null && !"".equals(attachment.getId())){
					devAttachmentDao.delete(attachment);
				}
				devAttachmentDao.save(devAttachment);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	//获取全部附件根据字段
	@Override
	public List<DevAttachment> getDevAttachmentListByDeviceId(String deviceId) {
		List<DevAttachment> devAttachmentList = new ArrayList<DevAttachment>();
		devAttachmentList = devAttachmentDao.find("from DevAttachment where deviceId = ?", new Object[] { deviceId });
		List<DevAttachment> devAttachmens = new ArrayList<DevAttachment>();
		for (DevAttachment devAttachment : devAttachmentList) {
			devAttachmens.add(devAttachment);
		}
		return devAttachmentList;
	}

	@Override
	public DevAttachment getDevAttachmentByTypeAndDeviceId(Integer type, String deviceId) {
		List<DevAttachment> list = devAttachmentDao.find("from DevAttachment where deviceId = ? and type = ?", new Object[] { deviceId,type});
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}
	 
}
