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
@Table(name = "Test")
public class UpdatedTest {

	static {
		java.lang.System.setProperty("javax.xml.bind.context.factory",
				"org.eclipse.persistence.jaxb.JAXBContextFactory");
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_id_seq")
	@SequenceGenerator(initialValue = 1, sequenceName = "test_id_seq", allocationSize = 1, name = "test_id_seq")
	@Column(name = "TEST_ID", nullable = false, length = 40)
	private long test_id;
	@Column(name = "TEST_NAME", length = 64)
	private String test_name;
	
	// PASSED or FAILED or SKIPPED these are the three options TESTNG Has
	@Column(name = "TEST_CONTEXT", length = 9)
	private String test_context; // use ITestResult.getTestContext()
	
	@Column(name="IS_DELETED",length=16)
	private boolean isDeleted = false;
	@Column(name="TEST_RUN_DATE",length=64)
	private Timestamp test_run_date;
	@Column(name="TEST_RUNTIME",length=64)
	private String test_runtime;
	
	public UpdatedTest() {}

	/**
	 * @param test_id
	 * @param test_name
	 * @param test_context
	 * @param isDeleted
	 * @param test_run_date
	 * @param test_runtime
	 */
	public UpdatedTest(long test_id, String test_name, String test_context, boolean isDeleted, Timestamp test_run_date,
			String test_runtime) {
		super();
		this.test_id = test_id;
		this.test_name = test_name;
		this.test_context = test_context;
		this.isDeleted = isDeleted;
		this.test_run_date = test_run_date;
		this.test_runtime = test_runtime;
	}
	@XmlElement
	public long getTest_id() {
		return test_id;
	}

	public void setTest_id(long test_id) {
		this.test_id = test_id;
	}
	@XmlElement
	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	@XmlElement
	public String getTest_context() {
		return test_context;
	}

	public void setTest_context(String test_context) {
		this.test_context = test_context;
	}
	@XmlElement
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@XmlElement
	public Timestamp getTest_run_date() {
		return test_run_date;
	}

	public void setTest_run_date(Timestamp test_run_date) {
		this.test_run_date = test_run_date;
	}
	@XmlElement
	public String getTest_runtime() {
		return test_runtime;
	}

	public void setTest_runtime(String test_runtime) {
		this.test_runtime = test_runtime;
	}

	@Override
	public String toString() {
		return "UpdatedTest [test_id=" + test_id + ", test_name=" + test_name + ", test_context=" + test_context
				+ ", isDeleted=" + isDeleted + ", test_run_date=" + test_run_date + ", test_runtime=" + test_runtime
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((test_context == null) ? 0 : test_context.hashCode());
		result = prime * result + (int) (test_id ^ (test_id >>> 32));
		result = prime * result + ((test_name == null) ? 0 : test_name.hashCode());
		result = prime * result + ((test_run_date == null) ? 0 : test_run_date.hashCode());
		result = prime * result + ((test_runtime == null) ? 0 : test_runtime.hashCode());
		return result;
	}

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
		if (test_id != other.test_id)
			return false;
		if (test_name == null) {
			if (other.test_name != null)
				return false;
		} else if (!test_name.equals(other.test_name))
			return false;
		if (test_run_date == null) {
			if (other.test_run_date != null)
				return false;
		} else if (!test_run_date.equals(other.test_run_date))
			return false;
		if (test_runtime == null) {
			if (other.test_runtime != null)
				return false;
		} else if (!test_runtime.equals(other.test_runtime))
			return false;
		return true;
	}
	
}
