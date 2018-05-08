package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TestModel")
public class TestModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="groupIdSeq")
	@SequenceGenerator(initialValue = 1, sequenceName="groupIdSeq", name="groupIdSeq")
	@Column(name="groupID", nullable=false, unique=true)
	private int groupID;
	
	@Column(name="isDeleted")
	private int isDeleted = 0;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy="testmodel",cascade=CascadeType.ALL)
	private List<TestType> ltt;
	
	
	public TestModel() {
		
	}

	public TestModel(int groupID, int isDeleted, String name, String description) {
		super();
		this.groupID = groupID;
		this.isDeleted = isDeleted;
		this.name = name;
		this.description = description;
	}

	@XmlElement
	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	@XmlElement
	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TestModel [groupID=" + groupID + ", isDeleted=" + isDeleted + ", name=" + name + ", description="
				+ description + "]";
	}

	
	
}
