package org.pangolin.eeip.service.impl;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.ArchiveTypeDao;
import org.pangolin.eeip.service.ArchiveTypeService;
import org.springframework.stereotype.Service;

@Service("archiveTypeService")
@SuppressWarnings("all")
public class ArchiveTypeServiceImpl implements ArchiveTypeService{

	@Resource
	private ArchiveTypeDao archiveTypeDao;
}
