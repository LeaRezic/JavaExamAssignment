/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formgroups;

import com.lea.utilities.DateConverter;
import java.text.ParseException;

/**
 *
 * @author Lea
 */
public class DateFormGroup extends TextFormGroup {

    public DateFormGroup(String labelText) {
        super(labelText);
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        if (!super.isValid()) {
            message += super.getErrorMessage() + "\n";
        }
        if (!isValidDate()) {
            message += super.getLabel().getText() + " must be in format dd/MM/yyyy.";
        }
        return message;
    }

    @Override
    public Boolean isValid() {
        return super.isValid() && isValidDate();
    }

    private boolean isValidDate() {
        if (textField.getText().isEmpty()) {
            return true;
        }
        try {
            DateConverter.getDateFromString(textField.getText());
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

}
