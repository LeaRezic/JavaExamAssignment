/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataFields;

/**
 *
 * @author Lea
 */
public class NumberDataField extends TextDataField {

    public NumberDataField(String labelText) {
        super(labelText);
    }

    @Override
    public String getErrorMessage() {
        return super.getLabelText() + " is a mandatory, number only field.";
    }

    @Override
    public Boolean isValid() {
        return super.isValid();
    }

}
