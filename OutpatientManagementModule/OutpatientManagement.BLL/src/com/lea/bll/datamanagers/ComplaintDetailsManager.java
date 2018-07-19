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
        ComplaintDetailsVM viewModel = new ComplaintDetailsVM(0);
        return viewModel;
    }
    
    public ComplaintDetailsVM createNew(boolean emergency) {
        int id = emergency ? -1 : 0;
        ComplaintDetailsVM viewModel = new ComplaintDetailsVM(id);
        return viewModel;
    }
    
    ComplaintDetails convertFromViewModelToEntity(ComplaintDetailsVM viewModel) {
        ComplaintDetails entity = new ComplaintDetails();
        int id = viewModel.getId() == -1 ? 0 : viewModel.getId();
        entity.setIdcomplaintDetails(id);
        entity.setComplaint(viewModel.getComplaint());
        entity.setTreatmentHistory(viewModel.getTreatmentHistory());
        entity.setTreatedAtHospital(viewModel.getTreatedAtHospital());
        return entity;
    }

    ComplaintDetailsVM convertFromEntityToViewModel(ComplaintDetails entity) {
        ComplaintDetailsVM viewModel = new ComplaintDetailsVM(entity.getIdcomplaintDetails());
        viewModel.setComplaint(entity.getComplaint());
        viewModel.setTreatedAtHospital(entity.getTreatedAtHospital());
        viewModel.setTreatmentHistory(entity.getTreatmentHistory());
        return viewModel;
    }
    
}
