package org.pangolin.eeip.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ArchiveCodeDao;
import org.pangolin.eeip.entity.ArchiveCode;
import org.pangolin.eeip.service.ArchiveCodeService;
import org.springframework.stereotype.Service;

@Service("archiveCodeService")
@SuppressWarnings("all")
public class ArchiveCodeServiceImpl implements ArchiveCodeService {

	@Resource
	private ArchiveCodeDao archiveCodeDao;

	@Override
	public ArchiveCode getArchiveCodeById(String id) {
 		return archiveCodeDao.get(ArchiveCode.class, id);
	}

	@Override
	public boolean saveArchiveCode(ArchiveCode archiveCode) {
		String method = "";
		if ( archiveCode.getId() == null ) { method = "add"; }
		else { 
			method = "update";
 		}
		archiveCodeDao.saveOrUpdate(archiveCode);
		if ( method.equals("add") ) {
			if ( archiveCode.getId() != null ) {
				return true;
			}
		} else { 
			return true; 
		}
		return false;
	}

	@Override
	public List<ArchiveCode> getArchiveCodesByAgencyAndYear(String agency, String year) {
 		return archiveCodeDao.find(" from ArchiveCode where agency =? and year =? order by createdDate desc", new Object[]{agency,year});
	}
}
