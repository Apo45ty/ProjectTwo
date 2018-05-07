package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="System")
public class System{

    @Id
    @GeneratedValue(strategy=Generationtype.SEQUENCE,generator="seqname")
    @SequenceGenerator(initialValue=1, sequenceName="seq_name",allocationSize=1,name="seqname")
    @Column(name="ID", nullable=false)
    private long id;
    
    private String cpu;
    
    private String os;
    
    private String ram;
    
    private String diskDrive;
    
    
}

