/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Lea
 */
public class CityVM {
    private int idcity;
     private CountryVM country;
     private String name;

    public CityVM() {
    }

	
    public CityVM(int idcity, CountryVM country, String name) {
        this.idcity = idcity;
        this.country = country;
        this.name = name;
    }
   
    public int getIdcity() {
        return this.idcity;
    }
    
    public void setIdcity(int idcity) {
        this.idcity = idcity;
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
