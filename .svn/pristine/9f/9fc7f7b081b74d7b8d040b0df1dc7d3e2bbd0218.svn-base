package org.pangolin.eeip.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/***
 * 相关文件
 * @author Tinggui Zhu
 *
 */
@Entity
@Table(name = "t_doc_relationship")
public class DocRelationship extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -1581354017723384387L;

	/**
	 * ID
	 * */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "pk_id", length = 32, nullable = false)
	private String id;
	
	/***
	 * 源文件ID
	 */
	@Column(name = "f_src_doc_id", length = 32, nullable = false)
	private String srcDocId;
	
	/***
	 * 相关文件ID
	 */
	@Column(name = "f_relevant_doc_id", length = 32, nullable = false)
	private String relevantDocId;
	
	public DocRelationship() {  }
	
	// getters and setters
	public String toString() {
		return outputObjPropertyString(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSrcDocId() {
		return srcDocId;
	}

	public void setSrcDocId(String srcDocId) {
		this.srcDocId = srcDocId;
	}

	public String getRelevantDocId() {
		return relevantDocId;
	}

	public void setRelevantDocId(String relevantDocId) {
		this.relevantDocId = relevantDocId;
	}
}