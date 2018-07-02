/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.viewmodels.DoctorDetailsVM;
import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.OptionFormGroup;
import com.lea.gui.formgroups.TextFormGroup;
import java.util.Arrays;
import javax.swing.JTextField;

/**
 *
 * @author Lea
 */
public class DoctorDetailsPanelBuilder extends ViewModelPanelBuilder {

    private DoctorDetailsVM viewModel;
    private TextFormGroup doctorTitle;
    private OptionFormGroup profession;
    private OptionFormGroup active;

//    public DoctorDetailsPanelBuilder() {
//        super("Employment details", 400, 120);
//        viewModel = new DoctorDetailsVM();
//    }

    public DoctorDetailsPanelBuilder(DoctorDetailsVM viewModel) {
        super("Employment details", 400, 120);
        setModel(viewModel);
        //setFormGroups();
        
    }
    
    @Override
    public void setFormGroups() {

        doctorTitle = new TextFormGroup("Title");
        doctorTitle.setIsMandatory(true);
        if (viewModel.getTitle() != null) {
            doctorTitle.setValue(viewModel.getTitle());
        }
        formGroups.add(doctorTitle);
        
        profession = new OptionFormGroup("Specialization", viewModel.getAllSpecializations());
        if (viewModel.getProfession() != null) {
            profession.setValue(viewModel.getProfession());
        }
        formGroups.add(profession);
        
        active = new OptionFormGroup("Actively employed", Arrays.asList(new String[]{"YES", "NO"}));
        active.setValue(viewModel.isActive() ? "YES" : "NO");
        formGroups.add(active);

    }

    @Override
    public void setModel(ViewModel viewModel) {
        this.viewModel = (DoctorDetailsVM) viewModel;
        
    }

    @Override
    public ViewModel getModel() {
        if (viewModel != null) {
            loadViewModel();
        }
        return viewModel;
    }

    private void loadViewModel() {
        viewModel.setTitle((String) doctorTitle.getValue());
        viewModel.setActive(((String) active.getValue()).equals("YES"));
        viewModel.setProfession((String) profession.getValue());
    }

    private void displayViewModel() {
        //((JTextField) doctorTitle.getComponent()).setText("blaaaa");
        
    }

}
