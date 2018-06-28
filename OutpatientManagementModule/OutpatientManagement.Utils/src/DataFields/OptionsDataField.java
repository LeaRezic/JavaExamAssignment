/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataFields;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lea
 */
public class OptionsDataField extends DataField {
    
    final List<String> options;
    
    public OptionsDataField(String labelText, List<String> options) {
        super(labelText);
        this.options = new ArrayList<String>(options);
    }

    public List<String> getOptions() {
        return options;
    }

    @Override
    public Boolean isValid() {
        return true;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

}
