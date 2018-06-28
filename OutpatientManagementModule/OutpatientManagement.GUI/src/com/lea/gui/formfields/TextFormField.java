/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formfields;

import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Lea
 */
public class TextFormField extends FormField {
    
    public final String placeholder;
    public final JTextField textField;
    
    public TextFormField(String labelText, String placeholder) {
        super(labelText);
        this.placeholder = placeholder;
        textField = new JTextField();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    public JComponent getComponent() {
        return textField;
    }
    
    
    
    
}
