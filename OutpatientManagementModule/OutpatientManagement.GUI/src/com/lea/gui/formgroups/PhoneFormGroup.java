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
public class PhoneFormGroup extends TextFormGroup {

    public PhoneFormGroup(String labelText) {
        super(labelText);
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        if (!super.isValid()) {
            message += super.getErrorMessage() + "\n";
        }
        if (!isValidPhoneNumber()) {
            message += super.getLabel().getText() + " should be digits only, in format xxx-xxxxxxx";
        }
        return message;
    }

    @Override
    public Boolean isValid() {
        return super.isValid() && isValidPhoneNumber();
    }

    private boolean isValidPhoneNumber() {
        if (!textField.getText().isEmpty()) {
            return InputValidator.isValidPhoneNumber(textField.getText());
        }
        return true;
    }

}
