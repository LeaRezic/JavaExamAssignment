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
public abstract class DataField implements DataFieldValidation {
    
    final String labelText;

    public DataField(String labelText) {
        this.labelText = labelText;
    }
    
    public String getLabelText() {
        return labelText;
    }

}
