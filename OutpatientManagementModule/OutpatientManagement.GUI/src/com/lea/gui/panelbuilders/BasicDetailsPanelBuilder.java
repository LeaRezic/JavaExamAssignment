/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.datamanagers.DdlDataManager;
import com.lea.bll.viewmodels.BasicDetailsVM;
import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.OptionTextFormGroup;
import com.lea.gui.formgroups.OptionKeyValueFormGroup;
import com.lea.gui.formgroups.TextFormGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Lea
 */
public class BasicDetailsPanelBuilder extends ViewModelPanelBuilder {

    public BasicDetailsVM viewModel;
    public DdlDataManager ddlManager;
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
        ddlManager = new DdlDataManager();
        setModel(viewModel);
    }

    public BasicDetailsPanelBuilder(String title, BasicDetailsVM viewModel) {
        super(title, 400, 400);
        formGroups = new ArrayList<>();
        ddlManager = new DdlDataManager();
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

//        city = new OptionFormGroup("City", viewModel.getAllCities());
//        formGroups.add(city);
        
        
        country = new OptionKeyValueFormGroup("Country", ddlManager.getAllCountries());
        country.setValue(1);
        formGroups.add(country);
        
        city = new OptionKeyValueFormGroup("City", ddlManager.getAllCitiesByCountry(1));
        formGroups.add(city);
        
        wireDdlActions();

        zipCode = new TextFormGroup("ZIP code");
        zipCode.setIsMandatory(true);
        formGroups.add(zipCode);

//        country = new OptionFormGroup("Country", viewModel.getAllCountries());
//        formGroups.add(country);

        telephone = new TextFormGroup("Telephone");
        telephone.setIsMandatory(true);
        formGroups.add(telephone);

        mobilePhone = new TextFormGroup("Mobile phone");
        formGroups.add(mobilePhone);

        email = new TextFormGroup("E-mail");
        formGroups.add(email);

        if (viewModel.getId() != 0) {
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
        viewModel.setCityId((int) city.getValue());
        viewModel.setPincode((String) zipCode.getValue());
        viewModel.setCountryId((int) country.getValue());
        viewModel.setTelephone((String) telephone.getValue());
        viewModel.setMobilePhone((String) mobilePhone.getValue());
        viewModel.setEmail((String) email.getValue());
    }

    private void displayViewModel() {
        firstName.setValue(viewModel.getFirstName());
        middleName.setValue(viewModel.getMiddleName());
        lastName.setValue(viewModel.getLastName());
        fullStreet.setValue(viewModel.getFullStreet());
        zipCode.setValue(viewModel.getPincode());
        telephone.setValue(viewModel.getTelephone());
        mobilePhone.setValue(viewModel.getMobilePhone());
        email.setValue(viewModel.getEmail());
        country.setValue(viewModel.getCountryId());
        city.setValue(viewModel.getCityId());
    }

    private void wireDdlActions() {
        JComboBox ddlCountries = (JComboBox) country.getComponent();
        if (ddlCountries.getModel().getSize() != 0) {
            ddlCountries.setSelectedIndex(0);
        }
        ddlCountries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedCountryId = (int)country.getValue();
                ((OptionKeyValueFormGroup) city).resetOptions(ddlManager.getAllCitiesByCountry(selectedCountryId));
            }
        } );
    }

}
