/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.PatientVM;

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

    public PatientManager() {
        this.lifestyleDetailsManager = new LifestyleDetailsManager();
        this.complaintDetailsManager = new ComplaintDetailsManager();
        this.medicalDetailsManager = new MedicalDetailsManager();
        this.personalDetailsManager = new PersonalDetailsManager();
        this.basicDetailsManager = new BasicDetailsManager();
    }
    
    public PatientVM createNew() {
        PatientVM viewModel = new PatientVM();
        viewModel.setIdpatient(0);
        viewModel.setBasicDetailsByBasicDetailsId(basicDetailsManager.createNew());
        viewModel.setBasicDetailsByNextOfKinId(basicDetailsManager.createNew());
        viewModel.setComplaintDetails(complaintDetailsManager.createNew());
        viewModel.setPersonalDetails(personalDetailsManager.createNew());
        viewModel.setMedicalDetails(medicalDetailsManager.createNew());
        viewModel.setLifestyleDetails(lifestyleDetailsManager.createNew());
        return viewModel;
    }
    
    
    
    
}
