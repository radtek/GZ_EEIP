package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.TerminationNoticeDao;
import org.pangolin.eeip.entity.TerminationNotice;
import org.pangolin.eeip.service.TerminationNoticeService;
import org.springframework.stereotype.Service;

@Service("terminationNoticeService")
@SuppressWarnings("all")
public class TerminationNoticeServiceImpl implements TerminationNoticeService{

	@Resource
	private TerminationNoticeDao terminationNoticeDao;
	
	 //根据ID查询
	@Override
	public TerminationNotice getTerminationNoticeById(String id) {
		return terminationNoticeDao.get(TerminationNotice.class, id);
	}
	
	//获取总数量
	@Override
	public Long getTerminationNoticeQty() {
		return terminationNoticeDao.count("select count(id) from TerminationNotice ");
	} 
	
	//获取总集合
	@Override
	public List<TerminationNotice> getTerminationNotices() {
		return terminationNoticeDao.find("from TerminationNotice where order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<TerminationNotice> getTerminationNotices(int startIndex, int rows, String sorter, String sortingAttribute) {
		return terminationNoticeDao.search("from TerminationNotice where order by " + sorter + " " + sortingAttribute, new Object[] {   }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeTerminationNotice(String id) {
		terminationNoticeDao.executeHql("delete from TerminationNotice where id = ?", new Object[] { id });
		Long qty = terminationNoticeDao.count("select count(id) from TerminationNotice where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据修改或保存
	@Override
	public boolean saveTerminationNotice(TerminationNotice terminationNotice) {
		try {
			String id = terminationNotice.getId();
 			Long qty = terminationNoticeDao.count("select count(id) from TerminationNotice where id=?", new Object[] {id});
 			if (qty > 0) {    
 				terminationNoticeDao.update(terminationNotice);
			} else {  
				terminationNoticeDao.save(terminationNotice);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public TerminationNotice getTerminationNoticeByAppraisalId(String appraisalId) {
		List<TerminationNotice> list = terminationNoticeDao.find("from TerminationNotice where appraisalId = ?",new Object[]{appraisalId});
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	 
}
