package com.lea.dal.domain.entities;
// Generated 28.06.2018. 08:51:52 by Hibernate Tools 4.3.1


import com.lea.utilities.DateConverter;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Appointment generated by hbm2java
 */
@Entity
@Table(name="Appointment"
    ,schema="dbo"
    ,catalog="VirgoHospitals"
)
public class Appointment implements EntityBase, java.io.Serializable {

     private int idappointment;
     private Doctor doctor;
     private Patient patient;
     private Date date;
     private String diagnosis;
     private Set<AppointmentService> appointmentServices = new HashSet<AppointmentService>(0);
     private Set<Receipt> receipts = new HashSet<Receipt>(0);

    public Appointment() {
    }

	
    public Appointment(int idappointment, Doctor doctor, Patient patient, Date date) {
        this.idappointment = idappointment;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }
    public Appointment(int idappointment, Doctor doctor, Patient patient, Date date, String diagnosis, Set<AppointmentService> appointmentServices, Set<Receipt> receipts) {
       this.idappointment = idappointment;
       this.doctor = doctor;
       this.patient = patient;
       this.date = date;
       this.diagnosis = diagnosis;
       this.appointmentServices = appointmentServices;
       this.receipts = receipts;
    }
   
     @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDAppointment", unique=true, nullable=false)
    public int getIdappointment() {
        return this.idappointment;
    }
    
    public void setIdappointment(int idappointment) {
        this.idappointment = idappointment;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DoctorID", nullable=false)
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PatientID", nullable=false)
    public Patient getPatient() {
        return this.patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="Date", nullable=false, length=10)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    
    @Column(name="Diagnosis")
    public String getDiagnosis() {
        return this.diagnosis;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="appointment")
    public Set<AppointmentService> getAppointmentServices() {
        return this.appointmentServices;
    }
    
    public void setAppointmentServices(Set<AppointmentService> appointmentServices) {
        this.appointmentServices = appointmentServices;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="appointment")
    public Set<Receipt> getReceipts() {
        return this.receipts;
    }
    
    public void setReceipts(Set<Receipt> receipts) {
        this.receipts = receipts;
    }

    @Override
    public int fetchEntityId() {
        return idappointment;
    }

    @Override
    public String toString() {
        return DateConverter.getStringFromDate(date) + ", patient: " + patient.getBasicDetailsByBasicDetailsId().getLastName();
    }
    
}


