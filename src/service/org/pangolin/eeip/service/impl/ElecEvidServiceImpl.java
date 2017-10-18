package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ElecEvidDao;
import org.pangolin.eeip.entity.Evidence;
import org.pangolin.eeip.service.ElecEvidService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Service;

@Service("elecEvidService")
@SuppressWarnings("all")
public class ElecEvidServiceImpl implements ElecEvidService {

	@Resource
	private ElecEvidDao elecEvidDao;
	
	// 根据ID查询
	@Override
	public Evidence getElecEvidById(String id) {
		if(id != null){
			return this.elecEvidDao.get(Evidence.class, id);
		}
		return new Evidence();
	}

	//计算出附加限定条件params的所有数据总数和
	@Override
	public long count(String params) {
		params = "%" + params + "%";
		return this.elecEvidDao.count("select count(id) from elecEvid where name like ? or sn like ? or case_name like ?",new Object[]{params,params,params});
	}

	//计算出所有数据总数和
	@Override
	public long count() {
		return this.elecEvidDao.count("select count(id) from elecEvid");
	}

	//附加限定条件params，获取一组数据，包含指定开始坐标，总容量，分类关键字，排序属性
	@Override
	public List<Evidence> getElecEvids(String params, int startIndex, int rows,
			String sorter, String sortingAttribute) {
		params = "%" + params + "%";
		String hql = "from elecEvid where name like ? or sn like ? or case_name like ? order by "+sorter+ " "+sortingAttribute;
		return this.elecEvidDao.search(hql, new Object[]{params,params,params}, startIndex, rows);
	}

	//获取一组数据，包含指定开始坐标，总容量，分类关键字，排序属性
	@Override
	public List<Evidence> getElecEvids(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return elecEvidDao.search("from elecEvid order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}

	//给出id删除指定数据
	@Override
	public boolean remove(String id) {
		this.elecEvidDao.executeHql("delete from elecEvid where id = ?", new Object[]{id});
		Long count = elecEvidDao.count("select count(id) from elecEvid where id = ?",new Object[]{id});
		if(count.intValue() > 0){
			return false;
		}
		return true;
	}

	//新增或者修改数据
	@Override
	public boolean add(Evidence elecEvid) {
		String method = "";
		if(elecEvid.getId() == null){
			elecEvid.setId(UUIDHexGenerator.getInstance().generate());
			elecEvidDao.save(elecEvid);
			method = "add";
		}else{elecEvidDao.update(elecEvid);method = "update";}
		
		if ( method.equals("add") || method.equals("update") ) {
			 return true;
		} 
		return false;
	}

}
