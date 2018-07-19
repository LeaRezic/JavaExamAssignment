/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.viewmodels.MedicalDetailsVM;
import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.TextFormGroup;

/**
 *
 * @author Lea
 */
public class MedicalDetailsPanelBuilder extends ViewModelPanelBuilder {

    private MedicalDetailsVM viewModel;
    private FormGroup allergiesCondition;
    private FormGroup diabeticCondition;
    private FormGroup hypertensiveCondition;
    private FormGroup cardiacCondition;
    private FormGroup respiratoryCondition;
    private FormGroup digestiveCondition;
    private FormGroup muscularCondition;
    private FormGroup neurologicalCondition;

    public MedicalDetailsPanelBuilder(ViewModel viewModel) {
        super("Medical Condition", 400, 300);
        this.viewModel = (MedicalDetailsVM) viewModel;
    }

    @Override
    public void setFormGroups() {
        allergiesCondition = new TextFormGroup("Allergies");
        formGroups.add(allergiesCondition);

        diabeticCondition = new TextFormGroup("Diabetic");
        formGroups.add(diabeticCondition);

        hypertensiveCondition = new TextFormGroup("Hypertension");
        formGroups.add(hypertensiveCondition);

        cardiacCondition = new TextFormGroup("Cardiac");
        formGroups.add(cardiacCondition);

        respiratoryCondition = new TextFormGroup("Respiratory");
        formGroups.add(respiratoryCondition);

        digestiveCondition = new TextFormGroup("Digestive");
        formGroups.add(digestiveCondition);

        muscularCondition = new TextFormGroup("Muscular");
        formGroups.add(muscularCondition);

        neurologicalCondition = new TextFormGroup("Neurological");
        formGroups.add(neurologicalCondition);

        if (viewModel.getId() != 0) {
            displayViewModel();
        }
    }

    @Override
    public void setModel(ViewModel viewModel) {
        this.viewModel = (MedicalDetailsVM) viewModel;
    }

    @Override
    public ViewModel getModel() {
        viewModel.setAllergiesCondition((String) allergiesCondition.getValue());
        viewModel.setCardiacCondition((String) cardiacCondition.getValue());
        viewModel.setDiabeticCondition((String) diabeticCondition.getValue());
        viewModel.setDigestiveCondition((String) digestiveCondition.getValue());
        viewModel.setHypertensiveCondition((String) hypertensiveCondition.getValue());
        viewModel.setMuscularCondition((String) muscularCondition.getValue());
        viewModel.setNeurologicalCondition((String) neurologicalCondition.getValue());
        viewModel.setRespiratoryCondition((String) respiratoryCondition.getValue());
        return viewModel;
    }

    private void displayViewModel() {
        allergiesCondition.setValue(viewModel.getAllergiesCondition());
        cardiacCondition.setValue(viewModel.getCardiacCondition());
        diabeticCondition.setValue(viewModel.getDiabeticCondition());
        digestiveCondition.setValue(viewModel.getDigestiveCondition());
        hypertensiveCondition.setValue(viewModel.getHypertensiveCondition());
        muscularCondition.setValue(viewModel.getMuscularCondition());
        neurologicalCondition.setValue(viewModel.getNeurologicalCondition());
        respiratoryCondition.setValue(viewModel.getRespiratoryCondition());
    }

    @Override
    public PanelBuilderType getType() {
        return PanelBuilderType.MEDICALDETAILS;
    }

}
