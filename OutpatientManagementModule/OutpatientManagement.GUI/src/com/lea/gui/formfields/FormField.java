/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formfields;

import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Lea
 */
public abstract class FormField {
    
    final JLabel label;

    public FormField(String labelText) {
        this.label = new JLabel();
        label.setText(labelText);
    }

    public JLabel getLabel() {
        return label;
    }
    
    public abstract JComponent getComponent();
    
    
    
}
