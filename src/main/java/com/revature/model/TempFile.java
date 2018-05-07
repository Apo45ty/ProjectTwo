/**
 * 
 */
package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ed M
 * @date May 7, 2018
 * @time time 3:00:14 PM
 */

@XmlRootElement
@Entity
@Table(name="TempFile")
public class TempFile {

	/**
	 * Tap Tap Tap
	 * Long is Longer than short
	 */

		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqname")
		@SequenceGenerator(initialValue=1,sequenceName="seq_name",allocationSize=1,name="seqname")
		@Column(name="ID",nullable=false)
		private long id;
		@Column(name="TEST_ID",length=40)
		private long testID;
		@Column(name="COMMENTS",length=400)
		private String comments;
		@Column(name="RESULT",length=40)
		private String result;
		@Column(name="IS_DELETED",length=40)
		private boolean isDeleted = false;
		@Column(name="SYSTEM_ID",length=40)
		private long systemID;
		
		
		public TempFile() {}

}
