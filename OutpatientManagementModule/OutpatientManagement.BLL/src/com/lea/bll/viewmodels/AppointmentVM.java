/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Lea
 */
public class AppointmentVM extends ViewModel {

    private int idappointment;
    private DoctorVM doctor;
    private PatientVM patient;
    private Date date;
    private String diagnosis;
    private List<HospitalServiceVM> appointmentServices;

    public AppointmentVM() {
        doctor = new DoctorVM();
        patient = new PatientVM();
        appointmentServices = new ArrayList<HospitalServiceVM>();
    }

    public AppointmentVM(int idappointment, DoctorVM doctor, PatientVM patient, Date date, String diagnosis, List<HospitalServiceVM> appointmentServices) {
        this.idappointment = idappointment;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.diagnosis = diagnosis;
        this.appointmentServices = appointmentServices;
    }

    public int getIdappointment() {
        return idappointment;
    }

    public void setIdappointment(int idappointment) {
        this.idappointment = idappointment;
    }

    public DoctorVM getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorVM doctor) {
        this.doctor = doctor;
    }

    public PatientVM getPatient() {
        return patient;
    }

    public void setPatient(PatientVM patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<HospitalServiceVM> getAppointmentServices() {
        return appointmentServices;
    }

    public void setAppointmentServices(List<HospitalServiceVM> appointmentServices) {
        this.appointmentServices = appointmentServices;
    }

    
    
}
