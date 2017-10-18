package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AppraisalDocDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.AppraisalDoc;
import org.pangolin.eeip.service.AppraisalDocService;
import org.springframework.stereotype.Service;

@Service("appraisalDocService")
@SuppressWarnings("all")
public class AppraisalDocServiceImpl implements AppraisalDocService{

	@Resource
	private AppraisalDocDao appraisalDocDao;
	
	 //根据ID查询
	@Override
	public AppraisalDoc getAppraisalDocById(String id) {
		return appraisalDocDao.get(AppraisalDoc.class, id);
	}
	
	//获取总数量
	@Override
	public Long getAppraisalDocQty() {
		return appraisalDocDao.count("select count(id) from AppraisalDoc where delFlag="+AppraisalDoc.NORMAL);
	} 
	
	//获取总集合
	@Override
	public List<AppraisalDoc> getAppraisalDocs() {
		return appraisalDocDao.find("from AppraisalDoc where delFlag="+AppraisalDoc.NORMAL+" order by createdDate desc");
	}
	
	@Override
	public List<AppraisalDoc> getAppraisalDocs(String appraisalId) {
		return appraisalDocDao.find("from AppraisalDoc where  appraisalId =? and delFlag =? order by createdDate desc",new Object[]{appraisalId,AppraisalDoc.NORMAL});
	}

	@Override
	public List<AppraisalDoc> getReviseAppraisalDocs(String appraisalReviseId) {
		return appraisalDocDao.find("from AppraisalDoc where appraisalReviseId =? and  delFlag=? order by createdDate desc",new Object[]{appraisalReviseId,AppraisalDoc.NORMAL});
	}
	
	//分页查询
	@Override
	public List<AppraisalDoc> getAppraisalDocs(int startIndex, int rows, String sorter, String sortingAttribute) {
		return appraisalDocDao.search("from AppraisalDoc where delFlag = "+AppraisalDoc.NORMAL + " order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeAppraisalDoc(String id) {
		appraisalDocDao.executeHql("delete from AppraisalDoc where id = ?", new Object[] { id });
		Long qty = appraisalDocDao.count("select count(id) from AppraisalDoc where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeAppraisalDocFalse(Integer type,String appraisalId) {
			Integer qty = appraisalDocDao.executeHql("update AppraisalDoc set delFlag= ? where appraisalId = ? and type = ?", new Object[] { AppraisalDoc.REMOVED,appraisalId,type });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveAppraisalDoc(AppraisalDoc appraisalDoc) {
		try {
			String id = appraisalDoc.getId();
 			Long qty = appraisalDocDao.count("select count(id) from AppraisalDoc where id=?", new Object[] {id});
 			if (qty > 0) {    
				appraisalDocDao.update(appraisalDoc);
			} else {  
				appraisalDocDao.save(appraisalDoc);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public AppraisalDoc getAppraisalDocByTypeAndAppraisalId(Integer type, String appraisalId) {
		List<AppraisalDoc> list = appraisalDocDao.find("from AppraisalDoc where delFlag="+AppraisalDoc.NORMAL+"and appraisalId = ? and type = ? ",new Object[]{appraisalId,type} );
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public AppraisalDoc loadAppraisalDocByTypeAndAppraisalId(Integer type, String appraisalId) {
		List<AppraisalDoc> list = appraisalDocDao.find("from AppraisalDoc where delFlag="+AppraisalDoc.NORMAL+"and appraisalId = ? and type = ? order by createdDate desc ",new Object[]{appraisalId,type} );
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	//鉴定过程中的暂停 伪删除 4、5、6、7、8 文件
	@Override
	public void removeAppraisalDocByHistory(String appraisalHistId, String appraisalId) {
		List<AppraisalDoc> list = appraisalDocDao.find("from AppraisalDoc where delFlag="+AppraisalDoc.NORMAL+"and appraisalId = ? ",new Object[]{appraisalId} );
		for (AppraisalDoc appraisalDoc : list) {
			if(appraisalDoc.getType() == 4 || appraisalDoc.getType() == 5 || appraisalDoc.getType() == 6 || appraisalDoc.getType() == 7 ||appraisalDoc.getType() == 8){
				appraisalDoc.setAppraisalHistId(appraisalHistId);
				appraisalDoc.setDelFlag(1);
				appraisalDocDao.update(appraisalDoc);
			}
		}
	}

	@Override
	public AppraisalDoc getAppraisalDocByReviseId(Integer type, String appraisalReviseId) {
		return appraisalDocDao.get(" from AppraisalDoc where delFlag =? and type =? and appraisalReviseId =?", new Object[]{AppraisalDoc.NORMAL,type,appraisalReviseId});
	}

	@Override
	public boolean updateVersion(String appraisalId, String appraisalReviseId) {
		if(null!=appraisalId&&!"".equals(appraisalId)&&null!=appraisalReviseId&&!"".equals(appraisalReviseId)){
			try {
				List<AppraisalDoc> updateList =  appraisalDocDao.find(" from AppraisalDoc where appraisalReviseId =? and delFlag =?", new Object[]{ appraisalReviseId ,AppraisalDoc.NORMAL });
				if(updateList.size() > 0){
					for (AppraisalDoc doc : updateList) {
						doc.setAppraisalId(appraisalId);
						appraisalDocDao.update(doc);
					}
				}
				
				List<AppraisalDoc> deleteList =  appraisalDocDao.find(" from AppraisalDoc where appraisalId =?  and delFlag =? ", new Object[]{ appraisalId ,AppraisalDoc.NORMAL});
				if(updateList.size() > 0){	 
					for (AppraisalDoc doc : deleteList) {
						//所有的文书
						if(!appraisalReviseId.equals(doc.getAppraisalReviseId())){
							if(doc.getType().intValue() == AppraisalDoc.CATALOGUE.intValue() ||doc.getType().intValue() == AppraisalDoc.SETTLE_DOC.intValue()){
								doc.setDelFlag(AppraisalDoc.REMOVED);
								appraisalDocDao.update(doc);
							}
						} 
					} 
				} 
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
 		return true;
	}

	@Override
	public boolean saveAppraisalDoc(List<AppraisalDoc> docList) {
		try {
			if(docList.size() > 0){
				for (AppraisalDoc o : docList) {
					appraisalDocDao.saveOrUpdate(o);
				} 
			}
		} catch (Exception e) {
			return false;
		}
 		return true;
	}

	@Override
	public Boolean getAppDocByTypeAndAppraisalId(Integer type, String appraisalId) {
		List<AppraisalDoc> list = appraisalDocDao.find("from AppraisalDoc where delFlag =? and type =? and appraisalId =?", new Object[]{AppraisalDoc.NORMAL,type,appraisalId});
		if(list.size() > 0){
			return true;
		}
		return false;
	}
}
