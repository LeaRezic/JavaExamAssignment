/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;

import java.math.BigDecimal;

/**
 *
 * @author Lea
 */
public class HospitalServiceVM extends ViewModel {
    private int idhospitalService;
     private HospitalServiceCategoryVM hospitalServiceCategory;
     private String name;
     private String description;
     private BigDecimal basicPrice;

    public HospitalServiceVM() {
    }

    public HospitalServiceVM(int idhospitalService, HospitalServiceCategoryVM hospitalServiceCategory, String name, String description, BigDecimal basicPrice) {
        this.idhospitalService = idhospitalService;
        this.hospitalServiceCategory = hospitalServiceCategory;
        this.name = name;
        this.description = description;
        this.basicPrice = basicPrice;
    }

    public int getIdhospitalService() {
        return idhospitalService;
    }

    public void setIdhospitalService(int idhospitalService) {
        this.idhospitalService = idhospitalService;
    }

    public HospitalServiceCategoryVM getHospitalServiceCategory() {
        return hospitalServiceCategory;
    }

    public void setHospitalServiceCategory(HospitalServiceCategoryVM hospitalServiceCategory) {
        this.hospitalServiceCategory = hospitalServiceCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(BigDecimal basicPrice) {
        this.basicPrice = basicPrice;
    }
     
     
}
