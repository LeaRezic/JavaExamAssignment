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
public class EmailFormGroup extends TextFormGroup {

    public EmailFormGroup(String labelText) {
        super(labelText);
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        if (!super.isValid()) {
            message += super.getErrorMessage() + "\n";
        }
        if (!isValidEmail()) {
            message += super.getLabel().getText() + " has to be a valid E-mail address.";
        }
        return message;
    }

    @Override
    public Boolean isValid() {
        return super.isValid() && isValidEmail();
    }
    
    private boolean isValidEmail() {
        if (!textField.getText().isEmpty()) {
            return InputValidator.isValidEmail(textField.getText());
        }
        return true;
    }

}
