/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formgroups;

import com.lea.utilities.InputValidator;

/**
 *
 * @author Lea
 */
public class OpidFormGroup extends TextFormGroup {
    
    public OpidFormGroup(String labelText) {
        super(labelText);
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        message += super.getErrorMessage();
        if (!InputValidator.isValidOpid((String) getValue())) {
            message += "\n" + super.getLabel().getText() + " has to be 11 characters, digits only (0-9).";
        }
        return message;
    }

    @Override
    public Boolean isValid() {
        return super.isValid() && InputValidator.isValidOpid((String) getValue());
    }
    
}
