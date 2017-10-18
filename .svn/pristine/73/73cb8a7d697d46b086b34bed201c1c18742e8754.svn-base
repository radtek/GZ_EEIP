package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ExtractedDataItemDao;
import org.pangolin.eeip.entity.AnnualPlan;
import org.pangolin.eeip.entity.ExtractedDataItem;
import org.pangolin.eeip.service.ExtractedDataItemService;
import org.springframework.stereotype.Service;

@Service("extractedDataItemService")
@SuppressWarnings("all")
public class ExtractedDataItemServiceImpl implements ExtractedDataItemService{

	@Resource
	private ExtractedDataItemDao extractedDataItemDao;
	
	 //根据ID查询
	@Override
	public ExtractedDataItem getExtractedDataItemById(String id) {
		return extractedDataItemDao.get(ExtractedDataItem.class, id);
	}
	
	//获取总数量
	@Override
	public Long getExtractedDataItemQty() {
		return extractedDataItemDao.count("select count(id) from ExtractedDataItem where delFlag="+ExtractedDataItem.NORMAL);
	} 
	
	//获取总集合
	@Override
	public List<ExtractedDataItem> getExtractedDataItems() {
		return extractedDataItemDao.find("from ExtractedDataItem where delFlag="+ExtractedDataItem.NORMAL+" order by createdDate desc");
	}
	
	//分页查询
	@Override
	public List<ExtractedDataItem> getExtractedDataItems(int startIndex, int rows, String sorter, String sortingAttribute) {
		return extractedDataItemDao.search("from ExtractedDataItem where delFlag="+ExtractedDataItem.NORMAL+" order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	} 
	
	//数据删除
	@Override
	public boolean removeExtractedDataItem(String id) {
		extractedDataItemDao.executeHql("delete from ExtractedDataItem where id = ?", new Object[] { id });
		Long qty = extractedDataItemDao.count("select count(id) from ExtractedDataItem where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	//数据删除（伪）
	@Override
	public boolean removeExtractedDataItemFalse(String id) {
			Integer qty = extractedDataItemDao.executeHql("update ExtractedDataItem set delFlag= ? where id = ?", new Object[] { ExtractedDataItem.REMOVED,id });
			if ( qty == 0 ) return false;
			return true;
	}
	
	//数据修改或保存
	@Override
	public boolean saveExtractedDataItem(ExtractedDataItem extractedDataItem) {
		String method = "";
		if ( extractedDataItem.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		extractedDataItemDao.saveOrUpdate(extractedDataItem);
		if ( method.equals("add") ) {
			if ( extractedDataItem.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}

	@Override
	public boolean removeExtractedDataItemByExtractedDataId(String extractedDataId) {
		extractedDataItemDao.executeHql("delete from ExtractedDataItem where extractedDataId = ?", new Object[] { extractedDataId });
		Long qty = extractedDataItemDao.count("select count(id) from ExtractedDataItem where extractedDataId = ?" , new Object[] { extractedDataId });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}

	@Override
	public List<ExtractedDataItem> getExtractedDataItemByExtractedDataId(String id) {
		return extractedDataItemDao.find("from ExtractedDataItem where extractedDataId = ?",new Object[]{id});
	}
	 
}
