package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="Test")
public class Test {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqname")
	@SequenceGenerator(initialValue=1,sequenceName="seq_name",allocationSize=1,name="seqname")
	@Column(name="ID",nullable=false,length=40)
	private long id;
	@Column(name="COMMENTS",length=400)
	private String comments;
	@Column(name="RESULT",length=40)
	private String result;
	@Column(name="IS_DELETED",length=40)
	private boolean isDeleted = false;
	
	@ManyToOne
    @JoinColumn(name = "ID")
	private TestType testID;
	
	@ManyToOne
    @JoinColumn(name = "ID")
	private System systemID;
	
	public Test() {}
	
	public Test(long id, String comments, String result, boolean isDeleted, TestType testID, System systemID) {
		super();
		this.id = id;
		this.comments = comments;
		this.result = result;
		this.isDeleted = isDeleted;
		this.testID = testID;
		this.systemID = systemID;
	}


	@XmlElement
	public long getTestID() {
		return testID.getId();
	}

	public void setTestID(TestType testID) {
		this.testID = testID;
	}

	@XmlElement
	public long getSystemID() {
		return systemID.getId();
	}

	public void setSystemID(System systemID) {
		this.systemID = systemID;
	}

	@XmlElement
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@XmlElement
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "Test [id=" + id + ", testID=" + testID + ", comments=" + comments + ", result=" + result
				+ ", isDeleted=" + isDeleted + ", systemID=" + systemID + "]";
	}

	
	
	
}
