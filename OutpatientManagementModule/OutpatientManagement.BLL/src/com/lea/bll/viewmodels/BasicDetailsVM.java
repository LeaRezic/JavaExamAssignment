/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;

import com.lea.dal.domain.entities.City;
import com.lea.dal.domain.entities.Country;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lea
 */
public class BasicDetailsVM extends ViewModel {

    private int idbasicDetails;
    private String cityName;
    private String countryName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullStreet;
    private String pincode;
    private String telephone;
    private String mobilePhone;
    private String email;
    
    private List<String> allCities;
    private List<String> allCountries;

    public List<String> getAllCities() {
        return allCities;
    }

    public void setAllCities(List<String> allCities) {
        this.allCities = allCities;
    }

    public List<String> getAllCountries() {
        return allCountries;
    }

    public void setAllCountries(List<String> allCountries) {
        this.allCountries = allCountries;
    }
    
//    private List<City> allCities;
//    private List<Country> allCountries;
//
//    public List<City> getAllCities() {
//        return allCities;
//    }
//
//    public void setAllCities(List<City> allCities) {
//        this.allCities = allCities;
//    }
//
//    public List<Country> getAllCountries() {
//        return allCountries;
//    }
//
//    public void setAllCountries(List<Country> allCountries) {
//        this.allCountries = allCountries;
//    }
    

    public BasicDetailsVM() {
        allCities = new ArrayList<>();
        allCountries = new ArrayList<>();
    }

    public BasicDetailsVM(int idbasicDetails, String cityName, String countryName, String firstName, String middleName, String lastName, String fullStreet, String pincode, String telephone, String mobilePhone, String email) {
        this.idbasicDetails = idbasicDetails;
        this.cityName = cityName;
        this.countryName = countryName;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
        return "BasicDetailsVM{" + "idbasicDetails=" + idbasicDetails + "City=" + cityName + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + '}';
    }

}
