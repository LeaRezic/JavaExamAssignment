/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formgroups;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 *
 * @author Lea
 */
public class OptionFormGroup extends FormGroup {

    public JComboBox comboBox;
    private final DefaultComboBoxModel<String> comboModel;
    private final List<String> options;

    public OptionFormGroup(String labelText, List<String> options) {
        super(labelText);
        this.options = options;
        comboBox = new JComboBox();
        comboModel = new DefaultComboBoxModel<>();
        setComboBoxOptions(options);
    }

    @Override
    public JComponent getComponent() {
        return comboBox;
    }

    private void setComboBoxOptions(List<String> options) {

        options.forEach((option) -> {
            comboModel.addElement(option);
        });
        comboBox.setModel(comboModel);

    }

    @Override
    public Object getValue() {
        return comboBox.getSelectedItem();
    }

    @Override
    public void setValue(Object value) {
        comboBox.setSelectedIndex(options.indexOf((String) value));
    }

}
