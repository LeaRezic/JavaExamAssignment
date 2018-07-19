/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.viewmodels.PatientDetailsVM;
import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.DateFormGroup;
import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.OpidFormGroup;
import com.lea.gui.formgroups.TextFormGroup;
import com.lea.utilities.DateConverter;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Lea
 */
public class PatientDetailsPanelBuilder extends ViewModelPanelBuilder {

    private PatientDetailsVM viewModel;
    private FormGroup opid;
    private FormGroup fullRegistrationDate;
    private FormGroup nextOfKinRelationship;

    public PatientDetailsPanelBuilder(ViewModel viewModel) {
        super("Registration details", 400, 120);
        this.viewModel = (PatientDetailsVM) viewModel;
    }

    @Override
    public void setFormGroups() {
        opid = new OpidFormGroup("OPID");
        opid.setIsMandatory(true);
        formGroups.add(opid);

        fullRegistrationDate = new DateFormGroup("Registration date");
        formGroups.add(fullRegistrationDate);

        nextOfKinRelationship = new TextFormGroup("Next of kin relation");
        nextOfKinRelationship.setIsMandatory(true);
        formGroups.add(nextOfKinRelationship);

        displayViewModel();
    }

    @Override
    public void setModel(ViewModel viewModel) {
        this.viewModel = (PatientDetailsVM) viewModel;
    }

    @Override
    public ViewModel getModel() {
        viewModel.setOpid((String) opid.getValue());
        try {
            Date date = DateConverter.getDateFromString((String) fullRegistrationDate.getValue());
            viewModel.setFullRegistrationDate(date);
        } catch (ParseException e) {
            viewModel.setFullRegistrationDate(new Date());
        }
        viewModel.setNextOfKinRelationship((String) nextOfKinRelationship.getValue());
        return viewModel;
    }

    private void displayViewModel() {
        opid.setValue(viewModel.getOpid());
        if (viewModel.getFullRegistrationDate() == null) {
            fullRegistrationDate.setValue(DateConverter.getStringFromDate(new Date()));
        } else {
            fullRegistrationDate.setValue(DateConverter.getStringFromDate(viewModel.getFullRegistrationDate()));
        }
        nextOfKinRelationship.setValue(viewModel.getNextOfKinRelationship());
    }

    @Override
    public PanelBuilderType getType() {
        return PanelBuilderType.PATIENTDETAILS;
    }

}
