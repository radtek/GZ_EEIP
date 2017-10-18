package org.pangolin.eeip.service;

import org.pangolin.eeip.entity.Organization;
import org.pangolin.eeip.entity.Version;
import org.pangolin.eeip.entity.VersionCopy;

public interface VersionCopyService {
	
	/**
	 * 根据ID获取版本副本信息
	 * @author Oscar Mok
	 * @param id 版本副本ID
	 * @return 版本副本信息
	 * */
	public VersionCopy getVersionCopyById(String id);
	
	/**
	 * 根据机构ID获取版本副本信息
	 * @author Oscar Mok
	 * @param orgId 机构ID
	 * @return 版本副本信息
	 * */
	public VersionCopy getVersionCopyByOrg(String orgId);
	
	/**
	 * 指定机构是否存在版本副本
	 * @param orgId 机构ID
	 * @return 版本副本存在状态
	 * */
	public boolean existVersionCopy(String orgId);
	
	/**
	 * 保存版本副本信息
	 * @author Oscar Mok
	 * @param versionCopy 版本副本对象
	 * @return 保存状态
	 * */
	public boolean saveVersionCopy(VersionCopy versionCopy);
	
	/**
	 * 根据机构、版本生成版本副本信息
	 * @author Oscar Mok
	 * @param org 机构信息对象
	 * @param version 版本信息对象
	 * @return 保存状态
	 * */
	public boolean saveVersionCopy(Organization org, Version version);
	
	/**
	 * 复制上级机构的副本信息
	 * @author Oscar Mok
	 * @param org 待保存机构信息对象
	 * @param parentOrg 上级机构信息对象
	 * @return 保存状态
	 * */
	public boolean copyVersionCopy(Organization org, Organization parentOrg);
	
	/**
	 * 根据ID移除版本副本信息
	 * @author Oscar Mok
	 * @param id 版本副本ID
	 * @return 移除状态
	 * */
	public boolean removeVersionCopy(String id);
	
	/**
	 * 根据机构ID移除版本副本信息
	 * @author Oscar Mok
	 * @param orgId 机构ID
	 * @return 移除状态
	 * */
	public boolean removeVersionCopyByOrg(String orgId);
	
}