package org.pangolin.eeip.dao.impl;

import org.pangolin.eeip.dao.DocHistoryDao;
import org.pangolin.eeip.entity.DocHistory;
import org.springframework.stereotype.Repository;

@Repository("docHistoryDao")
public class DocHistoryDaoImpl extends BaseDaoImpl<DocHistory> implements DocHistoryDao {

}
