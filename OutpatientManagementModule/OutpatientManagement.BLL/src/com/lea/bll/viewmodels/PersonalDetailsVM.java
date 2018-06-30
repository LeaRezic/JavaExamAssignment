/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;

import java.util.Date;

/**
 *
 * @author Lea
 */
public class PersonalDetailsVM extends ViewModel {

    public enum MaritalStatus {
        MARRIED, SINGLE, DIVORCED, WIDOWED, CIVIL_PARTNERSHIP
    }
    
    public enum BloodType {
        A_PLUS, A_MINUS, B_PLUS, B_MINUS, AB_PLUS, AB_MINUS, ZERO_PLUS, ZERO_MINUS
    }

    private int idpersonalDetails;
    private String bloodType;
    private String maritalStatus;
    private Boolean sex;
    private Date dateOfBirth;
    private String occupation;
    private Double height;
    private Double weight;

    public PersonalDetailsVM() {
    }

    public PersonalDetailsVM(int idpersonalDetails) {
        this.idpersonalDetails = idpersonalDetails;
    }

    public PersonalDetailsVM(int idpersonalDetails, String bloodType, String maritalStatus, Boolean sex, Date dateOfBirth, String occupation, Double height, Double weight) {
        this.idpersonalDetails = idpersonalDetails;
        this.bloodType = bloodType;
        this.maritalStatus = maritalStatus;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.occupation = occupation;
        this.height = height;
        this.weight = weight;
    }

    public int getIdpersonalDetails() {
        return this.idpersonalDetails;
    }

    public void setIdpersonalDetails(int idpersonalDetails) {
        this.idpersonalDetails = idpersonalDetails;
    }

    public String getBloodType() {
        return this.bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean getSex() {
        return this.sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
