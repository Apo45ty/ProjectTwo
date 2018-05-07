package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TestModel")
public class TestModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="groupIdSeq")
	@SequenceGenerator(initialValue = 1, sequenceName="groupIdSeq", name="groupIdSeq")
	@Column(name="groupId", nullable=false, unique=true)
	private int groupID;
	
	@Column(name="isDeleted")
	private int isDeleted = 0;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy="TestType")
	private List<TestType> ltt;
	
	
	public TestModel() {
		super();
	}

	public TestModel(int groupID, int isDeleted, String name, String description) {
		super();
		this.groupID = groupID;
		this.isDeleted = isDeleted;
		this.name = name;
		this.description = description;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
