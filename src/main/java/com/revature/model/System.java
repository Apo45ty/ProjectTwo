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
@Table(name="System")
public class System{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqname1")
    @SequenceGenerator(initialValue=1, sequenceName="seq_name1",allocationSize=1,name="seqname1")
    @Column(name="ID", nullable=false)
    private long id=0L;
    @Column(name="CPU", length=40)
    private String cpu="";
    @Column(name="OS", length=40)
    private String os="";
    @Column(name="RAM", length=40)
    private String ram="";
    @Column(name="DiskDrive", length=40)
    private String diskDrive="";
    
	public System(long id, String cpu, String os, String ram, String diskDrive) {
		super();
		this.id = id;
		this.cpu = cpu;
		this.os = os;
		this.ram = ram;
		this.diskDrive = diskDrive;
	}

	public System() {
		super();
	}

	@XmlElement
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlElement
	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	@XmlElement
	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@XmlElement
	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	@XmlElement
	public String getDiskDrive() {
		return diskDrive;
	}

	public void setDiskDrive(String diskDrive) {
		this.diskDrive = diskDrive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpu == null) ? 0 : cpu.hashCode());
		result = prime * result + ((diskDrive == null) ? 0 : diskDrive.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + ((ram == null) ? 0 : ram.hashCode());
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
		System other = (System) obj;
		if (cpu == null) {
			if (other.cpu != null)
				return false;
		} else if (!cpu.equals(other.cpu))
			return false;
		if (diskDrive == null) {
			if (other.diskDrive != null)
				return false;
		} else if (!diskDrive.equals(other.diskDrive))
			return false;
		if (id != other.id)
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (ram == null) {
			if (other.ram != null)
				return false;
		} else if (!ram.equals(other.ram))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "System [id=" + id + ", cpu=" + cpu + ", os=" + os + ", ram=" + ram + ", diskDrive=" + diskDrive + "]";
	}
    
    
}

