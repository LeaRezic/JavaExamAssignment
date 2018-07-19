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

    public BasicDetailsVM createNew() {
        BasicDetailsVM viewModel = new BasicDetailsVM(0);
        return viewModel;
    }

    public BasicDetailsVM createNew(boolean Emergency) {
        int id = Emergency ? -1 : 0;
        BasicDetailsVM viewModel = new BasicDetailsVM(id);
        return viewModel;
    }

    public BasicDetailsVM convertFromEntityToViewModel(BasicDetails entity) {
        // stvori novi
        BasicDetailsVM viewModel = new BasicDetailsVM(entity.getIdbasicDetails());
        // setira sve
        viewModel.setFirstName(entity.getFirstName());
        viewModel.setMiddleName(entity.getMiddleName());
        viewModel.setLastName(entity.getLastName());
        viewModel.setCityId(entity.getCity().getIdcity());
        viewModel.setCountryId(entity.getCity().getCountry().getIdcountry());
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
        int id = viewModel.getId() == -1 ? 0 : viewModel.getId();
        entity.setIdbasicDetails(id);
        entity.setFirstName(viewModel.getFirstName());
        entity.setMiddleName(viewModel.getMiddleName());
        entity.setLastName(viewModel.getLastName());
        entity.setFullStreet(viewModel.getFullStreet());
        entity.setPincode(viewModel.getPincode());
        entity.setTelephone(viewModel.getTelephone());
        entity.setMobilePhone(viewModel.getMobilePhone());
        entity.setEmail(viewModel.getEmail());
        // za grad
        entity.setCity(repository.getCityById(viewModel.getCityId()));
        return entity;
    }

}
