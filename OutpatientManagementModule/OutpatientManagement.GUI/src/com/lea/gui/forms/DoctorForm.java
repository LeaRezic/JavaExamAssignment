/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.forms;

import com.lea.bll.datamanagers.DoctorManager;
import com.lea.bll.viewmodels.BasicDetailsVM;
import com.lea.bll.viewmodels.DoctorDetailsVM;
import com.lea.bll.viewmodels.DoctorVM;
import com.lea.gui.panelbuilders.PanelBuilderFactory;
import com.lea.gui.panelbuilders.PanelBuilderType;

/**
 *
 * @author Lea
 */
public class DoctorForm extends ViewModelForm {

    public DoctorForm(DoctorVM doctor, boolean editable) {
        super("Doctor form", doctor, editable);
    }

    @Override
    public void fillPanelBuilderList() {
        DoctorVM doctor = (DoctorVM) viewModel;
        panelBuilders.add(PanelBuilderFactory.getInstance(PanelBuilderType.BASICDETAILS_DOCTOR, doctor.getBasicDetails()));
        panelBuilders.add(PanelBuilderFactory.getInstance(PanelBuilderType.DOCTORDETAILS, doctor.getDoctorDetails()));
    }

    @Override
    public void updateViewModel() {
        DoctorVM doctor = (DoctorVM) viewModel;
        doctor.setBasicDetails((BasicDetailsVM) getModelFromPanel(PanelBuilderType.BASICDETAILS_DOCTOR));
        doctor.setDoctorDetails((DoctorDetailsVM) getModelFromPanel(PanelBuilderType.DOCTORDETAILS));
    }

    @Override
    public void saveChanges() {
        new DoctorManager().saveChanges((DoctorVM) viewModel);
    }

    @Override
    public ViewModelFormType getFormType() {
        return ViewModelFormType.DOCTOR;
    }

}
