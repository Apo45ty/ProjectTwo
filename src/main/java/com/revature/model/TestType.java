package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TestType")
public class TestType {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqname")
	@SequenceGenerator(initialValue=1,sequenceName="seq_name",allocationSize=1,name="seqname")
	@Column(name="ID",nullable=false)
	private long id;
	@Column(name="DESCRIPTION",length=400)
	private String description;
	@Column(name="GROUP",length=40)
	private String group;
	@Column(name="IS_DELETED",length=40)
	private boolean isDeleted = false;
	public TestType() {}
	public TestType(long id, String description, String group, boolean isDeleted) {
		super();
		this.id = id;
		this.description = description;
		this.group = group;
		this.isDeleted = isDeleted;
	}
	@XmlElement
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	@XmlElement
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "TestType [id=" + id + ", description=" + description + ", group=" + group + ", isDeleted=" + isDeleted
				+ "]";
	}
	
	
	
	
	
}
