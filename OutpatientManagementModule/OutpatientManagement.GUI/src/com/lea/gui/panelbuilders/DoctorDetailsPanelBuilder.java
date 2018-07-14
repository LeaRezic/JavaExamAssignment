/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.datamanagers.DdlDataManager;
import com.lea.bll.viewmodels.DoctorDetailsVM;
import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.OptionTextFormGroup;
import com.lea.gui.formgroups.OptionKeyValueFormGroup;
import com.lea.gui.formgroups.TextFormGroup;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Lea
 */
public class DoctorDetailsPanelBuilder extends ViewModelPanelBuilder {

    private DoctorDetailsVM viewModel;
    private FormGroup doctorTitle;
    private FormGroup profession;
    private FormGroup active;
    private static final DdlDataManager DDL_MANAGER = new DdlDataManager();

    public DoctorDetailsPanelBuilder(DoctorDetailsVM viewModel) {
        super("Employment details", 400, 120);
        formGroups = new ArrayList<>();
        this.viewModel = viewModel;
    }

    @Override
    public void setFormGroups() {

        doctorTitle = new TextFormGroup("Title");
        doctorTitle.setIsMandatory(true);
        formGroups.add(doctorTitle);

        profession = new OptionKeyValueFormGroup("Specialization", DDL_MANAGER.getAllProfessions());
        formGroups.add(profession);

        active = new OptionTextFormGroup("Actively employed", Arrays.asList(new String[]{"YES", "NO"}));
        formGroups.add(active);

        displayViewModel();
        
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
        viewModel.setProfession((int) profession.getValue());
    }

    private void displayViewModel() {
        doctorTitle.setValue(viewModel.getTitle());
        profession.setValue(viewModel.getProfession());
        active.setValue(viewModel.isActive() ? "YES" : "NO");
    }

}
