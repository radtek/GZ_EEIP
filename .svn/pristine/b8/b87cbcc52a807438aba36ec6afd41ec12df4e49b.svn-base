package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 文号类型
 * @author Xiaolin Yin
 */
@Entity
@Table(name = "t_archive_type")
public class ArchiveType extends BaseEntity implements Serializable {
 
	private static final long serialVersionUID = -1485045858796021985L;
	
	/**
	 * 主键ID
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	public String id;
	
	/**
	 * 机关代字
	 */
	@Column(name = "f_agency", length = 100, nullable = false)
	private String agency;

}
