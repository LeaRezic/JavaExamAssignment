/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formgroups;

import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Lea
 */
public class TextFormGroup extends FormGroup {

    public JTextField textField;
    
    public TextFormGroup(String labelText) {
        super(labelText);
        textField = new JTextField();
    }

    @Override
    public Boolean isValid() {
        return !isMandatory || !textField.getText().trim().isEmpty();
    }

    @Override
    public String getErrorMessage() {
        return super.label.getText() + " is a mandatory field!";
    }

    @Override
    public JComponent getComponent() {
        return textField;
    }

    @Override
    public Object getValue() {
        return textField.getText();
    }
    
}
