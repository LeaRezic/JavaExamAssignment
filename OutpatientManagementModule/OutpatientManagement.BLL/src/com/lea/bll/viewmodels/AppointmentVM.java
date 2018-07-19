/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Lea
 */
public class AppointmentVM extends ViewModel {

    private DoctorVM doctor;
    private PatientVM patient;
    private Date date;
    private String diagnosis;
    private List<HospitalServiceVM> appointmentServices;

    public AppointmentVM(int id) {
        super(id);
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
