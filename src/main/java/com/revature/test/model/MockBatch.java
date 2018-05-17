/**
 * 
 */
package com.revature.test.model;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 * @author Ed M
 * @date May 16, 2018
 * @time time 11:39:58 AM
 */
public class MockBatch {
	private String name;
	private String curriculum;
	private String trainer;
	private String location;
	private String building;
	private String room;
	private String startDate;
	private String endDate;

	/**
	 * @param name
	 * @param curriculum
	 * @param trainer
	 * @param location
	 * @param building
	 * @param room
	 * @param startDate
	 * @param endDate
	 */

	public MockBatch(String name, String curriculum, String trainer, String location, String building, String room,
			String startDate, String endDate) {
		super();
		this.name = name;
		this.curriculum = curriculum;
		this.trainer = trainer;
		this.location = location;
		this.building = building;
		this.room = room;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((curriculum == null) ? 0 : curriculum.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		MockBatch other = (MockBatch) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (curriculum == null) {
			if (other.curriculum != null)
				return false;
		} else if (!curriculum.equals(other.curriculum))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		} else if (!trainer.equals(other.trainer))
			return false;
		return true;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the curriculum
	 */
	public String getCurriculum() {
		return curriculum;
	}

	/**
	 * @param curriculum
	 *            the curriculum to set
	 */
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	/**
	 * @return the trainer
	 */
	public String getTrainer() {
		return trainer;
	}

	/**
	 * @param trainer
	 *            the trainer to set
	 */
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}

	/**
	 * @param building
	 *            the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * @return the room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * @param room
	 *            the room to set
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MockBatch [name=" + name + ", curriculum=" + curriculum + ", trainer=" + trainer + ", location="
				+ location + ", building=" + building + ", room=" + room + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}

	static public class SortByName implements Comparator<MockBatch> {

		@Override
		public int compare(MockBatch o1, MockBatch o2) {
			Collator usCollator = Collator.getInstance(Locale.US);
			usCollator.setStrength(Collator.PRIMARY);// Making it so it matches the type of sort of the site works
			return usCollator.compare(o1.getName(), o2.getName());

		}

	}

	static public class SortByCurriculum implements Comparator<MockBatch> {

		@Override
		public int compare(MockBatch o1, MockBatch o2) {
			Collator usCollator = Collator.getInstance(Locale.US);
			usCollator.setStrength(Collator.PRIMARY);// Making it so it matches the type of sort of the site works
			return usCollator.compare(o1.getCurriculum(), o2.getCurriculum());
		}

	}

	static public class SortByTrainer implements Comparator<MockBatch> {
		@Override
		public int compare(MockBatch o1, MockBatch o2) {
			Collator usCollator = Collator.getInstance(Locale.US);
			usCollator.setStrength(Collator.PRIMARY);// Making it so it matches the type of sort of the site works
			return usCollator.compare(o1.getTrainer() ,o2.getTrainer());
		}

	}

	static public class SortByLocation implements Comparator<MockBatch> {
		@Override
		public int compare(MockBatch o1, MockBatch o2) {
			Collator usCollator = Collator.getInstance(Locale.US);
			usCollator.setStrength(Collator.PRIMARY);// Making it so it matches the type of sort of the site works
			return usCollator.compare(o1.getLocation(), o2.getLocation());
		}

	}

	static public class SortByBuilding implements Comparator<MockBatch> {
		@Override
		public int compare(MockBatch o1, MockBatch o2) {
			Collator usCollator = Collator.getInstance(Locale.US);
			usCollator.setStrength(Collator.PRIMARY);// Making it so it matches the type of sort of the site works
			return usCollator.compare(o1.getBuilding(), o2.getBuilding());
		}

	}

	static public class SortByRoom implements Comparator<MockBatch> {
		@Override
		public int compare(MockBatch o1, MockBatch o2) {
			Collator usCollator = Collator.getInstance(Locale.US);
			usCollator.setStrength(Collator.PRIMARY);// Making it so it matches the type of sort of the site works
			return usCollator.compare(o1.getRoom(), o2.getRoom());
		}

	}

	static public class SortByStartDate implements Comparator<MockBatch> {
		@Override
		public int compare(MockBatch o1, MockBatch o2) {
			Collator usCollator = Collator.getInstance(Locale.US);
			usCollator.setStrength(Collator.PRIMARY);// Making it so it matches the type of sort of the site works
			return usCollator.compare(o1.getStartDate(), o2.getStartDate());
		}

	}

	static public class SortByStartEndDate implements Comparator<MockBatch> {
		@Override
		public int compare(MockBatch o1, MockBatch o2) {
			Collator usCollator = Collator.getInstance(Locale.US);
			usCollator.setStrength(Collator.PRIMARY);// Making it so it matches the type of sort of the site works
			return usCollator.compare(o1.getEndDate(), o2.getEndDate());
		}

	}

}
