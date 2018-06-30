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
        super("Basic Details", 400, 200);
        formGroups = new ArrayList<>();
        basicDetails = new BasicDetailsVM();
    }
    
    public BasicDetailsGuiBuilder(String title) {
        super(title, 400, 200);
        formGroups = new ArrayList<>();
        basicDetails = new BasicDetailsVM();
    }

    @Override
    public void setFormGroups() {
        FormGroup firstName = new TextFormGroup("First Name", true);
        formGroups.add(firstName);
        FormGroup middleName = new TextFormGroup("Middle Name", false);
        formGroups.add(middleName);
        FormGroup lastName = new TextFormGroup("Last Name", true);
        formGroups.add(lastName);
        String[] options = {"F","M"};
        FormGroup sex = new OptionFormGroup("Sex", true, Arrays.asList(options));
        formGroups.add(sex);
        String[] maritalStatus = {"Married","Single","Widowed"};
        FormGroup married = new OptionFormGroup("Marital Status", true, Arrays.asList(maritalStatus));
        formGroups.add(married);
        FormGroup drinksPerDay = new NumberFormGroup("Drinks per day", true, 100);
        formGroups.add(drinksPerDay);
    }

    @Override
    public void setModel(ViewModel viewModel) {
        basicDetails = viewModel;
    }

    @Override
    public ViewModel getModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
