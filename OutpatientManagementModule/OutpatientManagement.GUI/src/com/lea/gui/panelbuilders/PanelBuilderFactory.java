/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.viewmodels.ViewModel;

/**
 *
 * @author Lea
 */
public class PanelBuilderFactory {

    private PanelBuilderFactory() {
    }

    public static ViewModelPanelBuilder getInstance(PanelBuilderType type, ViewModel viewModel) {
        switch (type) {
            case BASICDETAILS_PATIENT:
                return new PatientBasicDetailsPanelBuilder(viewModel);
            case BASICDETAILS_DOCTOR:
                return new DoctorBasicDetailsPanelBuilder(viewModel);
            case BASICDETAILS_NEXTOFKIN:
                return new NextOfKinBasicDetailsPanelBuilder(viewModel);
            case COMPLAINTDETAILS:
                return new ComplaintDetailsPanelBuilder(viewModel);
            case DOCTORDETAILS:
                return new DoctorDetailsPanelBuilder(viewModel);
            case LIFESTYLEDETAILS:
                return new LifestyleDetailsPanelBuilder(viewModel);
            case MEDICALDETAILS:
                return new MedicalDetailsPanelBuilder(viewModel);
            case PATIENTDETAILS:
                return new PatientDetailsPanelBuilder(viewModel);
            case PERSONALDETAILS:
                return new PersonalDetailsPanelBuilder(viewModel);
            case EMERGENCY_REGISTRATION:
                return new EmergencyRegistrationPanelBuilder(viewModel);
            default:
                return null;
        }
    }

}
