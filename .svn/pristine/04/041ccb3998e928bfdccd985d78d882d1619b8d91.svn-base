package org.pangolin.eeip.service;

import java.util.List;

import org.pangolin.eeip.entity.Appraisal;
import org.pangolin.eeip.entity.EvidTransition;

public interface EvidTransitionService {
	
	/**
	 * 根据ID获取电子物证交接信息
	 * @author zhanghong
	 * @param id 电子物证交接ID
	 * @return 电子物证交接信息
	 * */
	public EvidTransition getEvidTransitionById(String id);
	
	/**
	 * 根据preappraisalId获取电子物证交接信息
	 * @author zhanghong
	 * @param preappraisalId 电子物证交接preappraisalId
	 * @return 电子物证交接信息
	 * */
	public EvidTransition getEvidTransitionByPreappraisalId(String preappraisalId);
	
	/**
	 * 获取所有电子物证交接数量,附加限定条件params
	 * @author zhanghong
	 * @return 电子物证交接数量
	 * */
	public long count(String params) ;
	
	/**
	 * 获取所有电子物证交接数量,没有附加限定条件
	 * @author zhanghong
	 * @return 电子物证交接数量
	 * */
	public long count() ;
	
	/**
	 * 获取所有电子物证交接数量,没有附加限定条件
	 * @author zhanghong
	 * @return 电子物证交接数量
	 * */
	public long getEvidTransitionQty(Integer status) ;
	
	/**
	 * 获取所有电子物证交接列表,附加限定条件params
	 * @author zhanghong
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 电子物证交接列表
	 * */
	public List<EvidTransition> getEvidTransitions(Integer status,String params, int startIndex, int rows, String sorter, String sortingAttribute);

	/**
	 * 获取所有电子物证交接列表,没有附加限定条件
	 * @author zhanghong
	 * @param startIndex 初始游标
	 * @param rows 分页数量
	 * @param sorter 排序字段
	 * @param sortingAttribute 排序方式
	 * @return 电子物证交接列表
	 * */
	public List<EvidTransition> getEvidTransitions(Integer status,int startIndex, int rows, String sorter, String sortingAttribute);
	
	/**
	 * 移除电子物证交接
	 * @author zhanghong
	 * @param id 电子物证交接ID
	 * @return 移除状态
	 * */
	public boolean remove(String id);
	
	/**
	 * 保存电子物证交接信息
	 * @author zhanghong
	 * @param gallery 电子物证交接对象
	 * @return 保存状态
	 * */
	public boolean saveOrUpdate(EvidTransition evidTransition);

	/**
	 * 返回对象
	 * @param appraisalId
	 * @param type 是领取 还是  归还
	 * @return
	 */
	public EvidTransition getEvidTransitionByAppraisalId(String appraisalId, Integer type);

	/**
	 * 电子物证交接检材流转记录列表
	 * @param start
	 * @param limit
	 * @param sorter
	 * @param sorterDirection
	 * @param appraisalId 
	 * @return
	 */
	public List<EvidTransition> getEvidTransitionGirdData(int start, int limit, String sorter, String sorterDirection, String appraisalId);

	/**
	 * 电子物证交接检材流转记录总数
	 * @param appraisalId 
	 * @return
	 */
	public long getEvidTransitionQty(String appraisalId);

	/**
	 * 取消所有未完成交接申请
	 * @param appraisalId
	 * @return
	 */
	public boolean changeCancelDataByAppraisalId(String appraisalId);

	/**
	 * 根据状态 status appraisalId 获取对象
	 * @param appraisalId
	 * @param i
	 * @param j
	 */
	public EvidTransition getEvidTransitionByAppraisalIdAndStatusAndType(String appraisalId, int i, int j);
	
	/**
	 * @param appraisalId 检材鉴定ID
	 * @return
	 */
	public List<EvidTransition> getEvidTransitionsAll(String appraisalId);
	
}