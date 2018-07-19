package com.lea.dal.domain.entities;
// Generated 28.06.2018. 08:51:52 by Hibernate Tools 4.3.1

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
 * HospitalServiceCategory generated by hbm2java
 */
@Entity
@Table(name = "HospitalServiceCategory",
         schema = "dbo",
         catalog = "VirgoHospitals"
)
public class HospitalServiceCategory implements EntityBase, java.io.Serializable {

    private int idhospitalServiceCategory;
    private String name;
    private Set<HospitalService> hospitalServices = new HashSet<HospitalService>(0);

    public HospitalServiceCategory() {
    }

    public HospitalServiceCategory(int idhospitalServiceCategory, String name) {
        this.idhospitalServiceCategory = idhospitalServiceCategory;
        this.name = name;
    }

    public HospitalServiceCategory(int idhospitalServiceCategory, String name, Set<HospitalService> hospitalServices) {
        this.idhospitalServiceCategory = idhospitalServiceCategory;
        this.name = name;
        this.hospitalServices = hospitalServices;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDHospitalServiceCategory", unique = true, nullable = false)
    public int getIdhospitalServiceCategory() {
        return this.idhospitalServiceCategory;
    }

    public void setIdhospitalServiceCategory(int idhospitalServiceCategory) {
        this.idhospitalServiceCategory = idhospitalServiceCategory;
    }

    @Column(name = "Name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hospitalServiceCategory")
    public Set<HospitalService> getHospitalServices() {
        return this.hospitalServices;
    }

    public void setHospitalServices(Set<HospitalService> hospitalServices) {
        this.hospitalServices = hospitalServices;
    }

    @Override
    public int fetchEntityId() {
        return getIdhospitalServiceCategory();
    }

}
