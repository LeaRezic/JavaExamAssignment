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
public class CityVM extends ViewModel {
     private CountryVM country;
     private String name;

    public CityVM(int id) {
        super(id);
    }

	
    public CityVM(int idcity, CountryVM country, String name) {
        super(idcity);
        this.country = country;
        this.name = name;
    }

    public CountryVM getCountryVM() {
        return this.country;
    }
    
    public void setCountryVM(CountryVM country) {
        this.country = country;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


}
