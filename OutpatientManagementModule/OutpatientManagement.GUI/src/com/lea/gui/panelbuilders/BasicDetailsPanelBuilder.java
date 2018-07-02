/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.viewmodels.BasicDetailsVM;
import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.OptionFormGroup;
import com.lea.gui.formgroups.TextFormGroup;
import java.util.ArrayList;

/**
 *
 * @author Lea
 */
public class BasicDetailsPanelBuilder extends ViewModelPanelBuilder {

    public BasicDetailsVM viewModel;
    private FormGroup firstName;
    private FormGroup middleName;
    private FormGroup lastName;
    private FormGroup fullStreet;
    private FormGroup city;
    private FormGroup zipCode;
    private FormGroup country;
    private FormGroup telephone;
    private FormGroup mobilePhone;
    private FormGroup email;

    public BasicDetailsPanelBuilder(BasicDetailsVM viewModel) {
        super("Basic Details", 400, 400);
        formGroups = new ArrayList<>();
        this.viewModel = new BasicDetailsVM();
        setModel(viewModel);
    }

    public BasicDetailsPanelBuilder(String title, BasicDetailsVM viewModel) {
        super(title, 400, 400);
        formGroups = new ArrayList<>();
        this.viewModel = new BasicDetailsVM();
        setModel(viewModel);
    }

    @Override
    public void setFormGroups() {
        firstName = new TextFormGroup("First name");
        firstName.setIsMandatory(true);
        formGroups.add(firstName);

        middleName = new TextFormGroup("Middle name");
        formGroups.add(middleName);

        lastName = new TextFormGroup("Last name");
        lastName.setIsMandatory(true);
        formGroups.add(lastName);

        fullStreet = new TextFormGroup("Full street");
        fullStreet.setIsMandatory(true);
        formGroups.add(fullStreet);

        city = new OptionFormGroup("City", viewModel.getAllCities());
        formGroups.add(city);

        zipCode = new TextFormGroup("ZIP code");
        zipCode.setIsMandatory(true);
        formGroups.add(zipCode);

        country = new OptionFormGroup("Country", viewModel.getAllCountries());
        formGroups.add(country);

        telephone = new TextFormGroup("Telephone");
        telephone.setIsMandatory(true);
        formGroups.add(telephone);

        mobilePhone = new TextFormGroup("Mobile phone");
        formGroups.add(mobilePhone);

        email = new TextFormGroup("E-mail");
        formGroups.add(email);

        if (viewModel.getIdbasicDetails() != 0) {
            displayViewModel();
        }

    }

    @Override
    public void setModel(ViewModel viewModel) {
        this.viewModel = (BasicDetailsVM) viewModel;
    }

    @Override
    public ViewModel getModel() {
        if (viewModel != null) {
            loadViewModel();
        }
        return viewModel;
    }

    private void loadViewModel() {
        viewModel.setFirstName((String) firstName.getValue());
        viewModel.setMiddleName((String) middleName.getValue());
        viewModel.setLastName((String) lastName.getValue());
        viewModel.setFullStreet((String) fullStreet.getValue());
        viewModel.setCityName((String) city.getValue());
        viewModel.setPincode((String) zipCode.getValue());
        viewModel.setCountryName((String) country.getValue());
        viewModel.setTelephone((String) telephone.getValue());
        viewModel.setMobilePhone((String) mobilePhone.getValue());
        viewModel.setEmail((String) email.getValue());
    }

    private void displayViewModel() {
        firstName.setValue(viewModel.getFirstName());
        middleName.setValue(viewModel.getMiddleName());
        lastName.setValue(viewModel.getLastName());
    }

}
