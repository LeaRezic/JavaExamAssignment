/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formgroups;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Lea
 */
public abstract class FormGroup {

    public JLabel label;
    public String errorMessage;
    public Boolean isMandatory;

    public FormGroup(String labelText) {
        label = new JLabel(labelText);
        this.isMandatory = false;
    }

    public FormGroup(String labelText, String errorMessage) {
        label.setText(labelText);
        this.errorMessage = errorMessage;
    }
    
    public void setIsMandatory(Boolean isMandatory) {
        this.isMandatory = isMandatory;
        label.setForeground(new Color(139,0,0));
        //label.setText(label.getText() + " *");
    }
    
    public JLabel getLabel() {
        return label;
    }

    public abstract void setValue(Object value);
    
    public abstract JComponent getComponent();
    
    public abstract Object getValue();

    public Boolean isValid() {
        return true;
    }

    public String getErrorMessage() {
        return null;
    }
    
    public abstract String getReadOnlyValue();

}
