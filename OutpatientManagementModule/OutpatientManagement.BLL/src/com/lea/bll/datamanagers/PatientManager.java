/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.EmergencyRegistrationVM;
import com.lea.bll.viewmodels.PatientDetailsVM;
import com.lea.bll.viewmodels.PatientVM;
import com.lea.bll.viewmodels.PersonalDetailsVM;
import com.lea.dal.domain.entities.Patient;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lea
 */
public class PatientManager extends DataManager {

    private final BasicDetailsManager basicDetailsManager;
    private final PersonalDetailsManager personalDetailsManager;
    private final MedicalDetailsManager medicalDetailsManager;
    private final ComplaintDetailsManager complaintDetailsManager;
    private final LifestyleDetailsManager lifestyleDetailsManager;
    private final EmergencyRegistrationManager registrationManager;

    public PatientManager() {
        this.lifestyleDetailsManager = new LifestyleDetailsManager();
        this.complaintDetailsManager = new ComplaintDetailsManager();
        this.medicalDetailsManager = new MedicalDetailsManager();
        this.personalDetailsManager = new PersonalDetailsManager();
        this.basicDetailsManager = new BasicDetailsManager();
        this.registrationManager = new EmergencyRegistrationManager();
    }

    public PatientVM createNew() {
        PatientVM viewModel = new PatientVM(0);
        viewModel.setPatientDetails(new PatientDetailsVM());
        viewModel.setBasicDetailsByBasicDetailsId(basicDetailsManager.createNew(true));
        viewModel.setBasicDetailsByNextOfKinId(basicDetailsManager.createNew(true));
        viewModel.setComplaintDetails(complaintDetailsManager.createNew(true));
        viewModel.setPersonalDetails(personalDetailsManager.createNew(true));
        viewModel.setMedicalDetails(medicalDetailsManager.createNew());
        viewModel.setLifestyleDetails(lifestyleDetailsManager.createNew());
        return viewModel;
    }

    public List<PatientVM> getAll() throws ParseException {
        List<PatientVM> patients = new ArrayList<>();
        for (int i = 0; i < repository.getAllPatients().size(); i++) {
            patients.add(convertEntityToViewModel(repository.getAllPatients().get(i)));
        }
        return patients;
    }
    
    public List<PatientVM> getAllByDoctor(int id) throws ParseException {
        List<PatientVM> patients = new ArrayList<>();
        for (int i = 0; i < repository.getAllPatientsByDoctor(id).size(); i++) {
            patients.add(convertEntityToViewModel(repository.getAllPatientsByDoctor(id).get(i)));
        }
        return patients;
    }

    public PatientVM getById(int id) throws ParseException {
        return convertEntityToViewModel(repository.getPatientById(id));
    }

    public void saveChanges(PatientVM viewModel) throws ParseException {
        repository.insertOrUpdatePatient(convertViewModelToEntity(viewModel));
    }
    
    public PatientVM getFromEmergencyRegistration(int id) {
        EmergencyRegistrationVM registration = registrationManager.getById(id);
        PatientVM viewModel = createNew();
        // basic details patient
        viewModel.getBasicDetailsByBasicDetailsId().setFirstName(registration.getPatientFirstName());
        viewModel.getBasicDetailsByBasicDetailsId().setMiddleName(registration.getPatientMiddleName());
        viewModel.getBasicDetailsByBasicDetailsId().setLastName(registration.getPatientLastName());
        viewModel.getBasicDetailsByBasicDetailsId().setTelephone(registration.getPatientContact());
        // basic details patient
        viewModel.getBasicDetailsByNextOfKinId().setFirstName(registration.getRelativeFirstName());
        viewModel.getBasicDetailsByNextOfKinId().setMiddleName(registration.getRelativeMiddleName());
        viewModel.getBasicDetailsByNextOfKinId().setLastName(registration.getRelativeLastName());
        viewModel.getBasicDetailsByNextOfKinId().setTelephone(registration.getRelativeContact());
        // ostalo za patient
        viewModel.getComplaintDetails().setComplaint(registration.getBriefComplaint());
        viewModel.getPatientDetails().setNextOfKinRelationship(registration.getRelationshipOfRelative());
        viewModel.getPersonalDetails().setSex(registration.getPatientSex() == EmergencyRegistrationVM.Sex.F ? PersonalDetailsVM.Sex.F : PersonalDetailsVM.Sex.M);
        // briše emergency registration
        registrationManager.delete(registration);
        return viewModel;
    }

    private PatientVM convertEntityToViewModel(Patient entity) throws ParseException {
        PatientVM viewModel = new PatientVM(entity.getIdpatient());
        viewModel.setPatientDetails(new PatientDetailsVM());
        viewModel.getPatientDetails().setOpid(entity.getOpid());
        viewModel.getPatientDetails().setNextOfKinRelationship(entity.getNextOfKinRelationship());
        viewModel.getPatientDetails().setFullRegistrationDate(entity.getFullRegistrationDate());
        viewModel.setBasicDetailsByBasicDetailsId(basicDetailsManager.convertFromEntityToViewModel(entity.getBasicDetailsByBasicDetailsId()));
        viewModel.setBasicDetailsByNextOfKinId(basicDetailsManager.convertFromEntityToViewModel(entity.getBasicDetailsByNextOfKinId()));
        viewModel.setComplaintDetails(complaintDetailsManager.convertFromEntityToViewModel(entity.getComplaintDetails()));
        viewModel.setLifestyleDetails(lifestyleDetailsManager.convertFromEntityToViewModel(entity.getLifestyleDetails()));
        viewModel.setMedicalDetails(medicalDetailsManager.convertFromEntityToViewModel(entity.getMedicalDetails()));
        viewModel.setPersonalDetails(personalDetailsManager.convertFromEntityToViewModel(entity.getPersonalDetails()));
        return viewModel;
    }

    private Patient convertViewModelToEntity(PatientVM viewModel) throws ParseException {
        Patient entity = new Patient();
        entity.setIdpatient(viewModel.getId());
        entity.setFullRegistrationDate(viewModel.getPatientDetails().getFullRegistrationDate());
        entity.setOpid(viewModel.getPatientDetails().getOpid());
        entity.setNextOfKinRelationship(viewModel.getPatientDetails().getNextOfKinRelationship());
        entity.setBasicDetailsByBasicDetailsId(basicDetailsManager.convertFromViewModelToEntity(viewModel.getBasicDetailsByBasicDetailsId()));
        entity.setBasicDetailsByNextOfKinId(basicDetailsManager.convertFromViewModelToEntity(viewModel.getBasicDetailsByNextOfKinId()));
        entity.setComplaintDetails(complaintDetailsManager.convertFromViewModelToEntity(viewModel.getComplaintDetails()));
        entity.setLifestyleDetails(lifestyleDetailsManager.convertFromViewModelToEntity(viewModel.getLifestyleDetails()));
        entity.setMedicalDetails(medicalDetailsManager.convertFromViewModelToEntity(viewModel.getMedicalDetails()));
        entity.setPersonalDetails(personalDetailsManager.convertFromViewModelToEntity(viewModel.getPersonalDetails()));
        return entity;
    }
    
}
