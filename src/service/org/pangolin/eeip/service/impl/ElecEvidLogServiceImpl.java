package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ElecEvidLogDao;
import org.pangolin.eeip.entity.EvidOpLog;
import org.pangolin.eeip.service.ElecEvidLogService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Service;

@Service("elecEvidLogService")
@SuppressWarnings("all")
public class ElecEvidLogServiceImpl implements ElecEvidLogService {

	@Resource
	private ElecEvidLogDao elecEvidLogDao;
	
	// 根据ID查询
	@Override
	public EvidOpLog getElecEvidLogById(String id) {
		if(id != null){
			return this.elecEvidLogDao.get(EvidOpLog.class, id);
		}
		return new EvidOpLog();
	}
	

	//计算出附加限定条件params的所有数据总数和
	@Override
	public long count(String params) {
		params = "%" + params + "%";
		return this.elecEvidLogDao.count("select count(id) from ElecEvidLog where evidName like ? or evidSn like ? or caseName like ?",new Object[]{params,params,params});
	}

	//计算出所有数据总数和
	@Override
	public long count() {
		return this.elecEvidLogDao.count("select count(id) from ElecEvidLog");
	}

	//附加限定条件params，获取一组数据，包含指定开始坐标，总容量，分类关键字，排序属性
	@Override
	public List<EvidOpLog> getElecEvidLogs(String params, int startIndex, int rows,
			String sorter, String sortingAttribute) {
		params = "%" + params + "%";
		String hql = "from ElecEvidLog where evidName like ? or evidSn like ? or caseName like ? order by "+sorter+ " "+sortingAttribute;
		return this.elecEvidLogDao.search(hql, new Object[]{params,params,params}, startIndex, rows);
	}

	//获取一组数据，包含指定开始坐标，总容量，分类关键字，排序属性
	@Override
	public List<EvidOpLog> getElecEvidLogs(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return elecEvidLogDao.search("from ElecEvidLog order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}

	//给出id删除指定数据
	@Override
	public boolean remove(String id) {
		this.elecEvidLogDao.executeHql("delete from ElecEvidLog where id = ?", new Object[]{id});
		Long count = elecEvidLogDao.count("select count(id) from ElecEvidLog where id = ?",new Object[]{id});
		if(count.intValue() > 0){
			return false;
		}
		return true;
	}

	//新增或者修改数据
	@Override
	public boolean add(EvidOpLog elecEvidLog) {
		String method = "";
		if(elecEvidLog.getId() == null){
			elecEvidLog.setId(UUIDHexGenerator.getInstance().generate());
			elecEvidLogDao.save(elecEvidLog);
			method = "add";
		}else{elecEvidLogDao.update(elecEvidLog);method = "update";}
		
		if ( method.equals("add") || method.equals("update") ) {
			 return true;
		} 
		return false;
	}



}
