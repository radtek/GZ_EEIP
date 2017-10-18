package org.pangolin.eeip.dao.impl;

import org.pangolin.eeip.dao.UserAuthorizationDao;
import org.pangolin.eeip.entity.UserAuthorization;
import org.springframework.stereotype.Repository;


@Repository("authorizationDao")
@SuppressWarnings("all")
public class UserAuthorizationDaoImpl  extends BaseDaoImpl<UserAuthorization> implements UserAuthorizationDao{

}
