/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.BasicDetailsVM;
import com.lea.bll.viewmodels.DoctorVM;
import com.lea.dal.domain.entities.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lea
 */
public final class DoctorManager extends DataManager {

    public DoctorManager() {
    }

    public List<DoctorVM> getAll() {
        List<DoctorVM> doctors = new ArrayList<>();
        for (Doctor entity : repository.getAllDoctors()) {
            doctors.add(convertEntityToViewModel(entity));
        }
        return doctors;
    }

    protected DoctorVM convertEntityToViewModel(Doctor entity) {
        DoctorVM viewModel = new DoctorVM();
        viewModel.setIddoctor(entity.getIddoctor());
        viewModel.setTitle(entity.getTitle());
        viewModel.setActive(entity.isActive());

        BasicDetailsVM basicDetails = new BasicDetailsVM();
        basicDetails.setFirstName(entity.getBasicDetails().getFirstName());
        basicDetails.setLastName(entity.getBasicDetails().getLastName());
        
        viewModel.setBasicDetails(basicDetails);
        return viewModel;

    }

}
