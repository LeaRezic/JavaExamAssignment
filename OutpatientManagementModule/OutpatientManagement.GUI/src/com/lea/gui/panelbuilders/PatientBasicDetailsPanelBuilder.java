/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.viewmodels.ViewModel;

/**
 *
 * @author Lea
 */
public class PatientBasicDetailsPanelBuilder extends BasicDetailsPanelBuilder {

    public PatientBasicDetailsPanelBuilder(ViewModel viewModel) {
        super("Patient - basic details", viewModel);
    }

    @Override
    public PanelBuilderType getType() {
        return PanelBuilderType.BASICDETAILS_PATIENT;
    }
    
}
