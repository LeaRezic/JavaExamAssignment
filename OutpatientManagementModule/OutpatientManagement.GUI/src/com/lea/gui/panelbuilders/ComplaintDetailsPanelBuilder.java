/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.viewmodels.ComplaintDetailsVM;
import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.TextFormGroup;

/**
 *
 * @author Lea
 */
public class ComplaintDetailsPanelBuilder extends ViewModelPanelBuilder {

    private ComplaintDetailsVM viewModel;
    private FormGroup complaint;
    private FormGroup treatmentHistory;
    private FormGroup treatedAtHospital;

    public ComplaintDetailsPanelBuilder() {
        super("Complaint details", 400, 200);
    }

    @Override
    public void setFormGroups() {

        complaint = new TextFormGroup("Complaint");
        complaint.setIsMandatory(true);
        formGroups.add(complaint);

        treatmentHistory = new TextFormGroup("Treatment History");
        formGroups.add(treatmentHistory);

        treatedAtHospital = new TextFormGroup("Treated at hospital");
        formGroups.add(treatedAtHospital);

    }

    @Override
    public void setModel(ViewModel viewModel) {
        this.viewModel = (ComplaintDetailsVM) viewModel;
    }

    @Override
    public ViewModel getModel() {
        if (viewModel != null) {
            loadModelData();
        }
        return viewModel;
    }

    private void loadModelData() {
        viewModel.setComplaint((String) complaint.getValue());
        viewModel.setTreatmentHistory((String) treatmentHistory.getValue());
        viewModel.setTreatedAtHospital((String) treatedAtHospital.getValue());
    }

}
