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
                .forEach(c-> citiesList.add(new OptionKeyValue(c.getIdcity(), c.getName())));
        return citiesList;
    }
    
    public List<OptionKeyValue> getAllCitiesByCountry(int id) {
        List<OptionKeyValue> citiesList = new ArrayList<>();
        repository.getAllCities()
                .stream()
                .filter(c->c.getCountry().getIdcountry() == id)
                .sorted(Comparator.comparing(City::getName))
                .forEach(c-> citiesList.add(new OptionKeyValue(c.getIdcity(), c.getName())));
        return citiesList;
    }
    
    public List<OptionKeyValue> getAllProfessions() {
        List<OptionKeyValue> professionsList = new ArrayList<>();
        repository.getAllDoctorSpecializations()
                .forEach(s-> professionsList.add(new OptionKeyValue(s.getIddoctorSpecialization(), s.getName())));
        return professionsList;
    }
    
}
