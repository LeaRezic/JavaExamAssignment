/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.forms;

import com.lea.bll.datamanagers.EmergencyRegistrationManager;
import com.lea.bll.viewmodels.EmergencyRegistrationVM;
import com.lea.gui.panelbuilders.PanelBuilderFactory;
import com.lea.gui.panelbuilders.PanelBuilderType;

/**
 *
 * @author Lea
 */
public class EmergencyRegistrationForm extends ViewModelForm {

    public EmergencyRegistrationForm(EmergencyRegistrationVM registration, boolean editable) {
        super("Short patient registration", registration, editable);
    }

    @Override
    public void fillPanelBuilderList() {
        EmergencyRegistrationVM registration = (EmergencyRegistrationVM) viewModel;
        panelBuilders.add(PanelBuilderFactory.getInstance(PanelBuilderType.EMERGENCY_REGISTRATION, registration));
    }

    @Override
    public void updateViewModel() {
        viewModel = (EmergencyRegistrationVM) getModelFromPanel(PanelBuilderType.EMERGENCY_REGISTRATION);
    }

    @Override
    public void saveChanges() {
        new EmergencyRegistrationManager().saveChanges((EmergencyRegistrationVM) viewModel);
    }

    @Override
    public ViewModelFormType getFormType() {
        return ViewModelFormType.REGISTRATION_EMERGENCY;
    }

}
