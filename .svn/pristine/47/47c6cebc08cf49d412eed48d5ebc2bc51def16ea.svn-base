package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.ArchiveCode;

public interface ArchiveCodeService {

	/**
	 * 根据ID查询ArchiveCode
	 * ID
	 * @param id
	 * @return
	 */
	public ArchiveCode getArchiveCodeById(String id);
	
	/**
	 * 更新 ArchiveCode
	 * @param ArchiveCode 对象
	 * @return 更新状态
	 */
	public boolean saveArchiveCode(ArchiveCode archiveCode);
	
	/**
	 * 获取  ArchiveCode 集合 通过 年号和机关代字
	 * @param agency 机关代字
	 * @param year 年号
	 * @return
	 */
	public List<ArchiveCode> getArchiveCodesByAgencyAndYear(String agency,String year);
}
