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
    
    public List<City> getAllCities();
    public City getCityById(int id);
    public List<Country> getAllCountries();

    public Patient getPatientById(int id);
    public List<Patient> getAllPatients();
    public Boolean insertOrUpdatePatient(Patient p);
    public List<Patient> getAllPatientsByDoctor(int id);

    public Doctor getDoctorById(int id);
    public List<Doctor> getAllDoctors();
    public Boolean insertOrUpdateDoctor(Doctor d);

    public List<DoctorSpecialization> getAllDoctorSpecializations();
    public DoctorSpecialization getDoctorSpecializationById(int id);
    
    public List<HospitalService> getAllHospitalServices();
    public HospitalService getHospitalServiceById(int id);
    
    public List<MaritalStatus> getAllMaritalStatuses();
    public MaritalStatus getMaritalStatusById(int id);
    public List<BloodType> getAllBloodTypes();
    public BloodType getBloodTypeById(int id);
    
    public List<Appointment> getAllAppointments();
    public Boolean insertOrUpdateAppointment();
    public Appointment getAppointmentById(int id);

    public EmergencyRegistration getEmergencyRegistrationById(int id);
    public List<EmergencyRegistration> getAllEmeregencyRegistrations();
    public Boolean insertEmergencyRegistration(EmergencyRegistration er);
    public void deleteEmergencyRegistration(EmergencyRegistration er);

}
