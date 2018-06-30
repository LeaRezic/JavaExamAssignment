package com.lea.dal.domain.entities;
// Generated 28.06.2018. 08:51:52 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * HospitalService generated by hbm2java
 */
@Entity
@Table(name="HospitalService"
    ,schema="dbo"
    ,catalog="VirgoHospitals"
)
public class HospitalService extends EntityBase implements java.io.Serializable {


     private int idhospitalService;
     private HospitalServiceCategory hospitalServiceCategory;
     private String name;
     private String description;
     private BigDecimal basicPrice;
     private Set<AppointmentService> appointmentServices = new HashSet<AppointmentService>(0);

    public HospitalService() {
    }

	
    public HospitalService(int idhospitalService, HospitalServiceCategory hospitalServiceCategory, String name, BigDecimal basicPrice) {
        this.idhospitalService = idhospitalService;
        this.hospitalServiceCategory = hospitalServiceCategory;
        this.name = name;
        this.basicPrice = basicPrice;
    }
    public HospitalService(int idhospitalService, HospitalServiceCategory hospitalServiceCategory, String name, String description, BigDecimal basicPrice, Set<AppointmentService> appointmentServices) {
       this.idhospitalService = idhospitalService;
       this.hospitalServiceCategory = hospitalServiceCategory;
       this.name = name;
       this.description = description;
       this.basicPrice = basicPrice;
       this.appointmentServices = appointmentServices;
    }
   
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDHospitalService", unique=true, nullable=false)
    public int getIdhospitalService() {
        return this.idhospitalService;
    }
    
    public void setIdhospitalService(int idhospitalService) {
        this.idhospitalService = idhospitalService;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CategoryID", nullable=false)
    public HospitalServiceCategory getHospitalServiceCategory() {
        return this.hospitalServiceCategory;
    }
    
    public void setHospitalServiceCategory(HospitalServiceCategory hospitalServiceCategory) {
        this.hospitalServiceCategory = hospitalServiceCategory;
    }

    
    @Column(name="Name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="Description")
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="BasicPrice", nullable=false, scale=4)
    public BigDecimal getBasicPrice() {
        return this.basicPrice;
    }
    
    public void setBasicPrice(BigDecimal basicPrice) {
        this.basicPrice = basicPrice;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="hospitalService")
    public Set<AppointmentService> getAppointmentServices() {
        return this.appointmentServices;
    }
    
    public void setAppointmentServices(Set<AppointmentService> appointmentServices) {
        this.appointmentServices = appointmentServices;
    }




}


