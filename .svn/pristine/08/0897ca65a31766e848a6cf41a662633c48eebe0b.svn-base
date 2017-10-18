package org.pangolin.eeip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *电子物证类型实体类
 * @author zhanghong
 */
@Entity
@Table(name = "t_evid_type")
public class EvidType extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 2103780983931819899L;

	/**
	 * 删除状态 - 正常
	 */
	public static final Integer NORMAL = new Integer(0);
	
	/**
	 * 删除状态 - 删除
	 */
	public static final Integer REMOVE = new Integer(1);
	
	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/**
	 * 类型名称
	 * */
	@Column(name = "f_name", length = 100, nullable = false)
	private String name;
	
	/**
	 * 类型编号
	 * */
	@Column(name = "f_sn", length = 50, nullable = true)
	private String sn;
	
	/**
	 * 删除状态
	 **/
	@Column(name = "f_del_flag", length = 1, nullable = false)
	private  int delFlag = EvidType.NORMAL;
	
	/**
	 * 父级类型ID
	 **/
	@Column(name = "fk_parent_id", length = 32, nullable = true)
	private String parentId;
	
	public EvidType(){};

	//getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
}