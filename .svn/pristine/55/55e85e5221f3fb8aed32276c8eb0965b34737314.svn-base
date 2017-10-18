package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.AdvertisementDao;
import org.pangolin.eeip.entity.Advertisement;
import org.pangolin.eeip.service.AdvertisementService;
import org.pangolin.util.FileUtil;
import org.springframework.stereotype.Service;

@Service("advertisementService")
@SuppressWarnings("all")
public class AdvertisementServiceImpl implements AdvertisementService {

	@Resource
	private  AdvertisementDao advertisementDao;
	
	public Advertisement getAdvertisementById(String id) {
		return advertisementDao.get(Advertisement.class, id);
	}
	
	public Long getAdvertisementQty() {
		return advertisementDao.count("select count(id) from Advertisement");
	}
	
	public List<Advertisement> getAdvertisements() {
		return advertisementDao.find("from Advertisement order by createdDate desc");
	}
	
	public List<Advertisement> getAdvertisements(int startIndex, int rows, String sorter, String sortingAttribute) {
		return advertisementDao.search("from Advertisement order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}
	
	public boolean removeAdvertisement(String id) {
		String filePath = "";
		Advertisement advertisement = getAdvertisementById(id);
		if ( advertisement != null 
				&& advertisement.getPath() != null 
				&& !advertisement.getPath().trim().equals("") ) {
			filePath = advertisement.getPath();
		}
		advertisementDao.executeHql("delete from Advertisement where id = ?", new Object[] { id });
		Long qty = advertisementDao.count("select count(id) from Advertisement where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) {
			FileUtil.removeFile(filePath);
			return true;
		}
		return false;
	}
	
	public boolean saveAdvertisement(Advertisement Advertisement) {
		String method = "";
		if ( Advertisement.getId() == null ) { method = "add"; }
		else { method = "update"; }
		advertisementDao.saveOrUpdate(Advertisement);
		if ( method.equals("add") ) {
			if ( Advertisement.getId() != null ) return true;
		} else { return true; }
		return false;
	}
	
	public boolean saveAdvertisementStatus(String id, Integer status) {
		advertisementDao.executeHql("update Advertisement set status = ? where id = ?", new Object[] { status, id });
		return false;
	}
	
}