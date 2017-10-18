package org.pangolin.eeip.dao.impl;

import org.pangolin.eeip.dao.SystemLogDao;
import org.pangolin.eeip.entity.SystemLog;
import org.springframework.stereotype.Repository;

@Repository("systemLogDao")
@SuppressWarnings("all")
public class SystemLogDaoImpl extends BaseDaoImpl<SystemLog> implements SystemLogDao {
	
}