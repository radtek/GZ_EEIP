package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ExtractedDataDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.ExtractedData;
import org.pangolin.eeip.service.ExtractedDataService;
import org.springframework.stereotype.Service;

@Service("extractedDataService")
@SuppressWarnings("all")
public class ExtractedDataServiceImpl implements ExtractedDataService{

	@Resource
	private ExtractedDataDao extractedDataDao;
	
	 //根据ID查询
	@Override
	public ExtractedData getExtractedDataById(String id) {
		return extractedDataDao.get(ExtractedData.class, id);
	}
	
	//获取总数量
	@Override
	public Long getExtractedDataQty() {
		return extractedDataDao.count("select count(id) from ExtractedData where delFlag="+ExtractedData.NORMAL);
	} 
	
	//获取总集合
	@Override
	public List<ExtractedData> getExtractedDatas() {
		return extractedDataDao.find("from ExtractedData where delFlag="+ExtractedData.NORMAL+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<ExtractedData> getExtractedDatas(int startIndex, int rows, String sorter, String sortingAttribute) {
		return extractedDataDao.search("from ExtractedData where delFlag="+ExtractedData.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeExtractedData(String id) {
		extractedDataDao.executeHql("delete from ExtractedData where id = ?", new Object[] { id });
		Long qty = extractedDataDao.count("select count(id) from ExtractedData where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeExtractedDataFalse(String id) {
			Integer qty = extractedDataDao.executeHql("update ExtractedData set delFlag= ? where id = ?", new Object[] { ExtractedData.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveExtractedData(ExtractedData extractedData) {
		try {
			String id = extractedData.getId();
 			Long qty = extractedDataDao.count("select count(id) from Device where id=?", new Object[] {id});
 			if (qty > 0) {    
 				extractedDataDao.update(extractedData);
			} else {  
				extractedDataDao.save(extractedData);
			}
		} catch(Exception ex) { ex.printStackTrace(); return false; }
		return true;
	}

	@Override
	public ExtractedData getExtractedDataByAppraisalId(String appraisalId) {
		List<ExtractedData> list = extractedDataDao.find("from ExtractedData where appraisalId = ? ",new Object[]{ appraisalId });
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
}
