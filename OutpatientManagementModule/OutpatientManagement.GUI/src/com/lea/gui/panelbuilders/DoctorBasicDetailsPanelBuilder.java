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
public class DoctorBasicDetailsPanelBuilder extends BasicDetailsPanelBuilder {

    public DoctorBasicDetailsPanelBuilder(ViewModel viewModel) {
        super("Basic details", viewModel);
    }

    @Override
    public PanelBuilderType getType() {
        return PanelBuilderType.BASICDETAILS_DOCTOR;
    }
    
}
