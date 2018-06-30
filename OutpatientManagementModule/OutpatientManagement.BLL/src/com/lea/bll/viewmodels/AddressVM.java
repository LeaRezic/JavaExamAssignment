/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;


/**
 *
 * @author Lea
 */
public class AddressVM extends ViewModel {
    private int idaddress;
     private CityVM city;
     private String fullStreet;
     private String pincode;

    public AddressVM() {
    }
	
    public AddressVM(int idaddress, CityVM city, String fullStreet, String pincode) {
        this.idaddress = idaddress;
        this.city = city;
        this.fullStreet = fullStreet;
        this.pincode = pincode;
    }
   
    public int getIdaddress() {
        return this.idaddress;
    }
    
    public void setIdaddress(int idaddress) {
        this.idaddress = idaddress;
    }
    
    public CityVM getCityVM() {
        return this.city;
    }
    
    public void setCityVM(CityVM city) {
        this.city = city;
    }
    
    public String getFullStreet() {
        return this.fullStreet;
    }
    
    public void setFullStreet(String fullStreet) {
        this.fullStreet = fullStreet;
    }

    public String getPincode() {
        return this.pincode;
    }
    
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }


}
