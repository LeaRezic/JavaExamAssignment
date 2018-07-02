/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.BasicDetailsVM;
import com.lea.dal.domain.entities.BasicDetails;

/**
 *
 * @author Lea
 */
public class BasicDetailsManager extends DataManager {

//    public BasicDetailsVM getById(int id) {
//        return convertFromEntityToViewModel(repository.getBasicDetailsById(id));
//    }
    public BasicDetailsVM createNew() {
        BasicDetailsVM viewModel = new BasicDetailsVM();
        viewModel.setIdbasicDetails(0);
//        viewModel.setAllCities(repository.getAllCities());
//        viewModel.setAllCountries(repository.getAllCountries());
        repository.getAllCities().forEach(c -> viewModel.getAllCities().add(c.getName()));
        repository.getAllCountries().forEach(c -> viewModel.getAllCountries().add(c.getName()));
        return viewModel;
    }

    public BasicDetailsVM convertFromEntityToViewModel(BasicDetails entity) {
        // stvori novi
        BasicDetailsVM viewModel = createNew();
        // setira sve
        viewModel.setIdbasicDetails(entity.getIdbasicDetails());
        viewModel.setFirstName(entity.getFirstName());
        viewModel.setMiddleName(entity.getMiddleName());
        viewModel.setLastName(entity.getLastName());
        viewModel.setCityName(entity.getCity().getName());
        viewModel.setCountryName(entity.getCity().getCountry().getName());
        viewModel.setFullStreet(entity.getFullStreet());
        viewModel.setPincode(entity.getPincode());
        viewModel.setTelephone(entity.getTelephone());
        viewModel.setMobilePhone(entity.getMobilePhone());
        viewModel.setEmail(entity.getEmail());
        // vraća viewmodel
        return viewModel;
    }

    public BasicDetails convertFromViewModelToEntity(BasicDetailsVM viewModel) {
        BasicDetails entity = new BasicDetails();
        entity.setIdbasicDetails(viewModel.getIdbasicDetails());
        entity.setFirstName(viewModel.getFirstName());
        entity.setMiddleName(viewModel.getMiddleName());
        entity.setLastName(viewModel.getLastName());
        entity.setFullStreet(viewModel.getFullStreet());
        entity.setPincode(viewModel.getPincode());
        entity.setTelephone(viewModel.getTelephone());
        entity.setMobilePhone(viewModel.getMobilePhone());
        entity.setEmail(viewModel.getEmail());

//        entity.setCity(viewModel.getAllCities().stream().findFirst().get());
//        entity.getCity().setCountry(viewModel.getAllCountries().stream().findFirst().get());
        repository.getAllCities()
                .stream()
                .filter(c -> c.getName().equals(viewModel.getCityName()))
                .findFirst()
                .ifPresent(c -> entity.setCity(c));

        repository.getAllCountries()
                .stream()
                .filter(c -> c.getName().equals(viewModel.getCountryName()))
                .findFirst()
                .ifPresent(c -> entity.getCity().setCountry(c));

        return entity;
    }

}
