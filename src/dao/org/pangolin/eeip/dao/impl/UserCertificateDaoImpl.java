package org.pangolin.eeip.dao.impl;

import org.pangolin.eeip.dao.UserCertificateDao;
import org.pangolin.eeip.entity.UserCertificate;
import org.springframework.stereotype.Repository;

@Repository("userCertificateDao")
@SuppressWarnings("all")
public class UserCertificateDaoImpl  extends BaseDaoImpl<UserCertificate> implements UserCertificateDao{

}
