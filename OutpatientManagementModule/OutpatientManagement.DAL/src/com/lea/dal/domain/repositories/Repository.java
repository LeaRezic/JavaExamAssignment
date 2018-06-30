/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.dal.domain.repositories;

import com.lea.dal.domain.entities.*;
import java.util.List;

/**
 *
 * @author Lea
 */
public interface Repository {

    public Patient getPatientById(int id);
    public List<Patient> getAllPatients();
    public Boolean insertOrUpdatePatient(Patient p);

    public Doctor getDoctorById(int id);
    public List<Doctor> getAllDoctors();
    public Boolean insertOrUpdateDoctor(Doctor d);
    
    public List<MaritalStatus> getAllMaritalStatuses();
    public List<DoctorSpecialization> getAllDoctorSpecializations();
    public List<BloodType> getAllBloodTypes();
    public List<HospitalService> getAllHospitalServices();

    public List<Appointment> getAllAppointments();
    public Boolean insertOrUpdateAppointment();
    
    public EmergencyRegistration getEmergencyRegistrationById(int id);
    public List<EmergencyRegistration> getAllEmeregencyRegistrations();
    
    

}
