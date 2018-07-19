/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.datamanagers.DdlDataManager;
import com.lea.bll.viewmodels.PersonalDetailsVM;
import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.*;
import com.lea.utilities.DateConverter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Lea
 */
public class PersonalDetailsPanelBuilder extends ViewModelPanelBuilder {

    private PersonalDetailsVM viewModel;
    private final DdlDataManager DDL_DATAMANAGER;
    private FormGroup bloodType;
    private FormGroup maritalStatus;
    private FormGroup sex;
    private FormGroup dateOfBirth;
    private FormGroup occupation;
    private FormGroup personHeight;
    private FormGroup personWeight;

    public PersonalDetailsPanelBuilder(ViewModel viewModel) {
        super("Personal details", 400, 250);
        DDL_DATAMANAGER = new DdlDataManager();
        this.viewModel = (PersonalDetailsVM) viewModel;
    }

    @Override
    public void setFormGroups() {
        bloodType = new OptionKeyValueFormGroup("Blood type", DDL_DATAMANAGER.getAllBloodTypes());
        formGroups.add(bloodType);

        maritalStatus = new OptionKeyValueFormGroup("Marital status", DDL_DATAMANAGER.getAllMaritalStatuses());
        formGroups.add(maritalStatus);

        sex = new OptionTextFormGroup("Sex", Arrays.asList(new String[]{"F", "M"}));
        formGroups.add(sex);

        dateOfBirth = new DateFormGroup("Date of birth");
        formGroups.add(dateOfBirth);

        occupation = new TextFormGroup("Occupation");
        formGroups.add(occupation);

        personHeight = new DoubleFormGroup("Height");
        formGroups.add(personHeight);

        personWeight = new DoubleFormGroup("Weight");
        formGroups.add(personWeight);

        if (viewModel.getId() != 0) {
            displayViewModel();
        }
    }

    @Override
    public void setModel(ViewModel viewModel) {
        this.viewModel = (PersonalDetailsVM) viewModel;
    }

    @Override
    public ViewModel getModel() {
        viewModel.setBloodTypeId((int) bloodType.getValue());
        viewModel.setMaritalStatusId((int) maritalStatus.getValue());
        viewModel.setOccupation((String) occupation.getValue());
        viewModel.setSex(((String) sex.getValue()).equals("F") ? PersonalDetailsVM.Sex.F : PersonalDetailsVM.Sex.M);
        try {
            viewModel.setDateOfBirth(DateConverter.getDateFromString((String) dateOfBirth.getValue()));
        } catch (ParseException e) {
            viewModel.setDateOfBirth(new Date());
        }
        try {
            viewModel.setWeight((Double) personWeight.getValue());
            viewModel.setHeight((Double) personHeight.getValue());
        } catch (NumberFormatException e) {
            viewModel.setHeight(170.0);
            viewModel.setWeight(70.0);
        }
        return viewModel;
    }

    private void displayViewModel() {
        bloodType.setValue(viewModel.getBloodTypeId());
        maritalStatus.setValue(viewModel.getMaritalStatusId());
        occupation.setValue(viewModel.getOccupation());
        sex.setValue(viewModel.getSex() == PersonalDetailsVM.Sex.F ? "F" : "M");
        if (viewModel.getDateOfBirth() != null) {
            dateOfBirth.setValue(DateConverter.getStringFromDate(viewModel.getDateOfBirth()));
        } else {
            dateOfBirth.setValue("01/01/1980");
        }
        if (viewModel.getWeight() != null) {
            personWeight.setValue(viewModel.getWeight().toString());
        }
        if (viewModel.getHeight() != null) {
            personHeight.setValue(viewModel.getHeight().toString());
        }
    }

    @Override
    public PanelBuilderType getType() {
        return PanelBuilderType.PERSONALDETAILS;
    }

}
