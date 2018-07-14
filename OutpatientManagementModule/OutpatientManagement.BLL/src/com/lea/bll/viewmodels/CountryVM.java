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
     private String name;

    public CountryVM(int id) {
        super(id);
    }
	
    public CountryVM(int idcountry, String name) {
        super(idcountry);
        this.name = name;
    }
   
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


}
