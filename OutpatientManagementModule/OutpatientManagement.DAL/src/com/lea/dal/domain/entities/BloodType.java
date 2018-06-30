package com.lea.dal.domain.entities;

// Generated 30.06.2018. 18:46:55 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BloodType generated by hbm2java
 */
@Entity
@Table(name="BloodType"
    ,schema="dbo"
    ,catalog="VirgoHospitals"
)
public class BloodType  implements java.io.Serializable {


     private int idbloodType;
     private String name;
     private Set<PersonalDetails> personalDetailses = new HashSet<PersonalDetails>(0);

    public BloodType() {
    }

	
    public BloodType(int idbloodType) {
        this.idbloodType = idbloodType;
    }
    public BloodType(int idbloodType, String name, Set<PersonalDetails> personalDetailses) {
       this.idbloodType = idbloodType;
       this.name = name;
       this.personalDetailses = personalDetailses;
    }
   
     @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDBloodType", unique=true, nullable=false)
    public int getIdbloodType() {
        return this.idbloodType;
    }
    
    public void setIdbloodType(int idbloodType) {
        this.idbloodType = idbloodType;
    }

    
    @Column(name="Name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="bloodType")
    public Set<PersonalDetails> getPersonalDetailses() {
        return this.personalDetailses;
    }
    
    public void setPersonalDetailses(Set<PersonalDetails> personalDetailses) {
        this.personalDetailses = personalDetailses;
    }




}


