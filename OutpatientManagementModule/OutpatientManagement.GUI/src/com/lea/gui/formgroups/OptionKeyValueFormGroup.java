/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formgroups;

import com.lea.utilities.OptionKeyValue;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 *
 * @author Lea
 */
public class OptionKeyValueFormGroup extends FormGroup {

    public JComboBox comboBox;
    private DefaultComboBoxModel<OptionKeyValue> comboModel;
    private List<OptionKeyValue> options;

    public OptionKeyValueFormGroup(String labelText, List<OptionKeyValue> options) {
        super(labelText);
        this.options = options;
        comboBox = new JComboBox();
        setComboBoxOptions(options);
    }

    public void resetOptions(List<OptionKeyValue> options) {
        this.options = options;
        setComboBoxOptions(options);
    }

    @Override
    public JComponent getComponent() {
        return comboBox;
    }

    private void setComboBoxOptions(List<OptionKeyValue> options) {
        comboModel = new DefaultComboBoxModel<>();
        options.forEach((option) -> {
            comboModel.addElement(option);
        });
        comboBox.setModel(comboModel);
    }

    @Override
    public Object getValue() {
        return ((OptionKeyValue) comboBox.getSelectedItem()).getKey();
    }

    @Override
    public void setValue(Object value) {
        int key = (int) value;
        OptionKeyValue okv = options.stream().filter(o -> o.getKey() == key).findFirst().orElse(null);
        // ovo je kritično i sigurno krivo :D
        if (okv != null) {
            int index = options.indexOf(okv);
            comboBox.setSelectedIndex(index);
        }
    }

    @Override
    public String getReadOnlyValue() {
        return ((OptionKeyValue) comboBox.getSelectedItem()).getValue();
    }

}
