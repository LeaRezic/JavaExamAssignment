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
public class TextDataField extends DataField {
    
    public String placeholder;
    public String inputValue;

    public TextDataField(String labelText) {
        super(labelText);
    }

    public TextDataField(String labelText, String placeholder) {
        super(labelText);
        this.placeholder = placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }
    
    @Override
    public Boolean isValid() {
        return !(getInputValue() == null) && !(getInputValue().trim().isEmpty());
    }
    
    @Override
    public String getErrorMessage() {
        return super.getLabelText() + " is a mandatory field.";
    }
    
}
