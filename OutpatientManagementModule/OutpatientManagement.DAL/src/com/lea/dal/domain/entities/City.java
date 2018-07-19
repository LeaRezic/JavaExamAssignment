package com.lea.dal.domain.entities;
// Generated 28.06.2018. 08:51:52 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * City generated by hbm2java
 */
@Entity
@Table(name="City"
    ,schema="dbo"
    ,catalog="VirgoHospitals"
)
public class City implements EntityBase, java.io.Serializable {

    private int idcity;
     private Country country;
     private String name;

    public City() {
    }

	
    public City(int idcity, Country country, String name) {
        this.idcity = idcity;
        this.country = country;
        this.name = name;
    }
   
     @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDCity", unique=true, nullable=false)
    public int getIdcity() {
        return this.idcity;
    }
    
    public void setIdcity(int idcity) {
        this.idcity = idcity;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CountryID", nullable=false)
    public Country getCountry() {
        return this.country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }

    
    @Column(name="Name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int fetchEntityId() {
        return getIdcity();
    }

}


