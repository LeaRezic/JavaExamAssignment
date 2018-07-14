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
public class HospitalServiceCategoryVM extends ViewModel {
     private String name;

    public HospitalServiceCategoryVM(int id) {
        super(id);
    }

    public HospitalServiceCategoryVM(int idhospitalServiceCategory, String name) {
        super(idhospitalServiceCategory);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
     
}
