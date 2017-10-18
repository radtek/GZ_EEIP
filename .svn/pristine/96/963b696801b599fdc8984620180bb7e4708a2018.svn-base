package org.pangolin.eeip.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Basic Database Operator
 * @author Oscar Mok
 * @version 1.0
 */
@SuppressWarnings("all")
public interface BaseDao<T> {

	/**
	 * Save New Object
	 * @author Oscar Mok
	 * @param o
	 * @return
	 */
	public Serializable save(T o);

	/**
	 * Update Object
	 * @author Oscar Mok
	 * @param o
	 */
	public void update(T o);
	
	/**
	 * Save/Update Object
	 * @author Oscar Mok
	 * @param o
	 */
	public void saveOrUpdate(T o);
	
	/**
	 * Remove Object
	 * @author Oscar Mok
	 * @param o
	 */
	public void delete(T o);

	/**
	 * Search Data By HQL
	 * @author Oscar Mok
	 * @param hql
	 * @return List
	 */
	public List<T> find(String hql);

	/**
	 * Search Data By HQL
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( Object[] )
	 * @return List
	 */
	public List<T> find(String hql, Object[] param);

	/**
	 * Search Data By HQL
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( List )
	 * @return List
	 */
	public List<T> find(String hql, List<Object> param);

	/**
	 * Search Data By HQL for Paging
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( Object[] )
	 * @param page 
	 *                Page Number
	 * @param rows
	 *                Record Number Per Page
	 * @return List
	 */
	public List<T> find(String hql, Object[] param, Integer page, Integer rows);

	/**
	 * Search Data By HQL for Paging
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( List )
	 * @param page 
	 *                Page Number
	 * @param rows
	 *                Record Number per Page
	 * @return List
	 */
	public List<T> find(String hql, List<Object> param, Integer page, Integer rows);
	
	/**
	 * Comprehensive Search Data By HQL
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( Object[] )
	 * @return List
	 */
	public List compSearch(String hql, Object[] param);
	
	/**
	 * Comprehensive Search Data By HQL for Paging
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( Object[] )
	 * @param startIndex 
	 *                Index of data
	 * @param rows
	 *                Record Number per Page
	 * @return List
	 */
	public List compSearch(String hql, Object[] param, Integer startIndex, Integer rows);
	
	/**
	 * Comprehensive Search Data By HQL for Paging
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( List )
	 * @param startIndex 
	 *                Index of data
	 * @param rows
	 *                Record Number per Page
	 * @return List
	 */
	public List compSearch(String hql, List<Object> param, Integer startIndex, Integer rows);
	
	/**
	 * Search Data By HQL for Paging
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( Object[] )
	 * @param startIndex 
	 *                Index of data
	 * @param rows
	 *                Record Number per Page
	 * @return List
	 */
	public List<T> search(String hql, Object[] param, Integer startIndex, Integer rows);
	
	/**
	 * Search Data By HQL for Paging
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( List )
	 * @param startIndex 
	 *                Index of data
	 * @param rows
	 *                Record Number per Page
	 * @return List
	 */
	public List<T> search(String hql, List<Object> param, Integer startIndex, Integer rows);
	
	/**
	 * Search Data By SQL for Paging
	 * @author Oscar Mok
	 * @param sql
	 * @param param
	 *                Parameters ( Object[] )
	 * @param startIndex 
	 *                Index of data
	 * @param rows
	 *                Record Number per Page
	 * @return List
	 */
	public List searchBySQL(String sql, Object[] param, Integer startIndex, Integer rows);
	
	/**
	 * CompSearch Data By SQL
	 * @param sql
	 * @param param
	 * @return
	 */
    public List compSearchBySQL(String sql,Object[] param);
	
	/**
	 * Search Data By SQL for Paging
	 * @author Oscar Mok
	 * @param sql
	 * @param param
	 *                Parameters ( List )
	 * @param startIndex 
	 *                Index of data
	 * @param rows
	 *                Record Number per Page
	 * @return List
	 */
	public List searchBySQL(String sql, List<Object> param, Integer startIndex, Integer rows);
	
	/**
	 * Get Object
	 * @author Oscar Mok
	 * @param c
	 *                Type of Object
	 * @param id
	 *                Id of Object
	 * @return Object
	 */
	public T get(Class<T> c, Serializable id);

	/**
	 * Get Object
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( Object[] )
	 * @return Object
	 */
	public T get(String hql, Object[] param);

	/**
	 * Get Object
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( List )
	 * @return Object
	 */
	public T get(String hql, List<Object> param);

	/**
	 * Get Quantity of Object
	 * @author Oscar Mok
	 * @param hql
	 * @return Quantity
	 */
	public Long count(String hql);

	/**
	 * Get Quantity of Object
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( Object[] )
	 * @return Quantity
	 */
	public Long count(String hql, Object[] param);

	/**
	 * Get Quantity of Object
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( List )
	 * @return Quantity
	 */
	public Long count(String hql, List<Object> param);
	
	/**
	 * Get Quantity of Object
	 * @author Oscar Mok
	 * @param sql
	 * @return Quantity
	 */
	public Long countBySQL(String sql);

	/**
	 * Get Quantity of Object
	 * @author Oscar Mok
	 * @param sql
	 * @param param
	 *                Parameters ( Object[] )
	 * @return Quantity
	 */
	public Long countBySQL(String sql, Object[] param);

	/**
	 * Get Quantity of Object
	 * @author Oscar Mok
	 * @param sql
	 * @param param
	 *                Parameters ( List )
	 * @return Quantity
	 */
	public Long countBySQL(String sql, List<Object> param);
	
	/**
	 * Execute HQL
	 * @author Oscar Mok
	 * @param hql
	 * @return Response Number
	 */
	public Integer executeHql(String hql);

	/**
	 * Execute HQL
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( Object[] )
	 * @return Response Number
	 */
	public Integer executeHql(String hql, Object[] param);

	/**
	 * Execute HQL
	 * @author Oscar Mok
	 * @param hql
	 * @param param
	 *                Parameters ( List )
	 * @return Response Number
	 */
	public Integer executeHql(String hql, List<Object> param);
}