/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.PersonalDetailsVM;
import com.lea.bll.viewmodels.PersonalDetailsVM.Sex;
import com.lea.dal.domain.entities.PersonalDetails;
import java.text.ParseException;

/**
 *
 * @author Lea
 */
public class PersonalDetailsManager extends DataManager {

    public PersonalDetailsVM createNew() {
        PersonalDetailsVM viewModel = new PersonalDetailsVM(0);
        return viewModel;
    }
    
    public PersonalDetailsVM createNew(boolean emergency) {
        int id = emergency ? -1 : 0;
        PersonalDetailsVM viewModel = new PersonalDetailsVM(id);
        return viewModel;
    }

    PersonalDetailsVM convertFromEntityToViewModel(PersonalDetails entity) throws ParseException {
        PersonalDetailsVM viewModel = new PersonalDetailsVM(entity.getIdpersonalDetails());
        viewModel.setSex(entity.getSex() == true ? Sex.F : Sex.M);
        viewModel.setDateOfBirth(entity.getDateOfBirth());
        viewModel.setHeight(entity.getHeight());
        viewModel.setWeight(entity.getWeight());
        viewModel.setOccupation(entity.getOccupation());
        viewModel.setBloodTypeId(entity.getBloodType().getIdbloodType());
        viewModel.setMaritalStatusId(entity.getMaritalStatus().getIdmaritalStatus());
        return viewModel;
    }

    PersonalDetails convertFromViewModelToEntity(PersonalDetailsVM viewModel) throws ParseException {
        PersonalDetails entity = new PersonalDetails();
        int id = viewModel.getId() == -1 ? 0 : viewModel.getId();
        entity.setIdpersonalDetails(id);
        entity.setDateOfBirth(viewModel.getDateOfBirth());
        entity.setSex(viewModel.getSex() == Sex.F);
        entity.setHeight(viewModel.getHeight());
        entity.setWeight(viewModel.getWeight());
        entity.setOccupation(viewModel.getOccupation());
        entity.setBloodType(repository.getBloodTypeById(viewModel.getBloodTypeId()));
        entity.setMaritalStatus(repository.getMaritalStatusById(viewModel.getMaritalStatusId()));
        return entity;
    }

}
