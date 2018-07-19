/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.dal.domain.entities.City;
import java.util.List;
import com.lea.utilities.OptionKeyValue;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Lea
 */
public class DdlDataManager extends DataManager {

    public List<OptionKeyValue> getAllCountries() {
        List<OptionKeyValue> countriesList = new ArrayList<>();
        repository.getAllCountries()
                .forEach(c -> countriesList.add(new OptionKeyValue(c.getIdcountry(), c.getName())));
        return countriesList;
    }

    public List<OptionKeyValue> getAllCities() {
        List<OptionKeyValue> citiesList = new ArrayList<>();
        repository.getAllCities()
                .stream()
                .sorted(Comparator.comparing(City::getName))
                .forEach(c -> citiesList.add(new OptionKeyValue(c.getIdcity(), c.getName())));
        return citiesList;
    }

    public List<OptionKeyValue> getAllCitiesByCountry(int id) {
        List<OptionKeyValue> citiesList = new ArrayList<>();
        repository.getAllCities()
                .stream()
                .filter(c -> c.getCountry().getIdcountry() == id)
                .sorted(Comparator.comparing(City::getName))
                .forEach(c -> citiesList.add(new OptionKeyValue(c.getIdcity(), c.getName())));
        return citiesList;
    }

    public List<OptionKeyValue> getAllProfessions() {
        List<OptionKeyValue> professionsList = new ArrayList<>();
        repository.getAllDoctorSpecializations()
                .forEach(s -> professionsList.add(new OptionKeyValue(s.getIddoctorSpecialization(), s.getName())));
        return professionsList;
    }

    public List<OptionKeyValue> getAllBloodTypes() {
        List<OptionKeyValue> bloodTypes = new ArrayList<>();
        repository.getAllBloodTypes()
                .forEach(b -> bloodTypes.add(new OptionKeyValue(b.getIdbloodType(), b.getName())));
        return bloodTypes;
    }
    
    public List<OptionKeyValue> getAllMaritalStatuses() {
        List<OptionKeyValue> maritalStatuses = new ArrayList<>();
        repository.getAllMaritalStatuses()
                .forEach(m -> maritalStatuses.add(new OptionKeyValue(m.getIdmaritalStatus(), m.getName())));
        return maritalStatuses;
    }

    public List<OptionKeyValue> getAllMedicine() {
        return getAllHospitalServicesOfCategory("Medicine");
    }

    public List<OptionKeyValue> getAllLaboratoryTests() {
        return getAllHospitalServicesOfCategory("Laboratory_Test");
    }

    public List<OptionKeyValue> getAllConsultations() {
        return getAllHospitalServicesOfCategory("Medical_Consultation");
    }

    private List<OptionKeyValue> getAllHospitalServicesOfCategory(String categoryName) {
        List<OptionKeyValue> hospitalServices = new ArrayList<>();
        repository.getAllHospitalServices()
                .stream()
                .filter(h -> h.getHospitalServiceCategory().getName().equals(categoryName))
                .forEach(c -> hospitalServices.add(new OptionKeyValue(c.getIdhospitalService(), c.getName())));
        return hospitalServices;
    }

    // ovo još popravit dakako
    public List<OptionKeyValue> getAllEmergencyRegistrations() {
        List<OptionKeyValue> emergencyRegistrations = new ArrayList<>();
        repository.getAllHospitalServices()
                .stream()
                .forEach(c -> emergencyRegistrations.add(new OptionKeyValue(c.getIdhospitalService(), c.getName())));
        return emergencyRegistrations;
    }
    
    public List<OptionKeyValue> getAllDoctors() {
        List<OptionKeyValue> doctors = new ArrayList<>();
        repository.getAllDoctors()
                .stream()
                .forEach(c -> doctors.add(new OptionKeyValue(c.getIddoctor(), c.toString())));
        return doctors;
    }
    
    public List<OptionKeyValue> getAllAppointments() {
        List<OptionKeyValue> appointments = new ArrayList<>();
        repository.getAllAppointments()
                .stream()
                .forEach(a -> appointments.add(new OptionKeyValue(a.getIdappointment(), a.toString())));
        return appointments;
    }

}
