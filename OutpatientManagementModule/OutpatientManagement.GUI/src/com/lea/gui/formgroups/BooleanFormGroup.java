/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formgroups;

import java.util.Arrays;

/**
 *
 * @author Lea
 */
public class BooleanFormGroup extends OptionTextFormGroup {

    public BooleanFormGroup(String labelText) {
        super(labelText, Arrays.asList(new String[]{"YES", "NO"}));
    }

    @Override
    public void setValue(Object value) {
        if ((boolean) value == true) {
            super.setValue("YES");
        } else {
            super.setValue("NO");
        }
    }

    @Override
    public Object getValue() {
        return ("YES".equals((String) super.getValue()));
    }

}
