package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.VersionCopyDao;
import org.pangolin.eeip.entity.Organization;
import org.pangolin.eeip.entity.Version;
import org.pangolin.eeip.entity.VersionCopy;
import org.pangolin.eeip.service.VersionCopyService;
import org.springframework.stereotype.Service;

@Service("versionCopyService")
@SuppressWarnings("all")
public class VersionCopyServiceImpl implements VersionCopyService {

	@Resource
	private  VersionCopyDao versionCopyDao;
	
	public VersionCopy getVersionCopyById(String id) {
		return versionCopyDao.get(VersionCopy.class, id);
	}
	
	public VersionCopy getVersionCopyByOrg(String orgId) {
		VersionCopy versionCopy = null;
		List<VersionCopy> verCpList = versionCopyDao.find("from VersionCopy where orgId = ?", new Object[] { orgId });
		if ( verCpList != null && verCpList.size() > 0 ) versionCopy = verCpList.get(0);
		return versionCopy;
	}
	
	public boolean existVersionCopy(String orgId) {
		Long qty = versionCopyDao.count("select count(id) from VersionCopy where orgId = ?", new Object[] { orgId });
		if ( qty > 0 ) return true;
		return false;
	}
	
	public boolean saveVersionCopy(VersionCopy versionCopy) {
		if ( versionCopy != null ) {
			if ( !existVersionCopy(versionCopy.getOrgId()) ) {
				versionCopyDao.saveOrUpdate(versionCopy);
				return true;
			} else {
				removeVersionCopyByOrg(versionCopy.getOrgId());
				versionCopyDao.saveOrUpdate(versionCopy);
				return true;
			}
		}
		return false;
	}
	
	public boolean saveVersionCopy(Organization org, Version version) {
		if ( org != null && version != null ) {
			VersionCopy versionCopy = new VersionCopy();
			versionCopy.setOrgId(org.getOrgId());
			versionCopy.setModuleLabels(version.getModuleLabels());
			versionCopy.setActivatedDate(org.getActivatedDate());
			versionCopy.setExpiredDate(org.getExpiredDate());
			versionCopy.setVersionId(version.getId());
			boolean status = saveVersionCopy(versionCopy);
			return status;
		}
		return false;
	}
	
	public boolean copyVersionCopy(Organization org, Organization parentOrg) {
		if ( org != null && parentOrg != null ) {
			VersionCopy parentOrgVerCp = getVersionCopyByOrg(parentOrg.getOrgId());
			if ( parentOrgVerCp != null ) {
				VersionCopy versionCopy = new VersionCopy();
				versionCopy.setOrgId(org.getOrgId());
				versionCopy.setModuleLabels(parentOrgVerCp.getModuleLabels());
				versionCopy.setActivatedDate(parentOrgVerCp.getActivatedDate());
				versionCopy.setExpiredDate(parentOrgVerCp.getExpiredDate());
				versionCopy.setVersionId(parentOrgVerCp.getVersionId());
				boolean status = saveVersionCopy(versionCopy);
			}
		}
		return false;
	}
	
	public boolean removeVersionCopy(String id) {
		Integer status = versionCopyDao.executeHql("delete from VersionCopy where id = ?", new Object[] { id });
		if ( status.intValue() == 1 ) return true;
		return false;
	}
	
	public boolean removeVersionCopyByOrg(String orgId) {
		Integer status = versionCopyDao.executeHql("delete from VersionCopy where orgId = ?", new Object[] { orgId });
		if ( status.intValue() == 1 ) return true;
		return false;
	}
}