package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name="TestType")
public class TestType {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqname2")
	@SequenceGenerator(initialValue=1,sequenceName="seq_name2",allocationSize=1,name="seqname2")
	@Column(name="ID",nullable=false)
	private long id=0L;
	
	@Column(name="DESCRIPTION",length=400)
	private String description="";
	
	@Column(name="IS_DELETED",length=40)
	private boolean isDeleted = false;
	
	public TestType() {}
	public TestType(long id, String description, long group, boolean isDeleted) {
		super();
		this.id = id;
		this.description = description;
		this.testmodel.setGroupID((int) group);
		this.isDeleted = isDeleted;
	}
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn (name = "groupID")
	TestModel testmodel = new TestModel();
	
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
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	@Override
	public String toString() {
		return "TestType [id=" + id + ", description=" + description +", isDeleted=" + isDeleted
				+ "]";
	}	
}
