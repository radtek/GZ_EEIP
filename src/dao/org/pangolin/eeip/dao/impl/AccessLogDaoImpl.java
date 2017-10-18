package org.pangolin.eeip.dao.impl;

import org.pangolin.eeip.dao.AccessLogDao;
import org.pangolin.eeip.entity.AccessLog;
import org.springframework.stereotype.Repository;

@Repository("accessLogDao")
@SuppressWarnings("all")
public class AccessLogDaoImpl extends BaseDaoImpl<AccessLog> implements AccessLogDao {
	
}