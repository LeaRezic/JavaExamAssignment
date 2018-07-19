/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.forms;

import com.lea.bll.datamanagers.PatientManager;
import com.lea.bll.viewmodels.*;
import com.lea.gui.panelbuilders.PanelBuilderFactory;
import com.lea.gui.panelbuilders.PanelBuilderType;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lea
 */
public class FullRegistrationForm extends ViewModelForm {

    public FullRegistrationForm(PatientVM patient, boolean editable) {
        super("Full registration form", patient, editable);
    }

    @Override
    public void fillPanelBuilderList() {
        PatientVM patient = (PatientVM) viewModel;
        panelBuilders.add(PanelBuilderFactory.getInstance(PanelBuilderType.PATIENTDETAILS, patient.getPatientDetails()));
        panelBuilders.add(PanelBuilderFactory.getInstance(PanelBuilderType.BASICDETAILS_PATIENT, patient.getBasicDetailsByBasicDetailsId()));
        panelBuilders.add(PanelBuilderFactory.getInstance(PanelBuilderType.BASICDETAILS_NEXTOFKIN, patient.getBasicDetailsByNextOfKinId()));
        panelBuilders.add(PanelBuilderFactory.getInstance(PanelBuilderType.PERSONALDETAILS, patient.getPersonalDetails()));
        panelBuilders.add(PanelBuilderFactory.getInstance(PanelBuilderType.COMPLAINTDETAILS, patient.getComplaintDetails()));
        panelBuilders.add(PanelBuilderFactory.getInstance(PanelBuilderType.MEDICALDETAILS, patient.getMedicalDetails()));
        panelBuilders.add(PanelBuilderFactory.getInstance(PanelBuilderType.LIFESTYLEDETAILS, patient.getLifestyleDetails()));
    }

    @Override
    public void updateViewModel() {
        PatientVM patient = (PatientVM) viewModel;
        patient.setPatientDetails((PatientDetailsVM) getModelFromPanel(PanelBuilderType.PATIENTDETAILS));
        patient.setBasicDetailsByBasicDetailsId((BasicDetailsVM) getModelFromPanel(PanelBuilderType.BASICDETAILS_PATIENT));
        patient.setBasicDetailsByNextOfKinId((BasicDetailsVM) getModelFromPanel(PanelBuilderType.BASICDETAILS_NEXTOFKIN));
        patient.setPersonalDetails((PersonalDetailsVM) getModelFromPanel(PanelBuilderType.PERSONALDETAILS));
        patient.setComplaintDetails((ComplaintDetailsVM) getModelFromPanel(PanelBuilderType.COMPLAINTDETAILS));
        patient.setMedicalDetails((MedicalDetailsVM) getModelFromPanel(PanelBuilderType.MEDICALDETAILS));
        patient.setLifestyleDetails((LifestyleDetailsVM) getModelFromPanel(PanelBuilderType.LIFESTYLEDETAILS));
        viewModel = patient;
    }

    @Override
    public void saveChanges() {
        try {
            new PatientManager().saveChanges((PatientVM) viewModel);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR);
        }
    }

    @Override
    public ViewModelFormType getFormType() {
        return ViewModelFormType.REGISTRATION_FULL;
    }

}
