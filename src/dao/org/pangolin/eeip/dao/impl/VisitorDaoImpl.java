package org.pangolin.eeip.dao.impl;

import org.pangolin.eeip.dao.VisitorDao;
import org.pangolin.eeip.entity.Visitor;
import org.springframework.stereotype.Repository;

@Repository("visitorDao")
@SuppressWarnings("all")
public class VisitorDaoImpl extends BaseDaoImpl<Visitor> implements VisitorDao{

}
