/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.ComplaintDetailsVM;
import com.lea.dal.domain.entities.ComplaintDetails;

/**
 *
 * @author Lea
 */
public class ComplaintDetailsManager extends DataManager {
    
    public ComplaintDetailsVM createNew() {
        ComplaintDetailsVM viewModel = new ComplaintDetailsVM();
        viewModel.setIdcomplaintDetails(0);
        return viewModel;
    }
    
    public void saveChanges(ComplaintDetailsVM viewModel) {
        repository.insertOrUpdateComplaintDetails(convertFromViewModelToEntity(viewModel));
    }
    
    private ComplaintDetails convertFromViewModelToEntity(ComplaintDetailsVM viewModel) {
        ComplaintDetails entity = new ComplaintDetails();
        entity.setIdcomplaintDetails(viewModel.getIdcomplaintDetails());
        entity.setComplaint(viewModel.getComplaint());
        entity.setTreatmentHistory(viewModel.getTreatmentHistory());
        entity.setTreatedAtHospital(viewModel.getTreatedAtHospital());
        return entity;
    }
    
}
