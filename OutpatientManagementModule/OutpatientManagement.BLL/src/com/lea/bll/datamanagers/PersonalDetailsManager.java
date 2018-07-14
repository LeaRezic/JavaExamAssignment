/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.PersonalDetailsVM;
import com.lea.bll.viewmodels.PersonalDetailsVM.Sex;
import com.lea.dal.domain.entities.PersonalDetails;

/**
 *
 * @author Lea
 */
public class PersonalDetailsManager extends DataManager {
    
    
    public PersonalDetailsVM createNew() {
        PersonalDetailsVM viewModel = new PersonalDetailsVM(0);
        viewModel.setAllBloodTypes(repository.getAllBloodTypes());
        viewModel.setAllMaritalStatus(repository.getAllMaritalStatuses());
        return viewModel;
    }
    
    public PersonalDetailsVM convertFromEntityToViewModel(PersonalDetails entity) {
        PersonalDetailsVM viewModel = new PersonalDetailsVM(entity.getIdpersonalDetails());
        viewModel.setSex(entity.getSex() == true ? Sex.F : Sex.M);
        viewModel.setDateOfBirth(entity.getDateOfBirth());
        viewModel.setHeight(entity.getHeight());
        viewModel.setWeight(entity.getWeight());
        viewModel.setOccupation(entity.getOccupation());
        viewModel.setBloodType(entity.getBloodType().getName());
        viewModel.setMaritalStatus(entity.getMaritalStatus().getName());
        return viewModel;
    }
    
    public PersonalDetails convertFromViewModelToEntity(PersonalDetailsVM viewModel) {
        PersonalDetails entity = new PersonalDetails();
        entity.setIdpersonalDetails(viewModel.getId());
        entity.setDateOfBirth(viewModel.getDateOfBirth());
        entity.setSex(viewModel.getSex() == Sex.F);
        entity.setHeight(viewModel.getHeight());
        entity.setWeight(viewModel.getWeight());
        entity.setOccupation(viewModel.getOccupation());
        
        viewModel.getAllBloodTypes()
                .stream()
                .filter(b -> b.getName().equals(viewModel.getBloodType()))
                .findFirst()
                .ifPresent(b -> entity.setBloodType(b));
        
        viewModel.getAllMaritalStatus()
                .stream()
                .filter(m -> m.getName().equals(viewModel.getMaritalStatus()))
                .findFirst()
                .ifPresent(m -> entity.setMaritalStatus(m));
        
        return entity;
    }
    
}
