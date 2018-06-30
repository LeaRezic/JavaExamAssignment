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
public class PersonalDetailsVM extends ViewModel {
    private int idpersonalDetails;
     private String maritalStatus;
     private String occupation;
     private Double height;
     private Double weight;
     private String bloodTypeRh;

    public PersonalDetailsVM() {
    }

    public PersonalDetailsVM(int idpersonalDetails, String maritalStatus, String occupation, Double height, Double weight, String bloodTypeRh) {
        this.idpersonalDetails = idpersonalDetails;
        this.maritalStatus = maritalStatus;
        this.occupation = occupation;
        this.height = height;
        this.weight = weight;
        this.bloodTypeRh = bloodTypeRh;
    }

    public int getIdpersonalDetails() {
        return idpersonalDetails;
    }

    public void setIdpersonalDetails(int idpersonalDetails) {
        this.idpersonalDetails = idpersonalDetails;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getBloodTypeRh() {
        return bloodTypeRh;
    }

    public void setBloodTypeRh(String bloodTypeRh) {
        this.bloodTypeRh = bloodTypeRh;
    }
     
     
}
