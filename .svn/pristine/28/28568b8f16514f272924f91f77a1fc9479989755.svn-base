package org.pangolin.eeip.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.pangolin.eeip.dao.VisitorDao;
import org.pangolin.eeip.entity.Visitor;
import org.pangolin.eeip.service.VisitorService;
import org.springframework.stereotype.Service;

@Service("visitorService")
@SuppressWarnings("all")
public class VisitorServiceImpl implements VisitorService {

	@Resource
	  private VisitorDao visitorDao;
	
	// 根据ID查询
		public Visitor getVisitorById(String id) {
			return visitorDao.get(Visitor.class, id);
		}

		// 获取总数量
		public Long getVisitorQty() {
			return visitorDao.count("select count(id) from Visitor where delFlag=" + Visitor.NORMAL);
		}

		// 获取总集合
		public List<Visitor> getVisitors() {
			return visitorDao
					.find("from Visitor where delFlag=" + Visitor.NORMAL + " order by createdDate desc");
		}

		// 分页查询
		public List<Visitor> getVisitors(int startIndex, int rows, String sorter, String sortingAttribute) {
			return visitorDao.search("from Visitor where delFlag=" + Visitor.NORMAL + " order by " + sorter
					+ " " + sortingAttribute, new Object[] {}, startIndex, rows);
		}

		// 数据删除
		public boolean removeVisitor(String id) {
			visitorDao.executeHql("delete from Visitor where id = ?", new Object[] { id });
			Long qty = visitorDao.count("select count(id) from Visitor where id = ?", new Object[] { id });
			if (qty.intValue() == 0)
				return true;
			return false;
		}

		// 数据删除（伪）
		public boolean removeVisitorFalse(String id) {
			Integer qty = visitorDao.executeHql("update  Visitor set delFlag= ? where id = ?",
					new Object[] { Visitor.REMOVED, id });
			if (qty == 0)
				return false;
			return true;
		}

		// 数据修改或保存
		public boolean saveVisitor(Visitor visitor) {
			String method = "";
			if (visitor.getId() == null) {
				method = "add";
				visitor.setCreatedDate(new Date());
			} else {
				method = "update";
			}
			visitorDao.saveOrUpdate(visitor);
			if (method.equals("add")) {
				if (visitor.getId() != null)
					return true;
			} else {
				return true;
			}
			return false;
		}

		@Override
		public List<Visitor> getListVisitors(String queryParam, int startIndex, int rows,
				String sorter, String sortingAttribute) {
			StringBuffer hql=new StringBuffer();
			hql.append(" from Visitor where 1=1  ");
			if(null != queryParam && !"".equals(queryParam) ){
				queryParam = "%" + queryParam + "%";
				hql.append(" and ( name like '"+queryParam+"' or org like '"+queryParam+"' or reason like '"+queryParam+"' )");
			}
			return visitorDao.search(hql.toString()+" and delFlag=" + Visitor.NORMAL + " order by " + sorter
					+ " " + sortingAttribute, new Object[] {}, startIndex, rows);
		}

		@Override
		public Long getVisitorListQty(String queryParam) {
			StringBuffer hql=new StringBuffer();
			hql.append("select count(id) from Visitor where 1=1  ");
			if(null != queryParam && !"".equals(queryParam) ){
				queryParam = "%" + queryParam + "%";
				hql.append(" and ( name like '"+queryParam+"' or org like '"+queryParam+"' or reason like '"+queryParam+"' )");
			}
			
			return visitorDao.count(hql.toString()+" and delFlag=" + Visitor.NORMAL);
		}

}
