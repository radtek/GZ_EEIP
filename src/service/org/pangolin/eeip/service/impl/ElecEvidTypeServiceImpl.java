package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ElecEvidTypeDao;
import org.pangolin.eeip.entity.EvidType;
import org.pangolin.eeip.service.ElecEvidTypeService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Service;

@Service("elecEvidTypeService")
@SuppressWarnings("all")
public class ElecEvidTypeServiceImpl implements ElecEvidTypeService {

	@Resource
	private ElecEvidTypeDao elecEvidTypeDao;
	
	// 根据ID查询
	@Override
	public EvidType getElecEvidTypeById(String id) {
		if(id != null){
			return this.elecEvidTypeDao.get(EvidType.class, id);
		}
		return new EvidType();
	}

	//计算出附加限定条件params的所有数据总数和
	@Override
	public long count(String params) {
		params = "%" + params + "%";
		return this.elecEvidTypeDao.count("select count(id) from ElecEvidType where name like ? or sn like ? or delFlag like ?",new Object[]{params,params,params});
	}

	//计算出所有数据总数和
	@Override
	public long count() {
		return this.elecEvidTypeDao.count("select count(id) from ElecEvidType");
	}

	//附加限定条件params，获取一组数据，包含指定开始坐标，总容量，分类关键字，排序属性
	@Override
	public List<EvidType> getElecEvidTypes(String params, int startIndex, int rows,
			String sorter, String sortingAttribute) {
		params = "%" + params + "%";
		String hql = "from ElecEvidType where name like ? or sn like ? or delFlag like ? order by "+sorter+ " "+sortingAttribute;
		return this.elecEvidTypeDao.search(hql, new Object[]{params,params,params}, startIndex, rows);
	}

	//获取一组数据，包含指定开始坐标，总容量，分类关键字，排序属性
	@Override
	public List<EvidType> getElecEvidTypes(int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return elecEvidTypeDao.search("from ElecEvidType order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}

	//给出id删除指定数据
	@Override
	public boolean remove(String id) {
		this.elecEvidTypeDao.executeHql("delete from ElecEvidType where id = ?", new Object[]{id});
		Long count = elecEvidTypeDao.count("select count(id) from ElecEvidType where id = ?",new Object[]{id});
		if(count.intValue() > 0){
			return false;
		}
		return true;
	}

	//新增或者修改数据
	@Override
	public boolean add(EvidType elecEvidType) {
		String method = "";
		if(elecEvidType.getId() == null){
			elecEvidType.setId(UUIDHexGenerator.getInstance().generate());
			elecEvidTypeDao.save(elecEvidType);
			method = "add";
		}else{elecEvidTypeDao.update(elecEvidType);method = "update";}
		
		if ( method.equals("add") || method.equals("update") ) {
			 return true;
		} 
		return false;
	}

}
