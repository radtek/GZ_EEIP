package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.EvidTransitionDao;
import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.EvidTransition;
import org.pangolin.eeip.service.EvidTransitionService;
import org.pangolin.util.UUIDHexGenerator;
import org.springframework.stereotype.Service;

@Service("evidTransitionService")
@SuppressWarnings("all")
public class EvidTransitionServiceImpl implements EvidTransitionService {

	@Resource
	private EvidTransitionDao evidTransitionDao;
	
	// 根据ID查询
	@Override
	public EvidTransition getEvidTransitionById(String id) {
		if(id != null){
			return this.evidTransitionDao.get(EvidTransition.class, id);
		}
		return new EvidTransition();
	}


	@Override
	public EvidTransition getEvidTransitionByPreappraisalId(String preappraisalId) {
		return evidTransitionDao.get(" from EvidTransition where where preappraisalId =? ", new Object[]{preappraisalId});
	}
	
	//计算出附加限定条件params的所有数据总数和
	@Override
	public long count(String params) {
		params = "%" + params + "%";
		return this.evidTransitionDao.count("select count(id) from EvidTransition where evidName like ? or evidSn like ? or caseName like ?",new Object[]{params,params,params});
	}

	//计算出所有数据总数和
	@Override
	public long count() {
		return this.evidTransitionDao.count("select count(id) from EvidTransition ");
	}

	//附加限定条件params，获取一组数据，包含指定开始坐标，总容量，分类关键字，排序属性
	@Override
	public List<EvidTransition> getEvidTransitions(Integer status,String params, int startIndex, int rows,
			String sorter, String sortingAttribute) {
		params = "%" + params + "%";
		String hql = "from EvidTransition where status=? and ( evidName like ? or evidSn like ? or caseName like ? ) order by "+sorter+ " "+sortingAttribute;
		return this.evidTransitionDao.search(hql, new Object[]{status,params,params,params}, startIndex, rows);
	}

	//获取一组数据，包含指定开始坐标，总容量，分类关键字，排序属性
	@Override
	public List<EvidTransition> getEvidTransitions(Integer status,int startIndex, int rows, String sorter,
			String sortingAttribute) {
		return evidTransitionDao.search("from EvidTransition where  status=? order by " + sorter + " " + sortingAttribute, new Object[] {status,  }, startIndex, rows);
	}

	//给出id删除指定数据
	@Override
	public boolean remove(String id) {
		this.evidTransitionDao.executeHql("delete from EvidTransition where id = ?", new Object[]{id});
		Long count = evidTransitionDao.count("select count(id) from EvidTransition where id = ?",new Object[]{id});
		if(count.intValue() > 0){
			return false;
		}
		return true;
	}

	//新增或者修改数据
	@Override
	public boolean saveOrUpdate(EvidTransition evidTransition) {
		String method = "";
		if(evidTransition.getId() == null){
			evidTransitionDao.save(evidTransition);
			method = "add";
		}else{evidTransitionDao.update(evidTransition);method = "update";}
		
		if ( method.equals("add") || method.equals("update") ) {
			 return true;
		} 
		return false;
	}


	@Override
	public EvidTransition getEvidTransitionByAppraisalId(String appraisalId, Integer type) {
		List<EvidTransition> list = evidTransitionDao.find("from EvidTransition where appraisalId = ? and status = ?",new Object[]{ appraisalId , type });
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}


	@Override
	public List<EvidTransition> getEvidTransitionGirdData(int start, int limit, String sorter, String sorterDirection,String appraisalId) {
		return evidTransitionDao.search("from EvidTransition where appraisalId = ? order by " + sorter + " " + sorterDirection, new Object[] { appraisalId }, start, limit);
	}


	@Override
	public long getEvidTransitionQty(String appraisalId) {
		return evidTransitionDao.count("select count(id) from EvidTransition where appraisalId = ? ", new Object[] { appraisalId });
	}


	@Override
	public boolean changeCancelDataByAppraisalId(String appraisalId) {
		evidTransitionDao.executeHql("update EvidTransition set status = ? where appraisalId = ? ", new Object[] { 2,appraisalId });
		Long count = evidTransitionDao.count("select count(id) from EvidTransition where appraisalId = ? and status = ?", new Object[] { appraisalId,0 });
		if(count.intValue() > 0){
			return false;
		}
		return true;
	}


	@Override
	public long getEvidTransitionQty(Integer status) {
		return this.evidTransitionDao.count("select count(id) from EvidTransition where status = ?" ,new Object[]{status});
	}


	@Override
	public EvidTransition getEvidTransitionByAppraisalIdAndStatusAndType(String appraisalId, int status, int type ) {
		List<EvidTransition> list = evidTransitionDao.find("from EvidTransition where appraisalId = ? and status = ? and type = ? order by applicantDate desc",new Object[]{ appraisalId , status , type });
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}


	@Override
	public List<EvidTransition> getEvidTransitionsAll(String appraisalId) {
		return evidTransitionDao.find("from EvidTransition where appraisalId = ? ", new Object[]{appraisalId} );
	}

}
