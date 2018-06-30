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
public class BasicDetailsVM extends ViewModel {
    
    private int idbasicDetails;
    private CityVM city;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullStreet;
    private String pincode;
    private String telephone;
    private String mobilePhone;
    private String email;

    public BasicDetailsVM() {
        city = new CityVM();
    }

    public BasicDetailsVM(int idbasicDetails, CityVM city, String firstName, String lastName, String fullStreet, String pincode) {
        this.idbasicDetails = idbasicDetails;
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullStreet = fullStreet;
        this.pincode = pincode;
    }

    public BasicDetailsVM(int idbasicDetails, CityVM city, String firstName, String middleName, String lastName, String fullStreet, String pincode, String telephone, String mobilePhone, String email) {
        this.idbasicDetails = idbasicDetails;
        this.city = city;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fullStreet = fullStreet;
        this.pincode = pincode;
        this.telephone = telephone;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }

    public int getIdbasicDetails() {
        return this.idbasicDetails;
    }

    public void setIdbasicDetails(int idbasicDetails) {
        this.idbasicDetails = idbasicDetails;
    }

    public CityVM getCityVM() {
        return this.city;
    }

    public void setCityVM(CityVM city) {
        this.city = city;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "BasicDetailsVM{" + "idbasicDetails=" + idbasicDetails + "City=" + city.getName() + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + '}';
    }
    
    
    
}
