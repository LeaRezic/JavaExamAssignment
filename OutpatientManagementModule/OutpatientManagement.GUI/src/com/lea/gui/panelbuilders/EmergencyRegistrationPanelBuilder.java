/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.viewmodels.EmergencyRegistrationVM;
import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.OptionTextFormGroup;
import com.lea.gui.formgroups.PhoneFormGroup;
import com.lea.gui.formgroups.TextFormGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Lea
 */
public class EmergencyRegistrationPanelBuilder extends ViewModelPanelBuilder {

    private EmergencyRegistrationVM viewModel;
    private FormGroup firstName;
    private FormGroup middleName;
    private FormGroup lastName;
    private FormGroup nextOfKinRelationship;
    private FormGroup firstNameRelative;
    private FormGroup middleNameRelative;
    private FormGroup lastNameRelative;
    private FormGroup sex;
    private FormGroup complaint;
    private FormGroup patientContact;
    private FormGroup relativeContact;

    public EmergencyRegistrationPanelBuilder(ViewModel viewModel) {
        super("Emergency registration", 400, 360);
        formGroups = new ArrayList<>();
        this.viewModel = (EmergencyRegistrationVM) viewModel;
    }

    @Override
    public void setFormGroups() {
        firstName = new TextFormGroup("Patient first name");
        firstName.setIsMandatory(true);
        formGroups.add(firstName);

        middleName = new TextFormGroup("Patient middle name");
        formGroups.add(middleName);

        lastName = new TextFormGroup("Patient last name");
        lastName.setIsMandatory(true);
        formGroups.add(lastName);

        nextOfKinRelationship = new TextFormGroup("Next of kin relation");
        nextOfKinRelationship.setIsMandatory(true);
        formGroups.add(nextOfKinRelationship);

        firstNameRelative = new TextFormGroup("Relative first name");
        firstNameRelative.setIsMandatory(true);
        formGroups.add(firstNameRelative);

        middleNameRelative = new TextFormGroup("Relative middle name");
        formGroups.add(middleNameRelative);

        lastNameRelative = new TextFormGroup("Relative last name");
        lastNameRelative.setIsMandatory(true);
        formGroups.add(lastNameRelative);

        sex = new OptionTextFormGroup("Patient sex", Arrays.asList(new String[]{"F", "M"}));
        formGroups.add(sex);

        complaint = new TextFormGroup("Brief compalint");
        complaint.setIsMandatory(true);
        formGroups.add(complaint);
        
        patientContact = new PhoneFormGroup("Patient contact");
        patientContact.setIsMandatory(true);
        formGroups.add(patientContact);

        relativeContact = new PhoneFormGroup("Relative contact");
        relativeContact.setIsMandatory(true);
        formGroups.add(relativeContact);

    }

    @Override
    public void setModel(ViewModel viewModel) {
        this.viewModel = (EmergencyRegistrationVM) viewModel;
    }

    @Override
    public ViewModel getModel() {
        viewModel.setPatientFirstName((String) firstName.getValue());
        viewModel.setPatientMiddleName((String) middleName.getValue());
        viewModel.setPatientLastName((String) lastName.getValue());
        viewModel.setRelationshipOfRelative((String) nextOfKinRelationship.getValue());
        viewModel.setRelativeFirstName((String) firstNameRelative.getValue());
        viewModel.setRelativeMiddleName((String) middleNameRelative.getValue());
        viewModel.setRelativeLastName((String) lastNameRelative.getValue());
        viewModel.setPatientContact((String) patientContact.getValue());
        viewModel.setRelativeContact((String) relativeContact.getValue());
        viewModel.setRegistryDate(new Date());
        viewModel.setBriefComplaint((String) complaint.getValue());
        viewModel.setPatientSex(((String) sex.getValue()).equals("F") ? EmergencyRegistrationVM.Sex.F : EmergencyRegistrationVM.Sex.M);
        return viewModel;
    }

    @Override
    public PanelBuilderType getType() {
        return PanelBuilderType.EMERGENCY_REGISTRATION;
    }

}
