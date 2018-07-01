/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formbuilders;

import com.lea.bll.viewmodels.BasicDetailsVM;
import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.NumberFormGroup;
import com.lea.gui.formgroups.OptionFormGroup;
import com.lea.gui.formgroups.TextFormGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Lea
 */
public class BasicDetailsGuiBuilder extends ViewModelGuiBuilder {
    
    public ViewModel basicDetails;
    
    public BasicDetailsGuiBuilder() {
        super("Basic Details", 400, 400);
        formGroups = new ArrayList<>();
        basicDetails = new BasicDetailsVM();
    }
    
    public BasicDetailsGuiBuilder(String title) {
        super(title, 400, 400);
        formGroups = new ArrayList<>();
        basicDetails = new BasicDetailsVM();
    }

    @Override
    public void setFormGroups() {
        FormGroup firstName = new TextFormGroup("First name");
        firstName.setIsMandatory(true);
        formGroups.add(firstName);
        
        FormGroup middleName = new TextFormGroup("Middle name");
        formGroups.add(middleName);
        
        FormGroup lastName = new TextFormGroup("Last name");
        lastName.setIsMandatory(true);
        formGroups.add(lastName);
        
        FormGroup fullStreet = new TextFormGroup("Full street");
        fullStreet.setIsMandatory(true);
        formGroups.add(fullStreet);
        
        FormGroup city = new TextFormGroup("City");
        city.setIsMandatory(true);
        formGroups.add(city);
        
        FormGroup zipCode = new TextFormGroup("ZIP code");
        zipCode.setIsMandatory(true);
        formGroups.add(zipCode);
        
        FormGroup country = new TextFormGroup("Country");
        country.setIsMandatory(true);
        formGroups.add(country);
        
        FormGroup telephone = new TextFormGroup("Telephone");
        telephone.setIsMandatory(true);
        formGroups.add(telephone);
        
        FormGroup mobilePhone = new TextFormGroup("Mobile phone");
        formGroups.add(mobilePhone);
        
        FormGroup email = new TextFormGroup("E-mail");
        formGroups.add(email);
        
//        String[] options = {"F","M"};
//        FormGroup sex = new OptionFormGroup("Sex", Arrays.asList(options));
//        formGroups.add(sex);
//        
//        String[] maritalStatus = {"Married","Single","Widowed"};
//        FormGroup married = new OptionFormGroup("Marital Status", Arrays.asList(maritalStatus));
//        formGroups.add(married);
//        
//        FormGroup drinksPerDay = new NumberFormGroup("Drinks per day", 100);
//        formGroups.add(drinksPerDay);
    }

    @Override
    public void setModel(ViewModel viewModel) {
        basicDetails = (BasicDetailsVM) viewModel;
    }

    @Override
    public ViewModel getModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
