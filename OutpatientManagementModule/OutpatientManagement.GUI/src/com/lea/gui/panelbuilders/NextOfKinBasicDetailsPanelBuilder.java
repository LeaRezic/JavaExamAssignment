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
public class NextOfKinBasicDetailsPanelBuilder extends BasicDetailsPanelBuilder {

    public NextOfKinBasicDetailsPanelBuilder(ViewModel viewModel) {
        super("Next of kin", viewModel);
    }

    @Override
    public PanelBuilderType getType() {
        return PanelBuilderType.BASICDETAILS_NEXTOFKIN;
    }
    
}
