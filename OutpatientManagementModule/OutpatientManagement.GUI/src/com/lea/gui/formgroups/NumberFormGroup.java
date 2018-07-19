/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formgroups;

import javax.swing.JComponent;
import javax.swing.JSpinner;

/**
 *
 * @author Lea
 */
public class NumberFormGroup extends FormGroup {

    public JSpinner spinner;
    public int maxValue;
    
    public NumberFormGroup(String labelText, int max) {
        super(labelText);
        maxValue = max;
        spinner = new JSpinner();
    }

    @Override
    public Boolean isValid() {
        return isNumber();
    }

    @Override
    public String getErrorMessage() {
        return super.label.getText() + " must be a number between 0 and " + maxValue;
    }

    @Override
    public JComponent getComponent() {
        return spinner;
    }

    @Override
    public Object getValue() {
        return spinner.getValue();
    }

    @Override
    public void setValue(Object value) {
        spinner.setValue((int) value);
    }

    @Override
    public String getReadOnlyValue() {
        return getValue().toString();
    }
    
    private boolean isNumber() {
        try {
            int value = Integer.parseInt(getReadOnlyValue());
            return value >= 0 && value <= maxValue;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}