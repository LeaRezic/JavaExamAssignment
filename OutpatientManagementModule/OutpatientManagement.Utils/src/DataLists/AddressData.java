/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLists;

import DataFields.DataField;
import DataFields.TextDataField;

/**
 *
 * @author Lea
 */
public class AddressData {
    
    public DataField fullStreet;
    public DataField pinCode;
    public DataField cityName;

    public AddressData() {
        fullStreet = new TextDataField("Full street");
        pinCode = new TextDataField("PIN Code");
        cityName = new TextDataField("City");
    }

    public DataField getFullStreet() {
        return fullStreet;
    }

    public void setFullStreet(DataField fullStreet) {
        this.fullStreet = fullStreet;
    }

    public DataField getPinCode() {
        return pinCode;
    }

    public void setPinCode(DataField pinCode) {
        this.pinCode = pinCode;
    }

    public DataField getCityName() {
        return cityName;
    }

    public void setCityName(DataField cityName) {
        this.cityName = cityName;
    }
    
    
    
    
    
}
