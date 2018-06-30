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
    private int idhospitalServiceCategory;
     private String name;

    public HospitalServiceCategoryVM() {
    }

    public HospitalServiceCategoryVM(int idhospitalServiceCategory, String name) {
        this.idhospitalServiceCategory = idhospitalServiceCategory;
        this.name = name;
    }

    public int getIdhospitalServiceCategory() {
        return idhospitalServiceCategory;
    }

    public void setIdhospitalServiceCategory(int idhospitalServiceCategory) {
        this.idhospitalServiceCategory = idhospitalServiceCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     
     
}
