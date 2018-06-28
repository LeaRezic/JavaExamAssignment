/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formfields;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 *
 * @author Lea
 */
public class OptionsFormField extends FormField {

    final JComboBox comboBox;

    public OptionsFormField(String labelText, List<String> options) {
        super(labelText);
        this.comboBox = new JComboBox();
        options.addAll(options);
    }

    @Override
    public JComponent getComponent() {
        return comboBox;
    }

}
