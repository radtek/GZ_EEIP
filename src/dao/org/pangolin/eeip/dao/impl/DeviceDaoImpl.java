package org.pangolin.eeip.dao.impl;

import org.pangolin.eeip.dao.DeviceDao;
import org.pangolin.eeip.entity.Device;
import org.springframework.stereotype.Repository;

@Repository("deviceDao")
@SuppressWarnings("all")
public class DeviceDaoImpl  extends BaseDaoImpl<Device> implements DeviceDao{

}
