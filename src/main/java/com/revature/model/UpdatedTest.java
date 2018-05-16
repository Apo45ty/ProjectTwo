package com.revature.model;

import java.sql.Timestamp;

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
@Table(name = "Updated_Test")
public class UpdatedTest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_id_seq")
	@SequenceGenerator(initialValue = 1, sequenceName = "test_id_seq", allocationSize = 1, name = "test_id_seq")
	@Column(name = "TEST_ID", nullable = false)
	private long test_id;
	@Column(name = "TEST_NAME", length = 64)
	private String test_name;
	
	// PASSED or FAILED or SKIPPED these are the three options TESTNG Has
	@Column(name = "TEST_CONTEXT", length = 9)
	private String test_context; // use ITestResult.getTestContext()
	
	@Column(name="IS_DELETED",length=16)
	private boolean isDeleted = false;
	@Column(name="TEST_START_DATE",length=64)
	private Timestamp test_start_date;
	@Column(name="TEST_END_DATE",length=64)
	private Timestamp test_end_date;
	
	public UpdatedTest() {}

	/**
	 * @param test_id
	 * @param test_name
	 * @param test_context
	 * @param isDeleted
	 * @param test_start_date
	 * @param test_end_date
	 */
	public UpdatedTest(long test_id, String test_name, String test_context, boolean isDeleted,
			Timestamp test_start_date, Timestamp test_end_date) {
		super();
		this.test_id = test_id;
		this.test_name = test_name;
		this.test_context = test_context;
		this.isDeleted = isDeleted;
		this.test_start_date = test_start_date;
		this.test_end_date = test_end_date;
	}

	/**
	 * @return the test_id
	 */
	@XmlElement
	public long getTest_id() {
		return test_id;
	}

	/**
	 * @param test_id the test_id to set
	 */
	public void setTest_id(long test_id) {
		this.test_id = test_id;
	}

	/**
	 * @return the test_name
	 */
	@XmlElement
	public String getTest_name() {
		return test_name;
	}

	/**
	 * @param test_name the test_name to set
	 */
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	/**
	 * @return the test_context
	 */
	@XmlElement
	public String getTest_context() {
		return test_context;
	}

	/**
	 * @param test_context the test_context to set
	 */
	public void setTest_context(String test_context) {
		this.test_context = test_context;
	}

	/**
	 * @return the isDeleted
	 */
	@XmlElement
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the test_start_date
	 */
	@XmlElement
	public Timestamp getTest_start_date() {
		return test_start_date;
	}

	/**
	 * @param test_start_date the test_start_date to set
	 */
	public void setTest_start_date(Timestamp test_start_date) {
		this.test_start_date = test_start_date;
	}

	/**
	 * @return the test_end_date
	 */
	@XmlElement
	public Timestamp getTest_end_date() {
		return test_end_date;
	}

	/**
	 * @param test_end_date the test_end_date to set
	 */
	public void setTest_end_date(Timestamp test_end_date) {
		this.test_end_date = test_end_date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdatedTest [test_id=" + test_id + ", test_name=" + test_name + ", test_context=" + test_context
				+ ", isDeleted=" + isDeleted + ", test_start_date=" + test_start_date + ", test_end_date="
				+ test_end_date + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((test_context == null) ? 0 : test_context.hashCode());
		result = prime * result + ((test_end_date == null) ? 0 : test_end_date.hashCode());
		result = prime * result + (int) (test_id ^ (test_id >>> 32));
		result = prime * result + ((test_name == null) ? 0 : test_name.hashCode());
		result = prime * result + ((test_start_date == null) ? 0 : test_start_date.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdatedTest other = (UpdatedTest) obj;
		if (isDeleted != other.isDeleted)
			return false;
		if (test_context == null) {
			if (other.test_context != null)
				return false;
		} else if (!test_context.equals(other.test_context))
			return false;
		if (test_end_date == null) {
			if (other.test_end_date != null)
				return false;
		} else if (!test_end_date.equals(other.test_end_date))
			return false;
		if (test_id != other.test_id)
			return false;
		if (test_name == null) {
			if (other.test_name != null)
				return false;
		} else if (!test_name.equals(other.test_name))
			return false;
		if (test_start_date == null) {
			if (other.test_start_date != null)
				return false;
		} else if (!test_start_date.equals(other.test_start_date))
			return false;
		return true;
	}
	
}