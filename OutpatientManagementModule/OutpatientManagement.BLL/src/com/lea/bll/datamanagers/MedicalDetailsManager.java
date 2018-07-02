/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.MedicalDetailsVM;
import com.lea.dal.domain.entities.MedicalDetails;

/**
 *
 * @author Lea
 */
public class MedicalDetailsManager extends DataManager {
    
    public MedicalDetailsVM createNew() {
        MedicalDetailsVM viewModel = new MedicalDetailsVM();
        viewModel.setIdmedicalDetails(0);
        return viewModel;
    }
    
    public MedicalDetailsVM convertFromEntityToViewModel(MedicalDetails entity) {
        MedicalDetailsVM viewModel = new MedicalDetailsVM();
        viewModel.setIdmedicalDetails(entity.getIdmedicalDetails());
        viewModel.setAllergiesCondition(entity.getAllergiesCondition());
        viewModel.setCardiacCondition(entity.getCardiacCondition());
        viewModel.setDiabeticCondition(entity.getCardiacCondition());
        viewModel.setDigestiveCondition(entity.getDigestiveCondition());
        viewModel.setHypertensiveCondition(entity.getDigestiveCondition());
        viewModel.setMuscularCondition(entity.getMuscularCondition());
        viewModel.setNeurologicalCondition(entity.getNeurologicalCondition());
        viewModel.setRespiratoryCondition(entity.getRespiratoryCondition());
        return viewModel;
    }
    
}
