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
public class CountryVM extends ViewModel {
    private int idcountry;
     private String name;

    public CountryVM() {
    }

	
    public CountryVM(int idcountry, String name) {
        this.idcountry = idcountry;
        this.name = name;
    }
    
    public int getIdcountry() {
        return this.idcountry;
    }
    
    public void setIdcountry(int idcountry) {
        this.idcountry = idcountry;
    }

   
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


}
