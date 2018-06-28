/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.parser;

import DataFields.DataField;
import DataFields.OptionsDataField;
import DataFields.TextDataField;
import com.lea.gui.formfields.FormField;
import com.lea.gui.formfields.OptionsFormField;
import com.lea.gui.formfields.TextFormField;

/**
 *
 * @author Lea
 */
public class GuiDataParser {
    
    public FormField getFormField(DataField data) {
        if (data instanceof TextDataField) {
            return new TextFormField(data.getLabelText(),((TextDataField) data).getPlaceholder());
        }
        else if (data instanceof OptionsDataField) {
            return new OptionsFormField(data.getLabelText(), ((OptionsDataField) data).getOptions());
        }
        return null;
    }
    
}
