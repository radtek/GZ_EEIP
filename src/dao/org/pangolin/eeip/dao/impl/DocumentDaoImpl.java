package org.pangolin.eeip.dao.impl;

import org.pangolin.eeip.dao.DocumentDao;
import org.pangolin.eeip.entity.Document;
import org.springframework.stereotype.Repository;

@Repository("documentDao")
@SuppressWarnings("all")
public class DocumentDaoImpl extends BaseDaoImpl<Document> implements DocumentDao {
	
}