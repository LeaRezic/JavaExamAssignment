/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formgroups;

/**
 *
 * @author Lea
 */
public class DoubleFormGroup extends TextFormGroup {

    public DoubleFormGroup(String labelText) {
        super(labelText);
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        message += super.getErrorMessage();
        if (!isPositiveDoubleValue()) {
            message += "\n" + super.getLabel().getText() + " has to be a positive decimal value";
        }
        return message;
    }

    @Override
    public Boolean isValid() {
        return super.isValid() && isPositiveDoubleValue();
    }

    private Boolean isPositiveDoubleValue() {
        if (textField.getText().isEmpty()) {
            return true;
        }
        try {
            double number = Double.parseDouble(textField.getText());
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public Object getValue() {
        return Double.parseDouble(textField.getText());
    }

    

}
