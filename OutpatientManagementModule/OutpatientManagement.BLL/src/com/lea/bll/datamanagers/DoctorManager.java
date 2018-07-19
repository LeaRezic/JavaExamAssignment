/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.DoctorDetailsVM;
import com.lea.bll.viewmodels.DoctorVM;
import com.lea.dal.domain.entities.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lea
 */
public final class DoctorManager extends DataManager {

    private final BasicDetailsManager basicDetailsManager;

    public DoctorManager() {
        basicDetailsManager = new BasicDetailsManager();
    }

    public DoctorVM getById(int id) {
        return convertEntityToViewModel(repository.getDoctorById(id));
    }

    public DoctorVM createNew() {
        DoctorVM viewModel = new DoctorVM(0);
        viewModel.setBasicDetails(basicDetailsManager.createNew());
        viewModel.setDoctorDetails(new DoctorDetailsVM());
        return viewModel;
    }

    // tu bi trebalo nešto sredit da repo vrati boolean, da se to iskoristi
    public void saveChanges(DoctorVM viewModel) {
        repository.insertOrUpdateDoctor(convertFromViewModelToEntity(viewModel));
    }

    public List<DoctorVM> getAll() {
        List<DoctorVM> doctors = new ArrayList<>();
        repository.getAllDoctors().forEach((entity) -> {
            doctors.add(convertEntityToViewModel(entity));
        });
        return doctors;
    }

    protected DoctorVM convertEntityToViewModel(Doctor entity) {
        DoctorVM viewModel = new DoctorVM(entity.getIddoctor());
        viewModel.setDoctorDetails(new DoctorDetailsVM());
        viewModel.getDoctorDetails().setTitle(entity.getTitle());
        viewModel.getDoctorDetails().setProfession(entity.getDoctorSpecialization().getIddoctorSpecialization());
        viewModel.getDoctorDetails().setActive(entity.isActive());
        viewModel.setBasicDetails(basicDetailsManager.convertFromEntityToViewModel(entity.getBasicDetails()));
        return viewModel;
    }

    public Doctor convertFromViewModelToEntity(DoctorVM viewModel) {
        Doctor entity = new Doctor();
        entity.setIddoctor(viewModel.getId());
        entity.setBasicDetails(basicDetailsManager.convertFromViewModelToEntity(viewModel.getBasicDetails()));
        entity.setActive(viewModel.getDoctorDetails().isActive());
        entity.setTitle(viewModel.getDoctorDetails().getTitle());
        entity.setDoctorSpecialization(repository.getDoctorSpecializationById(viewModel.getDoctorDetails().getProfession()));
        return entity;
    }

}
