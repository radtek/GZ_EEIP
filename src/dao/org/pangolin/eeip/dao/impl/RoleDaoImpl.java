package org.pangolin.eeip.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.pangolin.eeip.dao.RoleDao;
import org.pangolin.eeip.entity.Role;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
@SuppressWarnings("all")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
	
}