/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.output.gui;

import com.lea.bll.datamanagers.DdlDataManager;
import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.OptionKeyValueFormGroup;
import javax.swing.JComboBox;

/**
 *
 * @author Lea
 */
public class Testing_Okv {

    public static void main(String[] args) {

        DdlDataManager DdlManager = new DdlDataManager();

        FormGroup ddlCities = new OptionKeyValueFormGroup("City", DdlManager.getAllCities());
        FormGroup ddlCountries = new OptionKeyValueFormGroup("Country", DdlManager.getAllCountries());

        //JComboBox wtf = ((JComboBox) ddlCities.getValue());
        System.out.println(((JComboBox) ddlCities.getComponent()).getItemCount());
        System.out.println(((JComboBox) ddlCountries.getComponent()).getItemCount());
    }

}
