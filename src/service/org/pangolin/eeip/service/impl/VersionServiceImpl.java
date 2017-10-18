package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.VersionDao;
import org.pangolin.eeip.entity.Version;
import org.pangolin.eeip.service.VersionService;
import org.springframework.stereotype.Service;

@Service("versionService")
@SuppressWarnings("all")
public class VersionServiceImpl implements VersionService {

	@Resource
	private  VersionDao versionDao;
	
	public Version getVersionById(String id) {
		return versionDao.get(Version.class, id);
	}
	
	public Long getVersionQty() {
		return versionDao.count("select count(id) from Version");
	}
	
	public Long getVersionQtyByStatus(Integer status) {
		return versionDao.count("select count(id) from Version where status = ?", new Object[] { status });
	}
	
	public List<Version> getVersions() {
		return versionDao.find("from Version order by createdDate desc");
	}
	
	public List<Version> getVersionsByStatus(Integer status) {
		return versionDao.find("from Version where status = ? order by createdDate desc", new Object[] { status });
	}
	
	public List<Version> getVersions(int startIndex, int rows, String sorter, String sortingAttribute) {
		return versionDao.search("from Version order by " + sorter + " " + sortingAttribute, new Object[] {  }, startIndex, rows);
	}
	
	public List<Version> getVersionsByStatus(Integer status, int startIndex, int rows, String sorter, String sortingAttribute) {
		return versionDao.search("from Version where status = ? order by " + sorter + " " + sortingAttribute, new Object[] { status }, startIndex, rows);
	}
	
	public boolean removeVersion(String id) {
		versionDao.executeHql("delete from Version where id = ?", new Object[] { id });
		Long qty = versionDao.count("select count(id) from Version where id = ?" , new Object[] { id });
		if ( qty.intValue() == 0 ) return true;
		return false;
	}
	
	public boolean saveVersion(Version version) {
		String method = "";
		if ( version.getId() == null ) { method = "add"; }
		else { 
			method = "update";
			version.setModifiedDate(new Date());
		}
		versionDao.saveOrUpdate(version);
		if ( method.equals("add") ) {
			if ( version.getId() != null ) return true;
		} else { return true; }
		return false;
	}
	
	public boolean saveVersionStatus(String id, Integer status) {
		Integer executedStatus = new Integer(0);
		executedStatus = versionDao.executeHql("update Version set status = ? where id = ?", new Object[] { status, id });
		if ( executedStatus.intValue() == 1 ) return true;
		return false;
	}
}