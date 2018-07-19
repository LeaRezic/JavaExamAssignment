/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.EmergencyRegistrationVM;
import com.lea.dal.domain.entities.EmergencyRegistration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lea
 */
public class EmergencyRegistrationManager extends DataManager {

    public EmergencyRegistrationVM createNew() {
        return new EmergencyRegistrationVM(0);
    }
    
    public List<EmergencyRegistrationVM> getAll() {
        List<EmergencyRegistrationVM> registrations = new ArrayList<>();
        repository.getAllEmeregencyRegistrations().forEach(e -> registrations.add(convertFromEntityToViewModel(e)));
        return registrations;
    }
    
    public EmergencyRegistrationVM getById(int id) {
        return convertFromEntityToViewModel(repository.getEmergencyRegistrationById(id));
    }
    
    public void saveChanges(EmergencyRegistrationVM viewModel) {
        repository.insertEmergencyRegistration(convertFromViewModelToEntity(viewModel));
    }
    
    public void delete(EmergencyRegistrationVM viewModel) {
        repository.deleteEmergencyRegistration(convertFromViewModelToEntity(viewModel));
    }

    public EmergencyRegistrationVM convertFromEntityToViewModel(EmergencyRegistration entity) {
        // stvori novi
        EmergencyRegistrationVM viewModel = new EmergencyRegistrationVM(entity.getIdemergencyRegistration());
        // setira sve za pacijenta
        viewModel.setPatientFirstName(entity.getPatientFirstName());
        viewModel.setPatientMiddleName(entity.getPatientMiddleName());
        viewModel.setPatientLastName(entity.getPatientLastName());
        viewModel.setPatientContact(entity.getPatientContact());
        viewModel.setRelationshipOfRelative(entity.getRelationshipOfRelative());
        viewModel.setBriefComplaint(entity.getBriefComplaint());
        viewModel.setRegistryDate(entity.getRegistryDate());
        // za next of kin
        viewModel.setRelativeFirstName(entity.getRelativeFirstName());
        viewModel.setRelativeMiddleName(entity.getRelativeMiddleName());
        viewModel.setRelativeLastName(entity.getRelativeLastName());
        viewModel.setRelativeContact(entity.getRelativeContact());
        // vraća viewmodel
        return viewModel;
    }

    public EmergencyRegistration convertFromViewModelToEntity(EmergencyRegistrationVM viewModel) {
        EmergencyRegistration entity = new EmergencyRegistration();
        entity.setIdemergencyRegistration(viewModel.getId());
        entity.setRegistryDate(viewModel.getRegistryDate());
        entity.setPatientFirstName(viewModel.getPatientFirstName());
        entity.setPatientMiddleName(viewModel.getPatientMiddleName());
        entity.setPatientLastName(viewModel.getPatientLastName());
        entity.setPatientContact(viewModel.getPatientContact());
        entity.setRelationshipOfRelative(viewModel.getRelationshipOfRelative());
        entity.setBriefComplaint(viewModel.getBriefComplaint());
        // za next of kin
        entity.setRelativeFirstName(viewModel.getRelativeFirstName());
        entity.setRelativeMiddleName(viewModel.getRelativeMiddleName());
        entity.setRelativeLastName(viewModel.getRelativeLastName());
        entity.setRelativeContact(viewModel.getRelativeContact());
        // vraća
        return entity;
    }

}
