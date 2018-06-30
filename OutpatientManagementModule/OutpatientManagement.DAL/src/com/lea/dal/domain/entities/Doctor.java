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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Doctor generated by hbm2java
 */
@Entity
@Table(name = "Doctor",
         schema = "dbo",
         catalog = "VirgoHospitals",
         uniqueConstraints = @UniqueConstraint(columnNames = "BasicDetailsID")
)
public class Doctor implements java.io.Serializable {

    private int iddoctor;
    private BasicDetails basicDetails;
    private DoctorSpecialization doctorSpecialization;
    private String title;
    private boolean active;
    private Set<Appointment> appointments = new HashSet<Appointment>(0);

    public Doctor() {
    }

    public Doctor(int iddoctor, DoctorSpecialization doctorSpecialization, String title, boolean active) {
        this.iddoctor = iddoctor;
        this.doctorSpecialization = doctorSpecialization;
        this.title = title;
        this.active = active;
    }

    public Doctor(int iddoctor, BasicDetails basicDetails, DoctorSpecialization doctorSpecialization, String title, boolean active, Set<Appointment> appointments) {
        this.iddoctor = iddoctor;
        this.basicDetails = basicDetails;
        this.doctorSpecialization = doctorSpecialization;
        this.title = title;
        this.active = active;
        this.appointments = appointments;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDDoctor", unique = true, nullable = false)
    public int getIddoctor() {
        return this.iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BasicDetailsID", unique = true)
    public BasicDetails getBasicDetails() {
        return this.basicDetails;
    }

    public void setBasicDetails(BasicDetails basicDetails) {
        this.basicDetails = basicDetails;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SpecializationID", nullable = false)
    public DoctorSpecialization getDoctorSpecialization() {
        return this.doctorSpecialization;
    }

    public void setDoctorSpecialization(DoctorSpecialization doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    @Column(name = "Title", nullable = false)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "Active", nullable = false)
    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
    public Set<Appointment> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

}
